package com.vedant.hrapp.uidata

sealed class Response {
    data class Success(val data: Any?) : Response()
    data class Exception(val message : Any) : Response()
}
