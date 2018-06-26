package com.contactskotlin.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.contactskotlin.ContactsApp
import com.contactskotlin.R
import com.contactskotlin.data.ContactsResponse
import com.contactskotlin.data.dto.ContactDTO
import com.contactskotlin.data.factory.ContactsViewModelFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}
