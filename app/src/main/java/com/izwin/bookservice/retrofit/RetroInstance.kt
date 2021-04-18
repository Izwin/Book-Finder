package com.izwin.bookservice.retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object{
        private val booksURL = "https://www.googleapis.com/books/v1/"
        fun getRetrofitInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(booksURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
    }
}