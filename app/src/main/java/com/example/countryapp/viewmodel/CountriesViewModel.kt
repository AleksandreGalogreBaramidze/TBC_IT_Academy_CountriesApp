package com.example.countryapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countryapp.model.CountryModel
import com.example.countryapp.retrofit.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountriesViewModel : ViewModel() {
    private val liveData = MutableLiveData<List<CountryModel>>().apply {
        mutableListOf<CountryModel>()
    }
    val _LiveData: LiveData<List<CountryModel>> = liveData
    fun init() {
        CoroutineScope(Dispatchers.IO).launch {
            getService()
        }
    }
    private suspend fun getService() {
        val result = RetrofitService.countryService.getCountry()
         if (result.isSuccessful) {
            val items = result.body()
            liveData.postValue(items)
        }
    }

}