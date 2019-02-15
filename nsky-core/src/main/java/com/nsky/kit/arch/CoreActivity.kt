package com.nsky.kit.arch

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import com.nsky.core.R

/**
 * Created by zhoubin on 2019/1/17.
 **/
open class CoreActivity:AppCompatActivity(){

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        var toolbar: Toolbar? = findViewById(R.id.nsky_toolbar)
        toolbar?.apply {
            setSupportActionBar(toolbar)

            // 显示导航按钮
            toolbar.setNavigationIcon(R.drawable.nsky_core_back_vector)

            toolbar.setNavigationOnClickListener(View.OnClickListener { onBackPressed() })
        }


    }
}