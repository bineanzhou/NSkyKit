package com.nsky.core

import android.app.Application
import android.content.Context
import com.nsky.core.util.AppManager
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.orhanobut.logger.FormatStrategy




/**
 * Created by zhoubin on 2019/1/17.
 **/

object CoreAppExt{

    fun onCreate(app: Application?, debug: Boolean = false) {
        AppManager.init(app, debug)
        setupLogger()
        Logger.d("onCreate")
    }

    private fun setupLogger(){
        val formatStrategy = PrettyFormatStrategy.newBuilder()
//            .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
//            .methodCount(0)         // (Optional) How many method line to show. Default 2
//            .methodOffset(5)        // (Optional) Hides internal method calls up to offset. Default 5
//            .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
            .tag(AppManager.getApplication().packageName+"_LOGGER")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
            .build()
//        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))

        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return AppManager.isAppDebug()
            }
        })

    }

    fun attachBaseContext(base: Context?) {

    }
}