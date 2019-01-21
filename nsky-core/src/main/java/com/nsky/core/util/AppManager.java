package com.nsky.core.util;


import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.orhanobut.logger.Logger;

import java.security.MessageDigest;


/**
 * <p>Utils初始化相关 </p>
 */
public class AppManager {

    private static Application application;
    private static boolean APP_DEBUG = false;


    private AppManager() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param application 上下文
     */
    public static void init(Application application, boolean debug) {
        AppManager.application = application;
        APP_DEBUG = debug;
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Application getApplication() {
        if (application != null) return application;
        throw new NullPointerException("u should init first");
    }

    /**
     * View获取Activity的工具
     *
     * @param view view
     * @return Activity
     */
    public static
    @NonNull
    Activity getActivity(View view) {
        Context context = view.getContext();

        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }

        throw new IllegalStateException("View " + view + " is not attached to an Activity");
    }

    /**
     * 全局获取String的方法
     *
     * @param id 资源Id
     * @return String
     */
    public static String getString(@StringRes int id) {
        return application.getResources().getString(id);
    }


    /**
     * 判断App是否是Debug版本
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isAppDebug() {
        return APP_DEBUG;
    }


    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     */
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }


    public static <T> T checkNotNull(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        return obj;
    }


    public static String getFileAuthorities() {
        return AppManager.getApplication().getPackageName() + ".provider";
    }

    /**
     * 校验签名
     *
     * @param apkSign
     */
    public static boolean checkApkSign(Context context, String apkSign) {
        try {
            String appSign = getApkSign(context);
            Logger.d("apkSign:" + appSign);
            return appSign.compareToIgnoreCase(apkSign) == 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取apk签名
     *
     * @param ctx
     * @return
     */
    public static String getApkSign(Context ctx) {
        try {
            PackageInfo packageInfo = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(),
                    PackageManager.GET_SIGNATURES);
            Signature[] signs = packageInfo.signatures;
            Signature sign = signs[0];
            MessageDigest md1 = MessageDigest.getInstance("MD5");
            md1.update(sign.toByteArray());
            byte[] digest = md1.digest();
            String md5 = Byte2HexUtil.toHexString(digest);
//            MessageDigest md2 = MessageDigest.getInstance("SHA1");
//            md2.update(sign.toByteArray());
//            byte[] digest2 = md2.digest();
//            String res2 = toHexString(digest2);
            return md5;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}