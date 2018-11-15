package com.tomberghuis.pushups.ui.main

import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel


    // initialise this from database "last inserted pushupSet"

    // didn't need to use livedata for some reason, not using room
    var numPushups = 5
}
