package com.just_jump.knowmebetter.ui.screens.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class SelectCategoryViewModel @Inject constructor(
) : ViewModel() {

    private val _language = MutableLiveData<String>()
    val language: LiveData<String> = _language

    fun getLanguage() = viewModelScope.launch {
        _language.postValue("EN")
    }

    fun setLanguage() = viewModelScope.launch {

    }
}