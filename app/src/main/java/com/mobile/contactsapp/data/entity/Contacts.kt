package com.mobile.contactsapp.data.entity

import java.io.Serializable

data class Contacts(var contact_id: Int,
                    var contact_name:String,
                    var contact_number:String) : Serializable {
}