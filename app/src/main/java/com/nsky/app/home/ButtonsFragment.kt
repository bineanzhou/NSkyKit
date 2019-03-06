package com.nsky.app.home

import android.support.v4.app.Fragment
import android.view.View
import com.nsky.app.R
import com.nsky.app.databinding.CatButtonsFragmentBinding
import com.nsky.app.home.model.FeatureDemo
import com.nsky.kit.dagger.CoreDaggerFragment
import com.nsky.kit.dagger.scope.ActivityScope
import com.nsky.kit.dagger.scope.FragmentScope
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoSet

/**
 * Created by zhoubin on 2019/3/5.
 **/

class ButtonsFragment : CoreDaggerFragment<CatButtonsFragmentBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.cat_buttons_fragment
    }

    override fun onBindView(contentView: View?) {
    }


    @dagger.Module
    class Module{
        @IntoSet
        @Provides
        fun provideFeatureDemo(): FeatureDemo {
            return object : FeatureDemo(R.string.cat_buttons_title, R.mipmap.ic_button) {
                override fun getFragmentClass(): Class<out Fragment> {
                    return ButtonsFragment::class.java
                }

                override fun createFragment(): Fragment {
                    return ButtonsFragment()
                }
            }
        }
    }



}