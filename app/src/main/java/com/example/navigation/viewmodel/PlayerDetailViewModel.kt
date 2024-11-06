package com.example.navigation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

data class Detail(
    val favoriteCount: Int = 0,
    val nickName: String = "",
    val contentImage: Int = 0,
    val playerDescription: String = ""
)

class PlayerDetailViewModel: ViewModel() {


    private val _detail = MutableLiveData(Detail())
    val detail: LiveData<Detail> = _detail


    fun addFavorite() {
        viewModelScope.launch {
            _detail.value = _detail.value?.copy(
                favoriteCount = _detail.value?.favoriteCount?.plus(1) ?: 0
            )
        }
    }

    fun resetFavorite() {
        viewModelScope.launch {
            _detail.value = _detail.value?.copy(
                favoriteCount = 0
            )
        }
    }

    fun addName(name: String) {
        viewModelScope.launch {
            _detail.value = _detail.value?.copy(
                nickName = name
            )
        }
    }


}