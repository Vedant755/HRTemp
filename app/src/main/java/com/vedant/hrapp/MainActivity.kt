package com.vedant.hrapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vedant.hrapp.changePassword.ChangePassword

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.container, ChangePassword()).commit()

    }
}