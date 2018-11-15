package com.tomberghuis.pushups.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tomberghuis.pushups.R
import android.widget.Toast
import com.tomberghuis.pushups.MainActivity
import android.widget.NumberPicker
import kotlinx.android.synthetic.main.main_fragment.*
import com.tomberghuis.pushups.R.id.container
import android.databinding.DataBindingUtil
import android.util.Log
import com.tomberghuis.pushups.databinding.MainFragmentBinding


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : MainFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.main_fragment, container, false
        )
        binding.viewmodel = viewModel
        val view = binding.getRoot()
        return view
    }

    // TODO is this the right lifecycle method
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        numberPicker.minValue = 2
        numberPicker.maxValue = 20

        btnCompleteSet.setOnClickListener {
            Log.d("aaa","numPushups: ${viewModel.numPushups}")
        }

    }
}