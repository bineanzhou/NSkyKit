package com.nsky.kit.arch

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import com.nsky.core.R
import com.nsky.core.databinding.NskyCoreActivityFragmentBinding
import com.nsky.kit.ext.addFragmentToActivity
import com.nsky.kit.ext.bindingContentView
import java.lang.Exception

/**
 * fragment 加载容器
 */
class FragmentContainerActivity : CoreActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingContentView<NskyCoreActivityFragmentBinding>(R.layout.nsky_core_activity_fragment)

        try {
            var fragmentClass: Class<Fragment> = intent?.getSerializableExtra(EXTRA_FRAGMENT_NAME) as Class<Fragment>
            var fragment = fragmentClass.newInstance()
            addFragmentToActivity(R.id.fragment_container, fragment)
        }catch (e:Exception)
        {
            e.printStackTrace()
            finish()
            return
        }

        setupActionBar()
    }


    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun setupActionBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    companion object {
        const val EXTRA_FRAGMENT_NAME = "fragment_name"

        fun <T : Fragment> launch(activity: FragmentActivity?, fragmentClass: Class<T>) {
            var intent = Intent(activity, FragmentContainerActivity::class.java)
            intent.putExtra(EXTRA_FRAGMENT_NAME, fragmentClass)
            activity?.startActivity(intent)
        }
    }
}
