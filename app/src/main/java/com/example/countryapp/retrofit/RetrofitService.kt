package com.example.countryapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private const val URL = "https://restcountries.eu"
    val countryService: RetrofitRepository by lazy {
        Retrofit.Builder().baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(RetrofitRepository::class.java)
    }
}