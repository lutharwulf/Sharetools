package com.example.sharetools;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
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
        assert switchPreference != null;
        switchPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
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
}