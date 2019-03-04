package com.nsky.app.dagger

import com.nsky.app.NSkyApplication
import com.nsky.app.MainActivityModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by zhoubin on 2019/1/30.
 **/

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        SupportFragmentBindingModule::class,
        MainActivityModule::class
        ]
)
interface AppComponent : AndroidInjector<NSkyApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<NSkyApplication>()


}