package com.just_jump.knowmebetter.domain.usecases

import com.just_jump.knowmebetter.data.repository.ManagerLanguageRepository
import javax.inject.Inject

class SetLanguageUsecases @Inject constructor(
    private val managerLanguageRepository: ManagerLanguageRepository,
) {
    suspend fun invoke(language: String, onResult: (Boolean) -> Unit) {
        managerLanguageRepository.setLanguageValue(language) {
            onResult(it)
        }
    }
}