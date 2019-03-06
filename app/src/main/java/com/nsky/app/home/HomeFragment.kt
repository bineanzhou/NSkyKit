package com.nsky.app.home

import android.os.Build
import android.support.design.widget.AppBarLayout
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.math.MathUtils
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.nsky.app.R
import com.nsky.app.databinding.HomeFragmentBinding
import com.nsky.app.home.model.FeatureBlock
import com.nsky.app.home.viewmodel.TocAdapter
import com.nsky.kit.dagger.CoreDaggerFragment
import dagger.Provides
import dagger.multibindings.IntoSet
import java.text.Collator
import javax.inject.Inject

/**
 * Created by zhoubin on 2019/2/14.
 **/
class HomeFragment : CoreDaggerFragment<HomeFragmentBinding>() {

    private val GRID_SPAN_COUNT_MIN = 1
    private val GRID_SPAN_COUNT_MAX = 4

    @Inject
    lateinit var featureDemos: Set<@JvmSuppressWildcards FeatureBlock>
    @Inject
    lateinit var tocResourceProvider: TocResourceProvider

    private var appBarLayout: AppBarLayout? = null
    private var gridTopDivider: View? = null
    private var recyclerView: RecyclerView? = null

    override fun getLayoutId(): Int {
        return R.layout.home_fragment
    }

    override fun onBindView(contentView: View?) {

        mViewDataBinding?.apply {
            val activity = activity as AppCompatActivity?
            activity?.setSupportActionBar(toolbar)
            activity?.supportActionBar?.setDisplayShowTitleEnabled(false)

            val content = content
            View.inflate(context, tocResourceProvider?.headerContent!!, content)

            appBarLayout = catTocAppBarLayout
            gridTopDivider = catTocGridTopDivider
            recyclerView = catTocGrid


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                addGridTopDividerVisibilityListener()
            } else {
                gridTopDivider?.visibility = View.VISIBLE
            }

            val gridSpanCount = calculateGridSpanCount()

            recyclerView?.layoutManager = GridLayoutManager(context, gridSpanCount)
            recyclerView?.addItemDecoration(
                GridDividerDecoration(
                    resources.getDimensionPixelSize(R.dimen.cat_toc_grid_divider_size),
                    ContextCompat.getColor(context!!, R.color.cat_toc_grid_divider_color),
                    gridSpanCount
                )
            )

            val featureList = ArrayList<FeatureBlock>(featureDemos)
            // Sort features alphabetically
            val collator = Collator.getInstance()
            featureList.sortWith(Comparator { feature1, feature2 ->
                collator.compare(
                    context!!.getString(feature1.titleResId),
                    context!!.getString(feature2.titleResId)
                )
            })
            val tocAdapter = TocAdapter(activity, featureList)
            recyclerView?.adapter = tocAdapter
        }
    }

    private fun addGridTopDividerVisibilityListener() {
        appBarLayout?.addOnOffsetChangedListener(
            AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                if (Math.abs(verticalOffset) == appBarLayout.totalScrollRange) {
                    // CTL is collapsed, hide top divider
                    gridTopDivider?.visibility = View.GONE
                } else {
                    // CTL is expanded or expanding, show top divider
                    gridTopDivider?.visibility = View.VISIBLE
                }
            })
    }

    private fun calculateGridSpanCount(): Int {
        val displayMetrics = resources.displayMetrics
        val displayWidth = displayMetrics.widthPixels
        val itemSize = resources.getDimensionPixelSize(R.dimen.cat_toc_item_size)
        val gridSpanCount = displayWidth / itemSize
        return MathUtils.clamp(gridSpanCount, GRID_SPAN_COUNT_MIN, GRID_SPAN_COUNT_MAX)
    }


    @dagger.Module
    class Module{
        @IntoSet
        @Provides
        fun provideFeatureDemo(): FeatureBlock {
            return object : FeatureBlock(R.string.cat_buttons_title, R.mipmap.ic_button) {
                override fun getFragmentClass(): Class<out Fragment> {
                    return ButtonsFragment::class.java
                }

                override fun createFragment(): Fragment {
                    return ButtonsFragment()
                }
            }
        }
    }

}