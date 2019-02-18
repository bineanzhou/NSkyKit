package com.nsky.app

import android.content.Context
import com.nsky.app.dagger.DaggerApplicationComponent
import com.nsky.kit.core.CoreAppExt
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by zhoubin on 2019/1/17.
 **/
class SkyApplication:DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        CoreAppExt.onCreate(this, true)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        CoreAppExt.attachBaseContext(base)
    }
}