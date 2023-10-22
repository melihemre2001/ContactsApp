package com.mobile.contactsapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mobile.contactsapp.data.entity.Contacts

@Dao
interface ContactsDao {
    @Query("SELECT * FROM contacts")
    suspend fun loadContacts() : List<Contacts>

    @Insert
    suspend fun save(contacts: Contacts)

    @Update
    suspend fun update(contacts: Contacts)

    @Delete
    suspend fun delete(contacts: Contacts)

    @Query("SELECT * FROM contacts WHERE contact_name like '%' || :searchWord || '%'")
    suspend fun search(searchWord: String) : List<Contacts>
}