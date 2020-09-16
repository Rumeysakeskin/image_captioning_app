package com.example.image_captioning;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.widget.Toast;
import androidx.preference.PreferenceManager;
import androidx.preference.SeekBarPreference;

import javax.annotation.Nullable;

public class Preference extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.main_preference);
    }

    @Override
    protected void onResume() {
        super.onResume();

//        android.preference.SwitchPreference preference = (android.preference.SwitchPreference) findPreference("switch");
//        preference.setSummaryOff("Switch off state updated from code");
//        preference.setSummaryOn("Switch on state updated from code");
//        preference.setOnPreferenceChangeListener((android.preference.Preference.OnPreferenceChangeListener) (preference1, newValue) -> {
//            boolean yes = (boolean) newValue;
//            if (yes) {
//                getListView().setBackgroundColor(Color.parseColor("#222222"));
//            } else {
//                getListView().setBackgroundColor(Color.parseColor("#ffffff"));
//            }
//            return true;
//        });

        android.preference.SwitchPreference preference1 = (android.preference.SwitchPreference) findPreference("language");
        preference1.setSummaryOff("English Language");
        preference1.setSummaryOn("Türkçe Dili");
        preference1.setOnPreferenceChangeListener((android.preference.Preference.OnPreferenceChangeListener) (preference2, newValue) -> {
            boolean yes = (boolean) newValue;
            if (yes) {
                MainActivity.setLanguage(false);
            } else {
                MainActivity.setLanguage(true);
            }
            return true;
        });
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        android.preference.Preference seekBarPreference = new android.preference.Preference(this);
        seekBarPreference = findPreference("seek_speed");
        seekBarPreference.setOnPreferenceChangeListener((android.preference.Preference.OnPreferenceChangeListener) (preference3, newValue) -> {

             Integer value = (Integer) newValue;
             Toast.makeText(this, String.valueOf(value),Toast.LENGTH_LONG).show();
             MainActivity.setSpeechSpeed(value);

             return true;
        });

        seekBarPreference = findPreference("seek_pitch");
        seekBarPreference.setOnPreferenceChangeListener((android.preference.Preference.OnPreferenceChangeListener) (preference3, newValue) -> {
            Integer value = (Integer) newValue;
            Toast.makeText(this, String.valueOf(value),Toast.LENGTH_LONG).show();
            MainActivity.setSpeechPitch(value);

            return true;
        });

    }

}