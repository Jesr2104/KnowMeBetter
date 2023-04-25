package com.just_jump.knowmebetter.domain.usecases

import com.just_jump.knowmebetter.data.repository.GetQuestionsRepository
import com.just_jump.knowmebetter.domain.datamodels.QuestionDataModel
import javax.inject.Inject

class GetQuestionsUsecases @Inject constructor(
    private val getQuestionsRepository: GetQuestionsRepository,
) {
    suspend fun invoke(
        categoryName: String?,
        language: String,
        onResult: (ArrayList<QuestionDataModel>) -> Unit
    ) {
        getQuestionsRepository.getQuestions(language) { questionsList ->
            val filterList = arrayListOf<QuestionDataModel>()

            if (categoryName == "Mixed category") {
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