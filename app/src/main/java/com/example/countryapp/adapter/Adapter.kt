package com.example.countryapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countryapp.databinding.CountryItemBinding
import com.example.countryapp.extension.imageLoader
import com.example.countryapp.model.CountryModel


class Adapter : RecyclerView.Adapter<Adapter.ViewSetter>() {
    val countries: MutableList<CountryModel> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewSetter(CountryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewSetter, position: Int) {
        holder.onBind()
    }
    override fun getItemCount() = countries.size
    fun dataSetter(countries: MutableList<CountryModel>) {
        this.countries.addAll(countries)
        notifyDataSetChanged()
    }
    inner class ViewSetter(private val binding: CountryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var modelCountry: CountryModel
        fun onBind() {
            modelCountry = countries[adapterPosition]
            binding.txtCountryName.text = modelCountry.name
            binding.txtCountryCapital.text = modelCountry.capital
            binding.txtCountryArea.text = modelCountry.region
            binding.txtCountryPopulation.text = modelCountry.population.toString()
            binding.Flag.imageLoader(modelCountry.flag)
        }

    }
}