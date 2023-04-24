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
import java.util.Random
import javax.inject.Inject

@HiltViewModel
class ShowQuestionViewModel @Inject constructor(
    private val getQuestionsUsecases: GetQuestionsUsecases,
) : ViewModel() {

    private val _questionsList = MutableLiveData<ArrayList<QuestionDataModel>>()
    val questionsList: LiveData<ArrayList<QuestionDataModel>> = _questionsList

    private val random = Random()

    fun getQuestion(): String {
        var result = ""
        _questionsList.value?.let { questionsList ->
            if (_questionsList.value!!.isNotEmpty()) {
                if (questionsList.isNotEmpty()) {
                    result = questionsList[random.nextInt(questionsList.size)].question
                }
            } else {
                result = "List is empty!!"
            }
        }
        return result
    }

    fun getQuestionsList(idCategory: Int) = viewModelScope.launch {
        val categoryName = getCategoryNameById(idCategory, getCategory())
        getQuestionsUsecases.invoke(categoryName) { result ->
            _questionsList.postValue(result)
        }
    }
}