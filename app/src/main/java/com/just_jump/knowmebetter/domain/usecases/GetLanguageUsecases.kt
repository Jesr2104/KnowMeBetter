package com.just_jump.knowmebetter.domain.usecases

import com.just_jump.knowmebetter.data.repository.ManagerLanguageRepository
import javax.inject.Inject

class GetLanguageUsecases @Inject constructor(
    private val managerLanguageRepository: ManagerLanguageRepository,
) {
    suspend fun invoke(onResult: (String) -> Unit) {
        managerLanguageRepository.getLanguageValue {
            onResult(it)
        }
    }
}