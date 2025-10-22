package com.vazdautsan.conferences.local_storage

import com.vazdautsan.conferences.data.lds.ApiKeyLds

class ApiKeyLdsImpl : ApiKeyLds {
    override suspend fun getApiKey(): String? {
        return ApiKeyStore.apiKey
    }
}