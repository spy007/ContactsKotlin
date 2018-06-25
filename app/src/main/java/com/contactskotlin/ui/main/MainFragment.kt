package com.contactskotlin.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.contactskotlin.ContactsApp
import com.contactskotlin.R
import com.contactskotlin.data.factory.ContactsViewModelFactory
import com.contactskotlin.data.model.Contact
import javax.inject.Inject

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    lateinit var viewModelFactory: ContactsViewModelFactory
    private lateinit var viewModel: ContactsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        ContactsApp.appComponent.inject(this)

        val contacts = viewModel.getContacts()

        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ContactsViewModel::class.java)
    }
}
