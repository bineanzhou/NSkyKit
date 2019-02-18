package com.nsky.app.model

import com.nsky.app.viewmodel.MainViewModel
import com.nsky.kit.utils.AppManager
import dagger.Module
import dagger.Provides

/**
 * Created by zhoubin on 2019/1/31.
 **/
@Module
class MainDaggerModule {

    @Provides
    fun provideMainViewModel(): MainViewModel {
        return MainViewModel(AppManager.getApplication())
    }

}
