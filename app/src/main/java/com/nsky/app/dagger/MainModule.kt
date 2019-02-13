package com.nsky.app.dagger

import dagger.Module
import dagger.Provides

/**
 * Created by zhoubin on 2019/1/31.
 **/
@Module
class MainModule {

    @Provides
    fun provideMainService():MainService{
        return MainServiceImpl()
    }
}
