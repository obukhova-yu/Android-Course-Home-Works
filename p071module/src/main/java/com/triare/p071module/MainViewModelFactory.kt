package com.triare.p071module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MainViewModelFactory(val id:Int): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(modelClass::class.java)) return MainViewModel() as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}