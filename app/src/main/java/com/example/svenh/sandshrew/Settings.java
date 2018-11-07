package com.example.svenh.sandshrew;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.widget.Toolbar;

public class Settings extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar settingsToolbar = (Toolbar)findViewById(R.id.settings_toolbar);
        getFragmentManager().beginTransaction().replace(R.id.content, new SettingsFragment()).commit();
    }
    //Backbutton
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


    public static class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
            findPreference("notificationPref").setSummary(PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("notificationPref", ""));
        }
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

}
