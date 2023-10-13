package com.mobile.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobile.contactsapp.R
import com.mobile.contactsapp.data.entity.Contacts
import com.mobile.contactsapp.databinding.FragmentMainpageBinding
import com.mobile.contactsapp.ui.adapter.ContactsAdapter
import com.mobile.contactsapp.ui.viewmodel.AddContactViewModel
import com.mobile.contactsapp.ui.viewmodel.MainpageViewModel

class MainpageFragment : Fragment() {
    private lateinit var binding: FragmentMainpageBinding
    private lateinit var viewModel: MainpageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainpageViewModel by viewModels()
        viewModel = tempViewModel
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_mainpage,container,false)
        binding.mainpageFragment = this

        binding.mainpageToolbarTitle = "Contacts"

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.contactList.observe(viewLifecycleOwner){
            val contactsAdapter = ContactsAdapter(requireContext(),it,viewModel)
            binding.contactsAdapter = contactsAdapter
        }



        binding.fab.setOnClickListener {

        }

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.search(query)
                return true
            }
        })
        return binding.root
    }


    fun fabClick(it:View){
        Navigation.findNavController(it).navigate(R.id.mainpageToAddContact)
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadContacts()
    }
}