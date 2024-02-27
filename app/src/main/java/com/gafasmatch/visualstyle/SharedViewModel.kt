package com.gafasmatch.visualstyle

import androidx.lifecycle.ViewModel

class SharedViewModel:ViewModel() {
    companion object {
        var username: String = ""
    }
}