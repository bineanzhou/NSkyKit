package com.nsky.kit.dagger

import android.content.Context
import android.databinding.ViewDataBinding
import android.support.v4.app.Fragment
import com.nsky.kit.arch.CoreFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by zhoubin on 2019/2/18.
 **/

abstract class CoreDaggerFragment<T : ViewDataBinding>  : CoreFragment<T>(), HasSupportFragmentInjector {

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return childFragmentInjector
    }
}
