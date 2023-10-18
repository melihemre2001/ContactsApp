package com.mobile.contactsapp.di

import android.content.Context
import androidx.room.Room
import com.mobile.contactsapp.data.datasource.ContactsDataSource
import com.mobile.contactsapp.data.repo.ContactsRepository
import com.mobile.contactsapp.room.ContactsDao
import com.mobile.contactsapp.room.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideContactsDataSource(cdao: ContactsDao) : ContactsDataSource{
        return ContactsDataSource(cdao)
    }

    @Provides
    @Singleton
    fun provideContactsRepository(cds: ContactsDataSource) : ContactsRepository{
        return ContactsRepository(cds)
    }
    @Provides
    @Singleton
    fun provideContactsDao(@ApplicationContext context:Context) : ContactsDao{
        val vt = Room.databaseBuilder(context,Database::class.java,"guide.sqlite")
            .createFromAsset("guide.sqlite").build()
        return vt.getContactsDao()
    }
}