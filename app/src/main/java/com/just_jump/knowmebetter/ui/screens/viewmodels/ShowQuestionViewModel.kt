package com.just_jump.knowmebetter.ui.screens.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.just_jump.knowmebetter.domain.datamodels.QuestionDataModel
import com.just_jump.knowmebetter.domain.usecases.GetQuestionsUsecases
import com.just_jump.knowmebetter.utilities.getCategory
import com.just_jump.knowmebetter.utilities.getCategoryNameById
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowQuestionViewModel @Inject constructor(
    private val getQuestionsUsecases: GetQuestionsUsecases,
) : ViewModel() {

    private val _questionsList = MutableLiveData<ArrayList<QuestionDataModel>>()
    val questionsList: LiveData<ArrayList<QuestionDataModel>> = _questionsList

    fun getQuestions(idCategory: Int) = viewModelScope.launch {
        val categoryName = getCategoryNameById(idCategory, getCategory())
        getQuestionsUsecases.invoke(categoryName) { result ->
            if (result.size > 0){
                _questionsList.postValue(result)
            }
        }
    }
}