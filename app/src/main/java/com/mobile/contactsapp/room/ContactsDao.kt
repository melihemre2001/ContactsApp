package com.mobile.contactsapp.room

import androidx.room.Dao
import androidx.room.Query
import com.mobile.contactsapp.data.entity.Contacts

@Dao
interface ContactsDao {
    @Query("SELECT * FROM contacts")
    suspend fun loadContacts() : List<Contacts>
}