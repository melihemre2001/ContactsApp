package com.mobile.contactsapp.data.datasource

import android.util.Log
import com.mobile.contactsapp.data.entity.Contacts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsDataSource {
    suspend fun loadContacts() : List<Contacts> =
        withContext(Dispatchers.IO){
            val contactsList = ArrayList<Contacts>()
            val k1 = Contacts(1,"Melih Emre KAYA","11111")
            val k2 = Contacts(2,"Serkan KAÇ","22222")
            val k3 = Contacts(3,"Mert Göksu","33333")

            contactsList.add(k1)
            contactsList.add(k2)
            contactsList.add(k3)

            return@withContext contactsList
        }

    suspend fun search(searchWord: String) :List<Contacts> =
        withContext(Dispatchers.IO){
            val contactsList = ArrayList<Contacts>()
            val k1 = Contacts(1,"Melih Emre KAYA","11111")

            contactsList.add(k1)
            return@withContext contactsList
    }

    suspend fun saveContact(contact_name: String,contact_number: String){
        Log.e("Add Contact","$contact_name - $contact_number")
    }
    suspend fun updateContact(contact_id: Int,contact_name: String,contact_number: String){
        Log.e("Add Contact","$contact_id - $contact_name - $contact_number")
    }
    suspend fun deleteFunc(contact_id: Int){
        Log.e("Delete Contact",contact_id.toString())
    }
}