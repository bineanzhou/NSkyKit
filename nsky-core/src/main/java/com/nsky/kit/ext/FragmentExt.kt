package com.nsky.kit.ext

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by zhoubin on 2019/1/24.
 **/
fun <T: ViewDataBinding> Fragment.bind(@NonNull inflater: LayoutInflater,
                                        layoutId:Int,
                                        @Nullable parent: ViewGroup?=null,
                                        attachToParent:Boolean = false):T{

    return DataBindingUtil.inflate(
        inflater, layoutId, parent, attachToParent)

}
