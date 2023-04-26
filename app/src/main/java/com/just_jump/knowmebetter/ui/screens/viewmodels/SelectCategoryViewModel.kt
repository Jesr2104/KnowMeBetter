package com.just_jump.knowmebetter.ui.screens.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.just_jump.knowmebetter.domain.usecases.GetLanguageUsecases
import com.just_jump.knowmebetter.domain.usecases.SetLanguageUsecases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectCategoryViewModel @Inject constructor(
    private val setLanguageUsecases: SetLanguageUsecases,
    private val getLanguageUsecases: GetLanguageUsecases,
) : ViewModel() {

    private val _language = MutableLiveData<String>()
    val language: LiveData<String> = _language

    fun setLanguage(newLanguage: String) = viewModelScope.launch {
        setLanguageUsecases.invoke(newLanguage) {
            _language.postValue(newLanguage)
        }
    }

    fun getLanguage() = viewModelScope.launch {
        getLanguageUsecases.invoke {
            _language.postValue(it)
        }
    }
}