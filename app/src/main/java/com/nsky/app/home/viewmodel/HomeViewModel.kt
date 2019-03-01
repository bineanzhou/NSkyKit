package com.nsky.app.home.viewmodel

import android.app.Application
import com.qihoo.adwallet.common.viewmodel.CoreViewModel

/**
 * Created by zhoubin on 2019/2/28.
 **/
class HomeViewModel(application: Application) : CoreViewModel(application) {
    fun doSomething(): String {
        return "This is HomeViewModel"
    }
}