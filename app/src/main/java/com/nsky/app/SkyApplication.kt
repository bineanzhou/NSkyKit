package com.nsky.app

import android.app.Application
import android.content.Context
import com.nsky.core.CoreAppExt

/**
 * Created by zhoubin on 2019/1/17.
 **/
class SkyApplication:Application(){
    override fun onCreate() {
        super.onCreate()
        CoreAppExt.onCreate(this, true)

    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        CoreAppExt.attachBaseContext(base)
    }


}