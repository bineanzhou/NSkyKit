/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.nsky.kit.ui

import android.os.Parcelable
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

abstract class FragmentStatePagerAdapterCompat(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
    override fun saveState(): Parcelable? {
        return null
    }
}