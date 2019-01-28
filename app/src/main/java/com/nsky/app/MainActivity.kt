package com.nsky.app

import android.os.Bundle
import android.support.design.bottomnavigation.LabelVisibilityMode
import android.util.TypedValue
import com.nsky.app.databinding.ActivityMainBinding
import com.nsky.kit.arch.CoreActivity
import com.nsky.kit.ext.bindingContentView

/**
 * Created by zhoubin on 2019/1/28.
 **/
class MainActivity : CoreActivity() {
    enum class NavMenu(val pos: Int, val tag: String) {
        PAGE_HOME(0, "home"),
        PAGE_DISCOVER(1, "discover"),
        PAGE_SET(2, "set"),
        PAGE_4(3, "page4"),
        PAGE_5(4, "page5");

        companion object {
            @JvmStatic
            fun posOfTag(tag: String): Int {
                var result = NavMenu.values().firstOrNull { it.tag.compareTo(tag, ignoreCase = true) == 0 }
                if (result != null)
                    return result.pos
                return 0
            }
        }
    }

    var mDataBingding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBingding = bindingContentView(R.layout.activity_main)
        setNavigation()
    }

    private fun setNavigation() {
        val displayMetrics = resources.displayMetrics
        mDataBingding?.apply {
            navigation.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
            navigation.itemIconSize = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 24f, displayMetrics
            ).toInt()
            navigation.itemTextAppearanceActive = R.style.BottomNavigationView_Text
            navigation.itemTextAppearanceInactive = R.style.BottomNavigationView_Text
            for (navItem in NavMenu.values()) {
                when (navItem) {
                    NavMenu.PAGE_4, NavMenu.PAGE_5 -> {
                        navigation.menu.getItem(navItem.pos).isVisible = false

                    }
                    else -> {
                        navigation.menu.getItem(navItem.pos).isVisible = true
                    }
                }

            }

        }
    }
}