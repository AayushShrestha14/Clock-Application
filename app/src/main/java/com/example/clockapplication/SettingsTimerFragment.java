package com.example.clockapplication;

package com.example.clockapplication;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

class SettingsTimerFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)
        }
        }
}