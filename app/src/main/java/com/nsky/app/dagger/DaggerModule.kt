package com.nsky.app.dagger

import com.nsky.app.MainActivity
import com.nsky.app.home.HomeFragment
import com.nsky.app.discover.DiscoverFragment
import com.nsky.app.setting.SettingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by zhoubin on 2019/2/18.
 **/
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}

/**
 * SupportFragment Dagger2 Module
 */
@Module
abstract class SupportFragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeCatalogFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeDiscoverFragment(): DiscoverFragment

    @ContributesAndroidInjector
    abstract fun contributeSettingFragment(): SettingFragment

}