package com.vedant.hrapp.changePassword.repo

import com.vedant.hrapp.changePassword.models.ChangePasswordData
import com.vedant.hrapp.changePassword.models.ChangePasswordResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ChangePasswordService {
    @POST("/api/employee/changePassword")
    suspend fun changePassword(
        @Body details: ChangePasswordData
    ): ChangePasswordResponse
}