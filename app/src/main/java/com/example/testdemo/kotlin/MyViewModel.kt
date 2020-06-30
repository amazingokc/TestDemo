package com.example.testdemo.kotlin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    private fun makeNetworkRequest() {
        // launch a coroutine in viewModelScope
        viewModelScope.launch {

        }
    }

    // No need to override onCleared()
}