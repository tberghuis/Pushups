package com.tomberghuis.pushups.viewmodels

import android.arch.lifecycle.ViewModel
import com.tomberghuis.pushups.data.PushupSetRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(
    private val pushupSetRepository: PushupSetRepository
) : ViewModel() {
    // TODO: Implement the ViewModel


    // initialise this from database "last inserted pushupSet"

    // didn't need to use livedata for some reason, not using room
//    var numPushups = 5

    // 2 way data binding number picker
    var numPushupsNumberPicker: Int = 5

    init {
        // if not null

        // TODO run room stuff on io thread
        // assign on UI thread
        GlobalScope.launch {

        }


        pushupSetRepository.getLastPushupSet().numPushups?.let {
            numPushupsNumberPicker = it
        }
    }


    fun saveCompletedPushupSet(){
        pushupSetRepository.saveCompletedPushupSet(numPushupsNumberPicker)
    }




}
