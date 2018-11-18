package com.tomberghuis.pushups.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.tomberghuis.pushups.R.id.numberPicker
import com.tomberghuis.pushups.data.PushupSetRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel(
    private val pushupSetRepository: PushupSetRepository
) : ViewModel() {
    // didn't need to use livedata for some reason, not using room

    // 2 way data binding number picker
    // TODO 2 way data binding aint working
//    var numPushupsNumberPicker: Int = 5
    var numPushupsNumberPicker = MutableLiveData<Int>()

    init {
        GlobalScope.launch(Main) {



            numPushupsNumberPicker.postValue(pushupSetRepository.getLastPushupSet().numPushups)
////            numPushupsNumberPicker = pushupSetRepository.getLastPushupSet().numPushups
////            Log.d("aaa",numPushupsNumberPicker.toString())
//
//
////            = async(IO) {
////                // what happens when run app for first time and db empty?
////                // basically thread is getting killed because getLastPushupSet returns null
////                // how does that work??? some sort of magic
//////            pushupSetRepository.getLastPushupSet().numPushups.let {
//////                // somehow the 2 way data binding is working even when assigning not on the UI thread
//////                numPushupsNumberPicker = it
//////            }
////                pushupSetRepository.getLastPushupSet().numPushups
////            }.await()
//            Log.d("aaa",numPushupsNumberPicker.value.toString())
        }

    }

    // TODO fix !!
    fun saveCompletedPushupSet(){
        pushupSetRepository.saveCompletedPushupSet(numPushupsNumberPicker.value!!)
    }

}
