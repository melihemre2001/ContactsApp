package com.mobile.contactsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.mobile.contactsapp.data.repo.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddContactViewModel @Inject constructor(var crepo: ContactsRepository) : ViewModel() {
    fun saveContact(contact_name: String,contact_number: String){
        CoroutineScope(Dispatchers.IO).launch {
            crepo.saveContact(contact_name,contact_number)

        }
    }
}