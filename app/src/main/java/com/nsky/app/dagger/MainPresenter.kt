package com.nsky.app.dagger

import javax.inject.Inject

/**
 * Created by zhoubin on 2019/1/31.
 **/

class MainPresenter @Inject constructor(){
    fun doSomething(): String {
        return "This is result"
    }
}