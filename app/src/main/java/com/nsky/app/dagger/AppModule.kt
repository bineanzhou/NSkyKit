package com.nsky.app.dagger

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.nsky.app.MainActivity
import com.nsky.app.MainActivityModule
import com.nsky.app.NSkyApplication
import com.nsky.app.discover.DiscoverFragment
import com.nsky.app.home.HomeFragment
import com.nsky.app.setting.SettingFragment
import com.nsky.kit.dagger.scope.ActivityScope
import com.nsky.kit.utils.NSkyLog
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton


/**
 * Created by zhoubin on 2019/2/18.
 **/
@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity
}

/**
 * SupportFragment Dagger2 Module
 */
@Module
abstract class SupportFragmentBindingModule {
    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun discoverFragment(): DiscoverFragment

    @ContributesAndroidInjector
    abstract fun settingFragment(): SettingFragment

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

        var sharePref = PreferenceManager.getDefaultSharedPreferences(application)
        NSkyLog.d(AppModule::class.java.simpleName, "provideSharedPreferences ${sharePref.toString()}")
        return sharePref;
    }
}
