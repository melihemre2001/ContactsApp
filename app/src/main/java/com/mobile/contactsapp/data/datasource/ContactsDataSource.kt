package com.mobile.contactsapp.data.datasource

import com.mobile.contactsapp.data.entity.Contacts
import com.mobile.contactsapp.room.ContactsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsDataSource(var cdao: ContactsDao) {
    suspend fun loadContacts() : List<Contacts> =
        withContext(Dispatchers.IO){
            return@withContext cdao.loadContacts()
        }

    suspend fun search(searchWord: String) :List<Contacts> =
        withContext(Dispatchers.IO){
            return@withContext cdao.search(searchWord)
    }

    suspend fun saveContact(contact_name: String,contact_number: String){
        val newContact = Contacts(0,contact_name,contact_number)
        cdao.save(newContact)
    }
    suspend fun updateContact(contact_id: Int,contact_name: String,contact_number: String){
        val updatedContact = Contacts(contact_id,contact_name,contact_number)
        cdao.update(updatedContact)
    }
    suspend fun deleteFunc(contact_id: Int){
        val deletedContact = Contacts(contact_id,"","")
        cdao.delete(deletedContact)
    }
}