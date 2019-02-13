package com.nsky.kit.ui

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

/**
 *
 * Fragments适配器

 * @name ResourcePagerAdapter
 */
class CoreFragmentPagerAdapter(fm: FragmentManager, private val mFragments: List<Fragment>?) : FragmentStatePagerAdapterCompat(fm) {

    override fun getItem(position: Int): Fragment {
        return mFragments?.get(position) ?: Fragment()
    }

    override fun getCount(): Int {
        return mFragments?.size ?: 0
    }

    override fun getItemPosition(obj: Any): Int {
        return android.support.v4.view.PagerAdapter.POSITION_NONE
    }
}
