package com.nsky.kit.ext

import android.annotation.SuppressLint
import android.support.design.bottomnavigation.LabelVisibilityMode
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.view.View


fun BottomNavigationView.resetBottomMenuView(size: Int) {
    val dp = (size * resources.displayMetrics.density).toInt()
    (getChildAt(0) as? BottomNavigationMenuView)?.let {
        (0 until childCount).map { getChildAt(it) as? BottomNavigationItemView }.forEach {
            // set icon
            it?.findViewById<View>(android.support.design.R.id.icon)?.apply { layoutParams = layoutParams?.apply { height = dp;width = dp } }
        }
    }
}

//
//@SuppressLint("RestrictedApi")
//fun BottomNavigationView.resetShifting(shiftMode: Boolean = false) {
//    //反射design包中的成员，不会因平台不同导致not found. 注意，只要menuitem数量变化，此值会被自动修改， 需重新调用。
//    (getChildAt(0) as? BottomNavigationMenuView)?.applySafe {
//        (0 until childCount).map { getChildAt(it) as BottomNavigationItemView }.forEach {
//            it.apply {
//                setShiftingMode(shiftMode)
//                setChecked(itemData?.isChecked ?: false)
//            }
//        }
//        BottomNavigationMenuView::class.java.getDeclaredField("mShiftingMode")?.apply {
//            isAccessible = true
//            set(this@applySafe, shiftMode)
//        }
//    }
//}
