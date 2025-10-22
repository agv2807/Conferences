package com.vazdautsan.conferences.data.lds

interface ApiKeyLds {
    suspend fun getApiKey(): String?
}