package com.mobile.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.mobile.contactsapp.R
import com.mobile.contactsapp.databinding.FragmentAddContactBinding
import com.mobile.contactsapp.ui.viewmodel.AddContactViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddContactFragment : Fragment() {
    private lateinit var binding: FragmentAddContactBinding
    private lateinit var viewModel: AddContactViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_contact,container, false)
        binding.addContactFragment = this
        binding.addContactToolbarTitle = "Add Contact"

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AddContactViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun saveContact(contact_name: String,contact_number: String){
        viewModel.saveContact(contact_name,contact_number)
    }
}