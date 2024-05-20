package com.vedant.hrapp.changePassword.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vedant.hrapp.changePassword.models.ChangePasswordData
import com.vedant.hrapp.changePassword.repo.ChangePasswordRepo
import com.vedant.hrapp.uidata.Event
import com.vedant.hrapp.uidata.Response
import kotlinx.coroutines.launch

class ChangePasswordViewModel(private val repo : ChangePasswordRepo) : ViewModel(){

    fun changePass(request : ChangePasswordData) {
        viewModelScope.launch {
            repo.changePass(request)
        }
    }

    fun getChangePassLiveData(): LiveData<Event<Response>> {
        return repo.changePassMutableLiveData
    }
}