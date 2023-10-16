package com.mobile.contactsapp.di

import com.mobile.contactsapp.data.datasource.ContactsDataSource
import com.mobile.contactsapp.data.repo.ContactsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideContactsDataSource() : ContactsDataSource{
        return ContactsDataSource()
    }

    @Provides
    @Singleton
    fun provideContactsRepository(cds: ContactsDataSource) : ContactsRepository{
        return ContactsRepository(cds)
    }
}