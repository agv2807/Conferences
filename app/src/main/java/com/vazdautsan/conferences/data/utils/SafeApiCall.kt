package com.vazdautsan.conferences.data.utils

import android.accounts.NetworkErrorException
import com.vazdautsan.conferences.data.dto.server_response.ServerResponse
import com.vazdautsan.conferences.domain.model.base.Result
import kotlin.coroutines.cancellation.CancellationException

internal suspend fun <K : Any> safeApiCall(call: suspend () -> ServerResponse<K>): Result<K> {
    val response: ServerResponse<K>?
    return try {
        response = call.invoke()
        if (response.data != null && response.error == null)
            Result.Success(data = response.data)
        else Result.Error(NetworkErrorException(response.error))
    } catch (e: CancellationException) {
        throw e
    } catch (e: Throwable) {
        e.printStackTrace()
        Result.Error(NetworkErrorException(e.message))
    }
}