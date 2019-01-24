package com.qihoo.adwallet.common.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context
import android.content.res.Resources
import com.orhanobut.logger.Logger

/**
 * Created by zhoubin on 2018/8/30.
 */
abstract class CoreViewModel : AndroidViewModel, IViewModel {
    val TAG = javaClass.simpleName
    private val DEBUG:Boolean = false

    init {
        if(DEBUG)
        {
            Logger.i("$TAG:init")
        }

    }

    constructor(application: Application) : super(application) {
        if(DEBUG)
        {
            Logger.i("$TAG:constructor(application: Application)")
        }
    }

    fun getApplicationContext(): Context = getApplication<Application>().applicationContext
    fun getResources(): Resources = getApplication<Application>().resources

    override fun onCleared() {
        super.onCleared()
        if(DEBUG)
        {
            Logger.i( "$TAG:onCleared")
        }
    }
}