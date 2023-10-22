package com.mobile.contactsapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mobile.contactsapp.R
import com.mobile.contactsapp.data.entity.Contacts
import com.mobile.contactsapp.databinding.CardDesignBinding
import com.mobile.contactsapp.ui.fragment.MainpageFragmentDirections
import com.mobile.contactsapp.ui.viewmodel.MainpageViewModel
import com.mobile.contactsapp.util.transition

class ContactsAdapter(var mContext: Context,var contactsList: List<Contacts>,var viewModel: MainpageViewModel)
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
            Navigation.transition(it,action)
        }

        design.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Are you sure you want to delete ${contact.contact_name} ?",Snackbar.LENGTH_LONG)
                .setAction("YES"){
                    viewModel.deleteFunc(contact.contact_id)
                }
                .show()
        }
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }



}