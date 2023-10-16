package com.mobile.contactsapp.data.repo

import android.util.Log
import com.mobile.contactsapp.data.datasource.ContactsDataSource
import com.mobile.contactsapp.data.entity.Contacts

class ContactsRepository(var cds: ContactsDataSource) {
    suspend fun saveContact(contact_name: String,contact_number: String) =
        cds.saveContact(contact_name,contact_number)
    suspend fun updateContact(contact_id: Int,contact_name: String,contact_number: String) =
        cds.updateContact(contact_id,contact_name,contact_number)
    suspend fun deleteFunc(contact_id: Int) = cds.deleteFunc(contact_id)

    suspend fun loadContacts() : List<Contacts> = cds.loadContacts()

    suspend fun search(searchWord: String) :List<Contacts> = cds.search(searchWord)

}