package com.nsky.kit.ext

import android.annotation.SuppressLint
import android.support.annotation.StyleRes
import android.support.design.bottomnavigation.LabelVisibilityMode
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.util.TypedValue
import android.view.View
import java.lang.reflect.AccessibleObject.setAccessible
import java.lang.reflect.Array.setBoolean




fun BottomNavigationView.resetBottomMenuView(size: Int) {
    val dp = (size * resources.displayMetrics.density).toInt()
    (getChildAt(0) as? BottomNavigationMenuView)?.let {
        (0 until childCount).map { getChildAt(it) as? BottomNavigationItemView }.forEach {
            // set icon
            it?.findViewById<View>(android.support.design.R.id.icon)?.apply { layoutParams = layoutParams?.apply { height = dp;width = dp } }
        }
    }
}

/**
 *  <= API26
 */

@SuppressLint("RestrictedApi")
fun BottomNavigationView.disableShiftMode() {
    var shiftMode: Boolean = false
    //反射design包中的成员，不会因平台不同导致not found. 注意，只要menuitem数量变化，此值会被自动修改， 需重新调用。
    (getChildAt(0) as? BottomNavigationMenuView)?.applySafe {
        (0 until childCount).map { getChildAt(it) as BottomNavigationItemView }.forEach {
            it.apply {
//                setShiftingMode(shiftMode)
                setShifting(shiftMode)
                setChecked(itemData?.isChecked ?: false)
            }
        }
        BottomNavigationMenuView::class.java.getDeclaredField("mShiftingMode")?.apply {
            isAccessible = true
            set(this@applySafe, shiftMode)
        }
    }
}

fun BottomNavigationView.setTextAppearance(@StyleRes textAppearanceResActive:Int,
                                          @StyleRes textAppearanceResInactive:Int){
    val displayMetrics = resources.displayMetrics
    labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
    itemIconSize = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, 24f, displayMetrics
    ).toInt()
    itemTextAppearanceActive = textAppearanceResActive
    itemTextAppearanceInactive = textAppearanceResInactive
}

fun BottomNavigationView.hideMenuItem(pos:Int){
    if(pos>=0&&pos<menu.size())
    {
        menu.getItem(pos).isVisible = false
    }
}
fun BottomNavigationView.showMenuItem(pos:Int){
    if(pos>=0&&pos<menu.size())
    {
        menu.getItem(pos).isVisible = true
    }
}
//@SuppressLint("RestrictedApi")
//fun disableShiftMode(navigationView: BottomNavigationView) {
//    val menuView = navigationView.getChildAt(0) as BottomNavigationMenuView
//    try {
//        val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
//        shiftingMode.isAccessible = true
//        shiftingMode.setBoolean(menuView, false)
//        shiftingMode.isAccessible = false
//
//        for (i in 0 until menuView.childCount) {
//            val itemView = menuView.getChildAt(i) as BottomNavigationItemView
//            itemView.setShiftingMode(false)
//            itemView.setChecked(itemView.itemData.isChecked)
//        }
//    } catch (e: NoSuchFieldException) {
//        // Log
//    } catch (e: IllegalAccessException) {
//        // Log
//    }
//
//}