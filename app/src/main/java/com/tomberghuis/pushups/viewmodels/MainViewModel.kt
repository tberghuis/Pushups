package com.tomberghuis.pushups.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.tomberghuis.pushups.R.id.numberPicker
import com.tomberghuis.pushups.data.CompletedPushupSet
import com.tomberghuis.pushups.data.PushupSetRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel(
    private val pushupSetRepository: PushupSetRepository
) : ViewModel() {

    // 2 way data binding number picker
    var numPushupsNumberPicker = MutableLiveData<Int>()

    init {
        // may not need Main dispatcher as using postValue
        // alternative to globalscope? context as coroutinescope???
        GlobalScope.launch(Main) {

            // use 5 as default val for fresh app with empty database
            numPushupsNumberPicker.postValue(5)

//            pushupSetRepository.getLastPushupSet()?.numPushups?.let {
//                numPushupsNumberPicker.postValue(it)
//            }
            val pushupSet = pushupSetRepository.getLastPushupSet()
            Log.d("aaa","pushupSet: $pushupSet")
            pushupSet?.numPushups.let {
                numPushupsNumberPicker.postValue(it)
            }

        }
    }

    fun saveCompletedPushupSet(){
        // pushupSetRepository.saveCompletedPushupSet(numPushupsNumberPicker.value!!)
        numPushupsNumberPicker.value?.let {
            pushupSetRepository.saveCompletedPushupSet(it)
        }
    }

}
