package com.kosgei.movieapp.data.models

import com.kosgei.movieapp.utils.Status


data class ResultWrapper<out T>(
    val status: Status,
    val data: T?,
    val message: String?,
    val refreshing: Boolean?
) {
    companion object {
        fun <T> success(data: T): ResultWrapper<T> =
            ResultWrapper(status = Status.SUCCESS, data = data, message = null, refreshing = null)

        fun <T> error(data: T?, message: String, refreshing: Boolean): ResultWrapper<T> =
            ResultWrapper(
                status = Status.ERROR,
                data = data,
                message = message,
                refreshing = refreshing
            )

        fun <T> loading(data: T?, refreshing: Boolean): ResultWrapper<T> =
            ResultWrapper(
                status = Status.LOADING,
                data = data,
                refreshing = refreshing,
                message = null
            )
    }
}