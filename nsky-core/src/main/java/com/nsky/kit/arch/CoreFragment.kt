package com.nsky.kit.arch

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nsky.kit.ext.bind

/**
 * Created by zhoubin on 2019/1/24.
 **/
abstract class CoreFragment<T : ViewDataBinding> : Fragment() {
    private var mContentView: View? = null
    lateinit var mViewDataBinding: T


    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun onBindView(contentView: View?)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mContentView == null) {
            inflater.apply {
                mViewDataBinding = bind<T>(inflater, layoutId = getLayoutId(), parent = container)
                mContentView = mViewDataBinding.root
            }
        } else {
            // remove from parent avoiding "Cannot add a null child view to a ViewGroup"
            (mContentView?.parent as? ViewGroup)?.removeView(mContentView)
        }

        onBindView(mContentView)
        return mContentView
    }


}