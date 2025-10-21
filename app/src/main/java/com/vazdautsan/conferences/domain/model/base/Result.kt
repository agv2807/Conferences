package com.vazdautsan.conferences.domain.model.base

sealed interface Result<T> {
    data class Success<T>(
        val data: T,
        val isLocal: Boolean = false
    ) : Result<T>

    data class Error<T>(val exception: Throwable, val code: Int? = null) :
        Result<T>
    
    class Empty<T> : Result<T>
}

inline fun <T, R> Result<T>.mapResult(transformation: (T) -> R): Result<R> {
    return when (this) {
        is Result.Success -> {
            try {
                Result.Success(transformation(data))
            } catch (e: Exception) {
                Result.Error(MapResultException(e))
            }
        }

        is Result.Empty -> Result.Empty()
        is Result.Error -> Result.Error(exception = exception, code = code)
    }
}

class MapResultException(cause: Exception) : Exception(cause)

fun <T> Result<T>.isSuccess() = this is Result.Success

fun <T> Result<T>.asSuccess() = this as Result.Success

fun <T> Result<T>.successDataOrNull() = if (isSuccess()) asSuccess().data else null