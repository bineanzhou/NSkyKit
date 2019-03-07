package com.nsky.app

import com.nsky.app.home.buttons.ButtonsFragment
import com.nsky.app.home.TocResourceProvider
import com.nsky.app.home.viewmodel.HomeViewModel
import com.nsky.app.viewmodel.MainViewModel
import com.nsky.kit.dagger.scope.ActivityScope
import com.nsky.kit.ext.getViewModel
import com.nsky.kit.utils.AppManager
import dagger.Provides


/**
 * Created by zhoubin on 2019/1/31.
 **/
@dagger.Module(
    includes = [
        ButtonsFragment.Module::class]
)
open class MainActivityModule {

    @ActivityScope
    @Provides
    fun provideMainViewModel(activity: MainActivity?): MainViewModel {
        try {
            activity?.apply {
                return getViewModel(MainViewModel::class.java)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return MainViewModel(AppManager.getApplication())
    }

    @ActivityScope
    @Provides
    fun provideHomeViewModel(activity: MainActivity?): HomeViewModel {
        try {

            activity?.apply {
                return getViewModel(HomeViewModel::class.java)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return HomeViewModel(AppManager.getApplication())
    }

    @Provides
    fun provideTocResourceProvider(): TocResourceProvider {
        return TocResourceProvider()
    }

}
