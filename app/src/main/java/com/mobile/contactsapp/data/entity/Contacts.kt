package com.mobile.contactsapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable
@Entity(tableName = "contacts")
data class Contacts(@PrimaryKey(autoGenerate = true)
                    @ColumnInfo(name = "contact_id") @NotNull var contact_id: Int,
                    @ColumnInfo(name = "contact_name") @NotNull var contact_name:String,
                    @ColumnInfo(name = "contact_number") @NotNull var contact_number:String) : Serializable {
}