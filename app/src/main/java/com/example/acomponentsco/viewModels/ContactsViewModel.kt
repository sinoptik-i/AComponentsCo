package com.example.acomponentsco.viewModels

import androidx.lifecycle.ViewModel
import com.example.acomponentsco.contentProvider.ContactManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContactsViewModel @Inject constructor(
    private val contactManager: ContactManager
) : ViewModel() {

    fun getContacts() = contactManager.getContacts()

}