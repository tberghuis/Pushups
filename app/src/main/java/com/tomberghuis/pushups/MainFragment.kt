package com.tomberghuis.pushups

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
import com.tomberghuis.pushups.data.AppDatabase
import com.tomberghuis.pushups.databinding.MainFragmentBinding
import com.tomberghuis.pushups.utilities.InjectorUtils
import com.tomberghuis.pushups.viewmodels.MainViewModel


class MainFragment : Fragment() {

    // should this code be here... no it should be in a repository
//    private lateinit var database: AppDatabase
//    private lateinit var taskDao: TaskDao
    // TODO copy architecture from sunflower


    companion object {
        fun newInstance() = MainFragment()
    }

//    private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }
    
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : MainFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.main_fragment, container, false
        )
        val factory = InjectorUtils.provideMainViewModelFactory(requireContext())
        viewModel = ViewModelProviders.of(this, factory)
            .get(MainViewModel::class.java)
        binding.viewmodel = viewModel
        return binding.root
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

        // this should be hooked up in the xml
        btnCompleteSet.setOnClickListener {
            Log.d("aaa","numPushups: ${viewModel.numPushupsNumberPicker}")
            viewModel.saveCompletedPushupSet()
        }

    }
}