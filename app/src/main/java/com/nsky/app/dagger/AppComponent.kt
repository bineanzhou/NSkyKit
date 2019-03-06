package com.nsky.app.dagger

import com.nsky.app.NSkyApplication
import com.nsky.app.MainActivityModule
import com.nsky.app.home.ButtonsFragment
import com.nsky.app.home.HomeFragment
import com.nsky.kit.dagger.scope.ApplicationScope
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by zhoubin on 2019/1/30.
 **/

@Singleton
@ApplicationScope
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,
        SupportFragmentBindingModule::class,
        ActivityBindingModule::class
        ]
)
interface AppComponent : AndroidInjector<NSkyApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<NSkyApplication>()


}