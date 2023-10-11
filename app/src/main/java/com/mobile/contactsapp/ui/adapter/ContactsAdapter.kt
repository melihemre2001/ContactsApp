package com.mobile.contactsapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mobile.contactsapp.R
import com.mobile.contactsapp.data.entity.Contacts
import com.mobile.contactsapp.databinding.CardDesignBinding
import com.mobile.contactsapp.databinding.FragmentMainpageBinding
import com.mobile.contactsapp.ui.fragment.MainpageFragment
import com.mobile.contactsapp.ui.fragment.MainpageFragmentDirections

class ContactsAdapter(var mContext: Context,var contactsList: List<Contacts>)
    : RecyclerView.Adapter<ContactsAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var design: CardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding:CardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_design ,parent,false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val contact = contactsList.get(position)
        val design = holder.design

        design.contactsObject = contact

        design.cardViewRow.setOnClickListener {
            val action = MainpageFragmentDirections.mainpageToDetailContact(contact = contact)
            Navigation.findNavController(it).navigate(action)
        }

        design.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Are you sure you want to delete ${contact.contact_name} ?",Snackbar.LENGTH_LONG)
                .setAction("YES"){
                    deleteFunc(contact.contact_id)
                }
                .show()
        }
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    fun deleteFunc(contact_id: Int){
        Log.e("Delete Contact",contact_id.toString())
    }

}