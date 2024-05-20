package com.vedant.hrapp.changePassword.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vedant.hrapp.changePassword.models.ChangePasswordData
import com.vedant.hrapp.uidata.Event
import com.vedant.hrapp.uidata.Response

class ChangePasswordRepo(private val changePasswordService: ChangePasswordService) {
    private var _changePasswordMutableLiveData: MutableLiveData<Event<Response>> = MutableLiveData()
    val changePassMutableLiveData : LiveData<Event<Response>>
        get() = _changePasswordMutableLiveData

    suspend fun changePass(request : ChangePasswordData) {
        val response = changePasswordService.changePassword(request)
        if (request != null) {
            _changePasswordMutableLiveData.postValue(Event(Response.Success(response)))
        } else {
            _changePasswordMutableLiveData.postValue(Event(Response.Exception("Something Went Wrong")))
        }
    }
}