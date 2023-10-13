package com.mobile.contactsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.mobile.contactsapp.data.repo.ContactsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailContactViewModel: ViewModel() {
    var crepo = ContactsRepository()

    fun updateContact(contact_id: Int,contact_name: String,contact_number: String){
        CoroutineScope(Dispatchers.IO).launch {
            crepo.updateContact(contact_id,contact_name,contact_number)
        }
    }
}