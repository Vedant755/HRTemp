package com.vedant.hrapp.changePassword

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vedant.hrapp.changePassword.models.ChangePasswordData
import com.vedant.hrapp.changePassword.models.ChangePasswordResponse
import com.vedant.hrapp.changePassword.repo.ChangePasswordRepo
import com.vedant.hrapp.changePassword.repo.ChangePasswordService
import com.vedant.hrapp.changePassword.viewModel.ChangePasswordViewModel
import com.vedant.hrapp.changePassword.viewModel.ChangePasswordViewModelFactory
import com.vedant.hrapp.databinding.FragmentChangePasswordBinding
import com.vedant.hrapp.uidata.Response
import com.vedant.hrapp.changePassword.models.Constant
import com.vedant.hrapp.utils.RetrofitHelper

class ChangePassword : Fragment() {
    private lateinit var bind:FragmentChangePasswordBinding
    private lateinit var changePasswordViewModel: ChangePasswordViewModel
    private lateinit var changePasswordService: ChangePasswordService
    override fun onCreate(savedInstanceState: Bundle?) {
        changePasswordService = RetrofitHelper.getRetrofitInstance().create(ChangePasswordService::class.java)
        changePasswordViewModel = ViewModelProvider(this, ChangePasswordViewModelFactory(
            ChangePasswordRepo(changePasswordService)
        ))[ChangePasswordViewModel ::class.java]

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentChangePasswordBinding.inflate(inflater, container, false)
        setOnclickListeners()
        return bind.root
    }

    private fun setOnclickListeners() {
        val currentPasswordEditText: EditText = bind.etCurrentPassword
        val newPasswordEditText: EditText = bind.etNewPassword
        val confirmNewPasswordEditText: EditText = bind.etConfirmNewPassword
        val changePasswordButton: Button = bind.btnChangePassword

        changePasswordButton.setOnClickListener {
            if (confirmNewPasswordEditText.text.toString() == newPasswordEditText.text.toString()){
                //Changes Here, used Static Values
                changePasswordViewModel.changePass(ChangePasswordData(Constant.EMP_ID,newPasswordEditText.text.toString(),currentPasswordEditText.text.toString()))
                changePasswordViewModel.getChangePassLiveData().observe(viewLifecycleOwner, Observer {event ->
                    event.getContentIfNotHandled().let { response ->
                        when(response) {

                            is Response.Success -> {
                                val changePass = response.data as ChangePasswordResponse
                                Log.d("Message",response.data.toString())
                                if (changePass.code == 200) {
                                    Toast.makeText(requireContext(), changePass.message, Toast.LENGTH_SHORT).show()
                                }else if (changePass.code==304){
                                    Toast.makeText(requireContext(), changePass.message, Toast.LENGTH_SHORT).show()
                                    Log.d("Missing",response.data.message)
                                }

                            }
                            is Response.Exception -> {
                                Toast.makeText(requireContext(),response.message.toString(), Toast.LENGTH_SHORT).show()
                            }
                            else-> return@Observer
                        }
                    }
                })
            }else{
                Toast.makeText(requireContext(),"Confirm Password Doesn't match", Toast.LENGTH_SHORT).show()

            }

        }
    }

}