package com.vazdautsan.conferences.domain.helper

import android.content.Context
import com.vazdautsan.conferences.R

interface DaysPluralProvider {
    fun getDayPlural(count: Int): String
}

class AndroidDaysPluralProvider(private val context: Context) : DaysPluralProvider {
    override fun getDayPlural(count: Int): String {
        return context.resources.getQuantityString(R.plurals.days, count)
    }

}