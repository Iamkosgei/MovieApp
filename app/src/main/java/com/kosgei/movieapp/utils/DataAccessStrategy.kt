package com.kosgei.movieapp.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.kosgei.movieapp.data.models.ResultWrapper
import kotlinx.coroutines.Dispatchers


fun <T, A> performGetOperation(databaseQuery: () -> LiveData<T>,
                               networkCall: suspend () -> ResultWrapper<A>,
                               saveCallResult: suspend (A) -> Unit): LiveData<ResultWrapper<T>> =
    liveData(Dispatchers.IO) {
        emit(ResultWrapper.loading(data = null))
        val source = databaseQuery.invoke().map { ResultWrapper.success(it) }
        emitSource(source)

        val responseStatus = networkCall.invoke()
        if (responseStatus.status == Status.SUCCESS) {
            saveCallResult(responseStatus.data!!)

        } else if (responseStatus.status == Status.ERROR) {
            emit(ResultWrapper.error(data = null,message = responseStatus.message!!))
            emitSource(source)
        }
    }