package com.tomberghuis.pushups.viewmodels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.tomberghuis.pushups.data.PushupSetRepository


class MainViewModelFactory(
    private val pushupSetRepository: PushupSetRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(pushupSetRepository) as T
    }
}
