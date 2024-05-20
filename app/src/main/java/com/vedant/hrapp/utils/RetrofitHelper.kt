package com.vedant.hrapp.utils

import com.vedant.hrapp.changePassword.models.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {
    private val BASE_URL = "https://hrm.brothers.net.in"

    fun getRetrofitInstance(): Retrofit {

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            //used Constant Values
            .addInterceptor(ApiKeyInterceptor(Constant.API_KEY))
            .addInterceptor(AuthTokenKeyInterceptor(Constant.USER_TOKEN))
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}