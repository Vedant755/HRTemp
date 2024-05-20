package com.vedant.hrapp.utils

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class AuthTokenKeyInterceptor(private val token: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .addHeader("token", token)
            .build()
        return chain.proceed(newRequest)
    }
}