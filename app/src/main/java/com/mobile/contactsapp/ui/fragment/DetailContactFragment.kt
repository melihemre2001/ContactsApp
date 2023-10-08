package com.mobile.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.mobile.contactsapp.R
import com.mobile.contactsapp.databinding.FragmentDetailBinding

class DetailContactFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailBinding.inflate(inflater,container,false)

        binding.toolbarContactDetail.title = "Contact Detail"

        val bundle: DetailContactFragmentArgs by navArgs()
        val takenContact = bundle.contact

        binding.editTextContactName.setText(takenContact.contact_name)
        binding.editTextContactNumber.setText(takenContact.contact_number)

        binding.updateBtn.setOnClickListener {
            val contact_name = binding.editTextContactName.text.toString()
            val contact_number = binding.editTextContactNumber.text.toString()
            updateContact(takenContact.contact_id,contact_name,contact_number)
        }

        return binding.root
    }

    fun updateContact(contact_id: Int,contact_name: String,contact_number: String){
        Log.e("Add Contact","$contact_id - $contact_name - $contact_number")
    }
}