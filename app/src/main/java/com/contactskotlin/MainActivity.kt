package com.contactskotlin

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.contactskotlin.data.RemoteConfig
import com.contactskotlin.data.dto.ContactDTO
import com.contactskotlin.data.dto.ContactsDTO
import com.contactskotlin.data.factory.ContactsViewModelFactory
import com.contactskotlin.data.model.CityResponse
import com.contactskotlin.data.repository.RemoteContactsService
import com.contactskotlin.ui.main.ContactsViewModel
import com.contactskotlin.ui.main.MainFragment
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ContactsViewModelFactory
    private lateinit var viewModel: ContactsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }

        ContactsApp.appComponent.inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ContactsViewModel::class.java)

        viewModel.getContacts()//getCities()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{result: ContactsDTO?/*CityResponse*/? ->
                    val contact = result?.contacts/*geonames*/?.get(0)
                    binding.setContactDTO(contact)
                    Log.d("me007", "received city name: " + contact?.name)}
    }

}
