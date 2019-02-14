package com.nsky.app.catalog

import android.view.View
import com.nsky.app.R
import com.nsky.app.databinding.CatalogFragmentBinding
import com.nsky.kit.arch.CoreFragment

/**
 * Created by zhoubin on 2019/2/14.
 **/
class CatalogFragment:CoreFragment<CatalogFragmentBinding>(){
    override fun getLayoutId(): Int {
        return R.layout.catalog_fragment
    }

    override fun onBindView(contentView: View?) {

    }

}