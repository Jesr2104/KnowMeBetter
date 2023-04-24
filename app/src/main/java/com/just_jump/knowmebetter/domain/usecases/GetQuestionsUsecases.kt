package com.just_jump.knowmebetter.domain.usecases

import com.just_jump.knowmebetter.data.repository.GetQuestionsRepository
import com.just_jump.knowmebetter.domain.datamodels.QuestionDataModel
import javax.inject.Inject

class GetQuestionsUsecases @Inject constructor(
    private val getQuestionsRepository: GetQuestionsRepository,
) {
    suspend fun invoke(categoryName: String?, onResult: (ArrayList<QuestionDataModel>) -> Unit) {
        getQuestionsRepository.getQuestions { questionsList ->
            val filterList = arrayListOf<QuestionDataModel>()
            questionsList.forEach { item ->
                if (categoryName != "Mixed category") {
                    if (item.category == categoryName) {
                        filterList.add(item)
                    }
                } else {
                    onResult(questionsList)
                }
            }
            onResult(filterList)
        }
    }
}