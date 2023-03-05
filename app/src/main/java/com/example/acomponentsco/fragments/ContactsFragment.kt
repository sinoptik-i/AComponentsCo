package com.example.acomponentsco.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.acomponentsco.databinding.FragmentContactsBinding
import com.example.acomponentsco.viewModels.ContactsViewModel
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class ContactsFragment: Fragment() {

    private lateinit var binding: FragmentContactsBinding

    private val contactsViewModel :ContactsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentContactsBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvContacts.setText(contactsViewModel.getContacts())


    }
}


