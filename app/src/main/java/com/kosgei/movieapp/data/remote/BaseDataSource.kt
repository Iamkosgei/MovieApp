package com.kosgei.movieapp.data.remote

import com.kosgei.movieapp.data.models.ResultWrapper
import retrofit2.Response
import timber.log.Timber


abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): ResultWrapper<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return ResultWrapper.success(body)
            }

          Timber.log( 1, response.code().toString())
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): ResultWrapper<T> {
        Timber.d(message)
        return ResultWrapper.error(data = null,message="Network call has failed for a following reason: $message")
    }

}