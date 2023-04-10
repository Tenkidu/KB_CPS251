package com.cps251.coroutines1

import androidx.lifecycle.ViewModel

private val names = mutableListOf<String>()

class MainViewModel : ViewModel() {
    fun getNames(): MutableList<String> {
        return names
    }
    fun addNames(name: String) {
        names.add(name)
    }
}