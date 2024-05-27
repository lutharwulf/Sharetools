package com.example.sharetools;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

public class SettingsFragment extends PreferenceFragmentCompat {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private static final String THEME_PREFERENCE = "Theme_preference";

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);

        SwitchPreferenceCompat switchPreference = findPreference(THEME_PREFERENCE);
        switchPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                boolean isNightModeEnabled = (boolean) newValue;

                // Activer/désactiver le mode sombre
                AppCompatDelegate.setDefaultNightMode(
                        isNightModeEnabled ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);

                // Enregistrer le choix dans les préférences partagées
                SharedPreferences sharedPreferences = getPreferenceManager().getSharedPreferences();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("nightmode", isNightModeEnabled);
                editor.apply();

                return true;
            }
        });
    }


    /*SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private static final String THEME_PREFERENCE = "Theme_preference";

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);

        SwitchPreferenceCompat switchPreference = findPreference(THEME_PREFERENCE);
        switchPreference.setOnPreferenceChangeListener((preference, newValue) -> {
            boolean isNightModeEnabled = (boolean) newValue;
            AppCompatDelegate.setDefaultNightMode(isNightModeEnabled ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);

            SharedPreferences sharedPreferences = getPreferenceManager().getSharedPreferences();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("nightmode", isNightModeEnabled);
            editor.apply();

            return true;
        });
    }*/

    /*@Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);

        SwitchPreferenceCompat switchPreference = findPreference(THEME_PREFERENCE);

        // Vérifie si la préférence est activée
        if (switchPreference.isChecked()) {
            // Traiter le cas où la préférence est activée
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            editor = sharedPreferences.edit();
            editor.putBoolean("nightmode",false);
        } else {
            // Traiter le cas où la préférence est désactivée
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            editor = sharedPreferences.edit();
            editor.putBoolean("nightmode",true);
        }
        editor.apply();
    }*/
}