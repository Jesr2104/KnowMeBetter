package com.just_jump.knowmebetter.domain.usecases

import com.just_jump.knowmebetter.data.repository.GetQuestionsRepository
import com.just_jump.knowmebetter.domain.datamodels.QuestionDataModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetQuestionsUsecases @Inject constructor(
    private val getQuestionsRepository: GetQuestionsRepository,
) {
    suspend fun invoke(
        categoryName: String?,
        language: String,
        onResult: (ArrayList<QuestionDataModel>) -> Unit,
    ) {
        getQuestionsRepository.getQuestionsFromRoom() { questionsList ->
            val filterList = arrayListOf<QuestionDataModel>()

            if (questionsList.isNotEmpty()) {
                GlobalScope.launch {
                    if (categoryName == "Mixed category" || categoryName == "Categoría mixta") {
                        filterList.addAll(questionsList)
                    } else {
                        questionsList.forEach { item ->
                            if (item.category == categoryName) {
                                filterList.add(item)
                            }
                        }
                    }
                    onResult(filterList)
                }
            } else {
                GlobalScope.launch {
                    getQuestionsRepository.getQuestionsFromApi(language) { questionsList ->
                        GlobalScope.launch {
                            getQuestionsRepository.clearAllQuestions()
                            getQuestionsRepository.insertQuestions(questionsList)
                        }

                        if (categoryName == "Mixed category" || categoryName == "Categoría mixta") {
                            filterList.addAll(questionsList)
                        } else {
                            questionsList.forEach { item ->
                                if (item.category == categoryName) {
                                    filterList.add(item)
                                }
                            }
                        }
                        onResult(filterList)
                    }
                }
            }
        }
    }
}