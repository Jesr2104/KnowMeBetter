package com.just_jump.knowmebetter.domain.usecases

import com.just_jump.knowmebetter.data.repository.GetQuestionsRepository
import javax.inject.Inject

class ClearRoomDBUseCases @Inject constructor(
    private val getQuestionsRepository: GetQuestionsRepository,
) {
    suspend fun invoke(){
        getQuestionsRepository.clearAllQuestions()
    }
}