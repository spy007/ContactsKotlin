package com.contactskotlin.data.di

import com.contactskotlin.data.RemoteConfig
import com.contactskotlin.data.repository.RemoteContactsService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
class RemoteModule {

    @Provides
    @Singleton
    fun provideGson(): Gson =
            GsonBuilder()
                    .setLenient()
                    .create()

//    @Provides
//    @Singleton
//    fun provideOkHttpClient(): OkHttpClient =
//            OkHttpClient.Builder()
//                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//                    .build()
//
//
//    @Provides
//    @Singleton
//    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit =
//            Retrofit.Builder()
//                    .baseUrl(RemoteConfig.BASE_API_LAYER)
//                    .addConverterFactory(GsonConverterFactory.create(gson))
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .client(okHttpClient)
//                    .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .baseUrl(RemoteConfig.BASE_API_LAYER)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url()

            val url = originalHttpUrl.newBuilder()
//                    .addQueryParameter("username", "stasvip")
                    .build()

            // Request customization: add request headers
            val requestBuilder = original.newBuilder()
                    .url(url)

            val request = requestBuilder.build()
            chain.proceed(request)
        }

        return httpClient.build()
    }

    @Provides
    @Singleton
    fun provideRemoteContactsService(retrofit: Retrofit): RemoteContactsService =
            retrofit.create(RemoteContactsService::class.java)
}