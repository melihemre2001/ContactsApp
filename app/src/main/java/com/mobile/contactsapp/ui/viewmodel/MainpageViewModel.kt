package com.mobile.contactsapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.contactsapp.data.entity.Contacts
import com.mobile.contactsapp.data.repo.ContactsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainpageViewModel: ViewModel() {
    var crepo = ContactsRepository()
    var contactList = MutableLiveData<List<Contacts>>()

    init {
        loadContacts()
    }

    fun deleteFunc(contact_id: Int){
        CoroutineScope(Dispatchers.Main ).launch {
            crepo.deleteFunc(contact_id)
            loadContacts()
        }
    }

    fun loadContacts(){
        CoroutineScope(Dispatchers.Main).launch {
            contactList.value = crepo.loadContacts()
        }
    }

    fun search(searchWord: String){
        CoroutineScope(Dispatchers.Main).launch {
            contactList.value = crepo.search(searchWord)
        }

    }
}