package com.nsky.app.dagger

import com.nsky.app.MainActivity
import dagger.Component

/**
 * Created by zhoubin on 2019/1/30.
 **/
@Component(modules = [(MainModule::class)])
interface MainComponent {
    fun inject(activity:MainActivity)
}