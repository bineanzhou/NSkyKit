package com.nsky.app

import android.os.Bundle
import android.support.design.bottomnavigation.LabelVisibilityMode
import android.util.TypedValue
import com.nsky.app.dagger.DaggerMainComponent
import com.nsky.app.dagger.MainPresenter
import com.nsky.app.dagger.MainService
import com.nsky.app.databinding.ActivityMainBinding
import com.nsky.kit.arch.CoreActivity
import com.nsky.kit.ext.*
import com.orhanobut.logger.Logger
import javax.inject.Inject

/**
 * Created by zhoubin on 2019/1/28.
 **/
class MainActivity : CoreActivity() {
    private val TAG:String? = MainActivity::class.java.simpleName

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

    @Inject
    lateinit var mPresenter: MainPresenter

    @Inject
    lateinit var mMainService: MainService


    var mDataBingding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBingding = bindingContentView(R.layout.activity_main)
        setNavigation()

        initInjection()
//        Toast.makeText(this, mPresenter.doSomething(), Toast.LENGTH_SHORT).show()
        Logger.d("$TAG  MainPresenter ${mPresenter.doSomething()}")
        Logger.d("$TAG  MainService ${mMainService.getMainInfo()}")
    }

    /*
    Dagger2注入注册
 */
    private fun initInjection() {
        DaggerMainComponent.builder().build().inject(this)

    }
    private fun setNavigation() {

        //            navigation.disableShiftMode()

        mDataBingding?.apply {
            navigation.setTextAppearance(R.style.BottomNavigationView_Text, R.style.BottomNavigationView_Text)

            for (navItem in NavMenu.values()) {
                when (navItem) {
                    NavMenu.PAGE_4, NavMenu.PAGE_5 -> {
                        navigation.hideMenuItem(navItem.pos)

                    }
                    else -> {
                        navigation.showMenuItem(navItem.pos)
                    }
                }

            }

        }
    }
}