package com.just_jump.knowmebetter.ui.screens.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.just_jump.knowmebetter.domain.usecases.ClearRoomDBUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val clearRoomDBUseCases: ClearRoomDBUseCases
) : ViewModel() {

    fun clearAllRoomDB() = viewModelScope.launch {
        clearRoomDBUseCases.invoke()
    }
}