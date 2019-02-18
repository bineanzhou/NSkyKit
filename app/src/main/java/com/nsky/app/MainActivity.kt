package com.nsky.app

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.nsky.app.home.HomeFragment
import com.nsky.app.databinding.ActivityMainBinding
import com.nsky.app.discover.DiscoverFragment
import com.nsky.app.setting.SettingFragment
import com.nsky.app.viewmodel.MainViewModel
import com.nsky.kit.dagger.scope.CoreDaggerActivity
import com.nsky.kit.ext.*
import com.nsky.kit.ui.CoreFragmentPagerAdapter
import com.nsky.kit.utils.NSkyLog
import java.util.*
import javax.inject.Inject

/**
 * Created by zhoubin on 2019/1/28.
 **/
class MainActivity : CoreDaggerActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

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
    lateinit var mMainViewModel: MainViewModel

    var mDataBingding: ActivityMainBinding? = null
    private var mAdapter: CoreFragmentPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBingding = bindingContentView(R.layout.activity_main)
        setUpNavigation()
        setUpViewPager()
//        Toast.makeText(this, mPresenter.doSomething(), Toast.LENGTH_SHORT).show()
        NSkyLog.d(TAG, "MainViewModel ${mMainViewModel.doSomething()}")
    }

    /*
    Dagger2注入注册
 */
//    private fun initInjection() {
//        DaggerMainComponent.builder().build().inject(this)
//
//    }
    private fun setUpNavigation() {

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
            navigation.setOnNavigationItemSelectedListener(this@MainActivity)
            navigation.selectedItemId = R.id.action_page_home

        }
    }

    private fun selectNavMenuItem(navMenu:NavMenu){
        mDataBingding?.apply {
            containerPager.currentItem = navMenu.pos
        }
    }
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        mDataBingding?.apply {
            navigation.setMenuItemChecked(menuItem.itemId, true)
        }
        when(menuItem.itemId)
        {
            R.id.action_page_home ->{
                selectNavMenuItem(NavMenu.PAGE_HOME)
            }
            R.id.action_page_discover ->{
                selectNavMenuItem(NavMenu.PAGE_DISCOVER)
            }
            R.id.action_page_set ->{
                selectNavMenuItem(NavMenu.PAGE_SET)
            }
            else ->{
                selectNavMenuItem(NavMenu.PAGE_HOME)
            }
        }
        return false
    }

    private fun allFragment(): List<Fragment> {
        val fragmentList = ArrayList<Fragment>()
        var fragment: Fragment?

        fragment = HomeFragment()
        fragmentList.add(fragment)

        fragment = DiscoverFragment()
        fragmentList.add(fragment)

        fragment = SettingFragment()
        fragmentList.add(fragment)
        return fragmentList
    }
    private fun setUpViewPager() {
        mDataBingding?.apply {
            var fragments = allFragment()
            mAdapter = CoreFragmentPagerAdapter(supportFragmentManager, fragments)
//            containerPager.setPagerEnabled(false)
            containerPager?.adapter = mAdapter
        }
    }

}