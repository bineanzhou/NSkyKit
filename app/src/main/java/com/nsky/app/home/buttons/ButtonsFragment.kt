package com.nsky.app.home.buttons

import android.support.v4.app.Fragment
import android.view.View
import com.nsky.app.R
import com.nsky.app.databinding.CatButtonsFragmentBinding
import com.nsky.app.home.model.FeatureBlock
import com.nsky.kit.dagger.CoreDaggerFragment
import dagger.Provides
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
        fun provideFeatureBlock(): FeatureBlock {
            return object : FeatureBlock(R.string.cat_buttons_title, R.mipmap.ic_button) {
                override fun getFragmentClass(): Class<out Fragment> {
                    return ButtonsFragment::class.java
                }

                override fun createFragment(): Fragment {
                    return ButtonsFragment()
                }
            }
        }

        @IntoSet
        @Provides
        fun provideFeatureBlock1(): FeatureBlock {
            return object : FeatureBlock(R.string.cat_buttons_title, R.mipmap.ic_button) {
                override fun getFragmentClass(): Class<out Fragment> {
                    return ButtonsFragment::class.java
                }

                override fun createFragment(): Fragment {
                    return ButtonsFragment()
                }
            }
        }

        @IntoSet
        @Provides
        fun provideFeatureBlock2(): FeatureBlock {
            return object : FeatureBlock(R.string.cat_buttons_title, R.mipmap.ic_block) {
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