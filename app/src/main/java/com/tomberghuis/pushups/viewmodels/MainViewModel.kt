package com.tomberghuis.pushups.viewmodels

import android.arch.lifecycle.ViewModel
import com.tomberghuis.pushups.data.PushupSetRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class MainViewModel(
    private val pushupSetRepository: PushupSetRepository
) : ViewModel() {
    // didn't need to use livedata for some reason, not using room

    // 2 way data binding number picker
    var numPushupsNumberPicker: Int = 5

    init {
        GlobalScope.async(IO) {
            // what happens when run app for first time and db empty?
            // basically thread is getting killed because getLastPushupSet returns null
            // how does that work??? some sort of magic
            pushupSetRepository.getLastPushupSet().numPushups.let {
                // somehow the 2 way data binding is working even when assigning not on the UI thread
                numPushupsNumberPicker = it
            }
        }
    }

    fun saveCompletedPushupSet(){
        pushupSetRepository.saveCompletedPushupSet(numPushupsNumberPicker)
    }

}
