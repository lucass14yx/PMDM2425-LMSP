package com.maestre.preferenciasapp

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager

class SettingsFragment: PreferenceFragmentCompat(), SharedPreferences.OnSharedPreferenceChangeListener  {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }

    override fun onResume() {
        super.onResume()
        PreferenceManager.getDefaultSharedPreferences(requireContext())?.
        registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        PreferenceManager.getDefaultSharedPreferences(requireContext())?.unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        when (key) {
            "pref_themes" -> {
                //aplicas tema
                val themeName = sharedPreferences?.getString("pref_themes", "AppNewTheme") ?: "AppNewTheme"
                when (themeName) {
                    "AppNewTheme" -> requireActivity().setTheme(R.style.AppNewTheme)
                    "Base.Theme.PreferenciasApp" -> requireActivity().setTheme(R.style.Base_Theme_PreferenciasApp)
                }

                Toast.makeText(this.context,"tema: $themeName ",Toast.LENGTH_SHORT).show()
            }
            "def_nigthmode" -> {
                //aplicas modo
                val isDarkModeEnabled = sharedPreferences?.getBoolean("def_nigthmode", false) ?: false
                if (isDarkModeEnabled){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
                Toast.makeText(this.context, "Modo Nocturno: $isDarkModeEnabled ", Toast.LENGTH_SHORT).show()
            }
        }
        //
        requireActivity().recreate()
    }

}