package com.example.countryapp.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countryapp.adapter.Adapter
import com.example.countryapp.databinding.CountriesFragmentBinding
import com.example.countryapp.viewmodel.CountriesViewModel

class CountriesFragment : BaseFragment<CountriesFragmentBinding, CountriesViewModel>(CountriesFragmentBinding::inflate, CountriesViewModel::class.java) {
    private lateinit var adapter: Adapter
    override fun attach(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }
    private fun init() {
        viewModel.init()
        recyclerInit()
        observe()
    }
    private fun recyclerInit() {
        adapter = Adapter()
        bind.recycler.layoutManager = LinearLayoutManager(requireActivity())
        bind.recycler.adapter = adapter
    }
    private fun observe() {
        viewModel._LiveData.observe(viewLifecycleOwner, {
            adapter.dataSetter(it.toMutableList())
        })
    }
}