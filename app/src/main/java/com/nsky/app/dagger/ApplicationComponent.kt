package com.nsky.app.dagger

import com.nsky.app.SkyApplication
import com.nsky.app.home.model.HomeDaggerModule
import com.nsky.app.model.MainDaggerModule
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
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        SupportFragmentModule::class,
        MainDaggerModule::class,
        HomeDaggerModule::class]
)
interface ApplicationComponent : AndroidInjector<SkyApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<SkyApplication>()

}