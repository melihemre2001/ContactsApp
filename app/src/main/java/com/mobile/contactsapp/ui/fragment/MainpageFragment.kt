package com.mobile.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobile.contactsapp.R
import com.mobile.contactsapp.data.entity.Contacts
import com.mobile.contactsapp.databinding.FragmentMainpageBinding
import com.mobile.contactsapp.ui.adapter.ContactsAdapter

class MainpageFragment : Fragment() {
    private lateinit var binding: FragmentMainpageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainpageBinding.inflate(inflater,container,false)

        binding.toolbarMainpage.title = "Contacts"

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val contactsList = ArrayList<Contacts>()
        val k1 = Contacts(1,"Melih Emre KAYA","11111")
        val k2 = Contacts(2,"Serkan KAÇ","22222")
        val k3 = Contacts(3,"Mert Göksu","33333")

        contactsList.add(k1)
        contactsList.add(k2)
        contactsList.add(k3)

        val contactsAdapter = ContactsAdapter(requireContext(),contactsList)
        binding.recyclerView.adapter = contactsAdapter

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.mainpageToAddContact)
        }

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                search(query)
                return true
            }
        })


        return binding.root
    }

    fun search(searchWord: String){
        Log.e("Search",searchWord)
    }
}