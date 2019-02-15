package com.nsky.app.setting

import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.preference.Preference
import android.support.v7.preference.PreferenceFragmentCompat
import android.view.MenuItem
import com.nsky.app.R
import com.nsky.kit.arch.FragmentContainerActivity

/**
 * Created by zhoubin on 2019/1/16.
 **/

/**
 * This fragment shows notification preferences only. It is used when the
 * activity is showing a two-pane settings UI.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
class NotificationPreferenceFragment : PreferenceFragmentCompat() {
    /**
     * Called during [.onCreate] to supply the preferences for this fragment.
     * Subclasses are expected to call [.setPreferenceScreen] either
     * directly or via helper methods such as [.addPreferencesFromResource].
     *
     * @param savedInstanceState If the fragment is being re-created from
     * a previous saved state, this is the state.
     * @param rootKey If non-null, this preference fragment should be rooted at the
     * [android.support.v7.preference.PreferenceScreen] with this key.
     */
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.pref_notification)
        setHasOptionsMenu(true)

        // Bind the summaries of EditText/List/Dialog/Ringtone preferences
        // to their values. When their values change, their summaries are
        // updated to reflect the new value, per the Android Design
        // guidelines.
//        FragmentContainerActivity.bindPreferenceSummaryToValue(findPreference("notifications_new_message_ringtone"))
    }

    override fun onPreferenceTreeClick(preference: Preference?): Boolean {
        return super.onPreferenceTreeClick(preference)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            startActivity(Intent(activity, FragmentContainerActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}