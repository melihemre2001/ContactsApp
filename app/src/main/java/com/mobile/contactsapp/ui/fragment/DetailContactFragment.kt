package com.mobile.contactsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.mobile.contactsapp.R
import com.mobile.contactsapp.databinding.FragmentDetailBinding
import com.mobile.contactsapp.ui.viewmodel.DetailContactViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailContactFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailContactViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail,container,false)
        binding.detailContactFragment = this

        binding.detailContactToolbarTitle  = "Contact Detail"

        val bundle: DetailContactFragmentArgs by navArgs()
        val takenContact = bundle.contact
        binding.contactsObject = takenContact

        binding.editTextContactName.setText(takenContact.contact_name)
        binding.editTextContactNumber.setText(takenContact.contact_number)

        binding.updateBtn.setOnClickListener {
            val contact_name = binding.editTextContactName.text.toString()
            val contact_number = binding.editTextContactNumber.text.toString()
            updateContact(takenContact.contact_id,contact_name,contact_number)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailContactViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun updateContact(contact_id: Int,contact_name: String,contact_number: String){
        viewModel.updateContact(contact_id,contact_name,contact_number)
    }
}