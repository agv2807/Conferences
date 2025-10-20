package com.vazdautsan.conferences.domain.model.base

sealed interface Result {
    data class Success<T>(
        val data: T,
        val isLocal: Boolean = false
    ) : Result

    data class Error(val exception: Throwable, val code: Int? = null) : Result

    data object Empty : Result
}