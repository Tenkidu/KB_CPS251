package com.cps251.savenames.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var nameText = ""
    private var resultText="\n "
    fun setAmount(value: String) {
        this.nameText = value
        resultText += nameText+"\n"
    }
    fun getResult(): String {
        return resultText
    }
}