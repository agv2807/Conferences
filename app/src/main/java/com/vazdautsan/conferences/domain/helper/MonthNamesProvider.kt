package com.vazdautsan.conferences.domain.helper

import android.content.Context
import com.vazdautsan.conferences.R

interface MonthNamesProvider {
    fun getMonthsArray(): Array<String>
}

class AndroidMonthNamesProvider(private val context: Context) : MonthNamesProvider {
    override fun getMonthsArray(): Array<String> {
        return context.resources.getStringArray(R.array.months_array)
    }
}