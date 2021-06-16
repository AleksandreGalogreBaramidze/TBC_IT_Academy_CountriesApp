package com.example.countryapp.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.countryapp.MainActivity


typealias viewInflater<Jemala> = (inflate: LayoutInflater, parent: ViewGroup?, attach: Boolean) -> Jemala
abstract class BaseFragment<Binding : ViewBinding, V : ViewModel>(private val inflation: viewInflater<Binding>, private val modelView: Class<V>) : Fragment() {
    private  var mainActivity: MainActivity? = null
    private var binding: Binding? = null
    val bind get() = binding!!

    override fun onAttach(context: Context) {
        if(context is MainActivity){
            mainActivity = context
        }
        super.onAttach(context)
    }
    val viewModel: V by lazy {
        ViewModelProvider(requireActivity()).get(
            modelView
        )
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
    : View? {
        if (binding == null) {
            binding = inflation(inflater, container, false)
        }
        return binding!!.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    abstract fun attach(inflater: LayoutInflater, container: ViewGroup?)
}