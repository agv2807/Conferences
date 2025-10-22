package com.vazdautsan.conferences.domain.helper

import android.content.Context
import com.vazdautsan.conferences.R
import com.vazdautsan.conferences.domain.model.conferences.ConferenceFormat

interface ConferencePositionHelper {
    fun getPosition(format: ConferenceFormat, city: String, country: String): String
}

class AndroidConferencePositionHelper(private val context: Context) : ConferencePositionHelper {
    override fun getPosition(
        format: ConferenceFormat,
        city: String,
        country: String
    ): String {
        return when (format) {
            ConferenceFormat.ONLINE -> {
                context.getString(R.string.online)
            }

            ConferenceFormat.OFFLINE -> {
                buildString {
                    append(country)
                    append(", ")
                    append(city)
                }
            }

            ConferenceFormat.UNCONFINED -> ""
        }
    }

}