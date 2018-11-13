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


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var root = inflater.inflate(R.layout.main_fragment, container, false)

//        numberPicker.minValue = 2
//        numberPicker.maxValue = 20

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        numberPicker.minValue = 2
        numberPicker.maxValue = 20

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}


//protected fun onCreate(savedInstanceState: Bundle) {
//    super.onCreate(savedInstanceState)
//    setContentView(R.layout.numberpicker)
//
//    val np = findViewById(R.id.numberPicker)
//
//    np.setMinValue(2)
//    np.setMaxValue(20)
//
//    np.setOnValueChangedListener(onValueChangeListener)
//}
//
//var onValueChangeListener: NumberPicker.OnValueChangeListener =
//    NumberPicker.OnValueChangeListener { numberPicker, i, i1 ->
//        Toast.makeText(
//            this@MainActivity,
//            "selected number " + numberPicker.value, Toast.LENGTH_SHORT
//        )
//    }