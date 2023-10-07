package com.mobile.contactsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.contactsapp.R
import com.mobile.contactsapp.databinding.FragmentMainpageBinding

class MainpageFragment : Fragment() {
    private lateinit var binding: FragmentMainpageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainpageBinding.inflate(inflater,container,false)
        return binding.root
    }
}