package com.contactskotlin

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.contactskotlin.data.dto.ContactDTO
import com.contactskotlin.data.factory.ContactsViewModelFactory
import com.contactskotlin.ui.main.ContactsViewModel
import com.contactskotlin.ui.main.MainFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ContactsViewModelFactory
    private lateinit var viewModel: ContactsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }

        ContactsApp.appComponent.inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ContactsViewModel::class.java)

        viewModel.getContacts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{contacts: ContactDTO? ->
                    Log.d("me007", "count=" + contacts?.name)}

    }

}
