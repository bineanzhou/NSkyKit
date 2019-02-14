package com.nsky.app.discover

import android.view.View
import com.nsky.app.R
import com.nsky.app.databinding.DiscoverFragmentBinding
import com.nsky.kit.arch.CoreFragment

/**
 * Created by zhoubin on 2019/2/14.
 **/
class DiscoverFragment:CoreFragment<DiscoverFragmentBinding>(){
    override fun getLayoutId(): Int {
        return R.layout.discover_fragment
    }

    override fun onBindView(contentView: View?) {
    }

}