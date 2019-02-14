package com.nsky.app.setting

import android.view.View
import com.nsky.app.R
import com.nsky.app.databinding.SettingFragmentBinding
import com.nsky.kit.arch.CoreFragment
import com.nsky.kit.arch.FragmentContainerActivity

/**
 * Created by zhoubin on 2019/2/14.
 **/
class SettingFragment:CoreFragment<SettingFragmentBinding>(){
    override fun getLayoutId(): Int {
        return R.layout.setting_fragment
    }

    override fun onBindView(contentView: View?) {
        mViewDataBinding?.apply {
            btnDebug.setOnClickListener{ FragmentContainerActivity.launch(activity, ConfigPreFragment::class.java)}
        }
    }

}