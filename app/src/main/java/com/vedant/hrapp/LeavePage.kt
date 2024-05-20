package com.vedant.hrapp

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.vedant.hrapp.databinding.FragmentLeavePageBinding


class LeavePage : Fragment() {
    private lateinit var bind: FragmentLeavePageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentLeavePageBinding.inflate(inflater, container, false)
        setOnclickListeners()
        return bind.root
    }


    private fun setOnclickListeners(){
        bind.acceptedLeaves.setOnClickListener {
            bind.acceptedLeaves.background.setColorFilter(Color.parseColor("#EE7F23"), PorterDuff.Mode.SRC_ATOP)
            bind.acceptedLeaves.setTextColor(Color.parseColor("#FFFFFFFF"))

            bind.pendingLeaves.background.setColorFilter(Color.parseColor("#F5F5F5F5"),PorterDuff.Mode.SRC_ATOP)
            bind.pendingLeaves.setTextColor(Color.parseColor("#474546"))

            bind.rejectedLeaves.background.setColorFilter(Color.parseColor("#F5F5F5F5"),PorterDuff.Mode.SRC_ATOP)
            bind.rejectedLeaves.setTextColor(Color.parseColor("#474546"))


        }
        bind.pendingLeaves.setOnClickListener {
            bind.pendingLeaves.background.setColorFilter(Color.parseColor("#EE7F23"), PorterDuff.Mode.SRC_ATOP)
            bind.pendingLeaves.setTextColor(Color.parseColor("#FFFFFFFF"))


            bind.acceptedLeaves.background.setColorFilter(Color.parseColor("#F5F5F5F5"),PorterDuff.Mode.SRC_ATOP)
            bind.acceptedLeaves.setTextColor(Color.parseColor("#474546"))

            bind.rejectedLeaves.background.setColorFilter(Color.parseColor("#F5F5F5F5"),PorterDuff.Mode.SRC_ATOP)
            bind.rejectedLeaves.setTextColor(Color.parseColor("#474546"))
        }
        bind.rejectedLeaves.setOnClickListener {
            bind.rejectedLeaves.background.setColorFilter(Color.parseColor("#EE7F23"), PorterDuff.Mode.SRC_ATOP)
            bind.rejectedLeaves.setTextColor(Color.parseColor("#FFFFFFFF"))

            bind.pendingLeaves.background.setColorFilter(Color.parseColor("#F5F5F5F5"),PorterDuff.Mode.SRC_ATOP)
            bind.pendingLeaves.setTextColor(Color.parseColor("#474546"))

            bind.acceptedLeaves.background.setColorFilter(Color.parseColor("#F5F5F5F5"),PorterDuff.Mode.SRC_ATOP)
            bind.acceptedLeaves.setTextColor(Color.parseColor("#474546"))
        }

    }


}