package com.access.data.utils

sealed class DataState<out T>{

    data class Success<T>(val value: T?): DataState<T>()
    data class Error<T>(val error: Throwable): DataState<T>()

}
