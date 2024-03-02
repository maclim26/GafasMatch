package com.gafasmatch.visualstyle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gafasmatch.visualstyle.data.FavItem

class SharedViewModel:ViewModel() {
    private val _username = MutableLiveData<String>()
    val username: LiveData<String> get() = _username
    private val _favItems = MutableLiveData<MutableList<FavItem>>()
    val favItems: LiveData<MutableList<FavItem>>
        get() = _favItems
    fun setUsername(username: String) {
        _username.value = username
    }

    init {
        _favItems.value = mutableListOf()
    }

    fun addFavItem(favItem: FavItem) {
        _favItems.value?.add(favItem)
        _favItems.value = _favItems.value // Trigger LiveData update
    }

    fun removeFavItem(favItem: FavItem) {
        _favItems.value?.remove(favItem)
        _favItems.value = _favItems.value // Trigger LiveData update
    }

}