package com.nsky.app.dagger

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.nsky.app.MainActivity
import com.nsky.app.home.HomeFragment
import com.nsky.app.discover.DiscoverFragment
import com.nsky.app.MainActivityModule
import com.nsky.app.setting.SettingFragment
import com.nsky.kit.dagger.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton
import dagger.Provides
import com.nsky.app.NSkyApplication
import com.orhanobut.logger.Logger


/**
 * Created by zhoubin on 2019/2/18.
 **/
@Module
abstract class ContributeActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity
}

/**
 * SupportFragment Dagger2 Module
 */
@Module
abstract class ContributeSupportFragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeDiscoverFragment(): DiscoverFragment

    @ContributesAndroidInjector
    abstract fun contributeSettingFragment(): SettingFragment

}

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: NSkyApplication): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(application: NSkyApplication): SharedPreferences {
        Logger.d("provideSharedPreferences")
        return PreferenceManager.getDefaultSharedPreferences(application)
    }
}
