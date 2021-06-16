package com.example.countryapp.retrofit

import com.example.countryapp.model.CountryModel
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitRepository {
    @GET("rest/v2/all")
    suspend fun getCountry(): Response<List<CountryModel>>
}