package com.kosgei.movieapp.utils

import android.content.Context
import androidx.preference.PreferenceManager


class PreferenceHelper(context: Context?) {


    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    var darkMode = preferences.getInt(DARK_STATUS, 0)

        set(value) = preferences.edit().putInt(DARK_STATUS, value).apply()

}