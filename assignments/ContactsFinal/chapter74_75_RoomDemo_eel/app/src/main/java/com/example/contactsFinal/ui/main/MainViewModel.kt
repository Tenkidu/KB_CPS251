package com.example.contactsFinal.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.contactsFinal.Contact
import com.example.contactsFinal.ContactRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ContactRepository = ContactRepository(application)
    private val allContacts: LiveData<List<Contact>>? = repository.allContacts
    private val searchResults: MutableLiveData<List<Contact>> = repository.searchResults

    fun insertContact(contact: Contact) {
        repository.insertContact(contact)
    }
    fun findContact(name: String) {
        return repository.findContact(name)
    }
    fun getSearchResults(): MutableLiveData<List<Contact>> {
        return searchResults
    }
    fun deleteContact(contactId: Int) {
        repository.deleteContact(contactId)
    }
    fun getAllContacts(): LiveData<List<Contact>>? {
        return allContacts
    }
    fun getAllContactsAsc() {
        return repository.sortContactsAsc()
    }
    fun getAllContactsDesc() {
        return repository.sortContactsDesc()
    }

}