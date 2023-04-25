package com.just_jump.knowmebetter.domain.datamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ConfigQuestionsDataModel (
    var category: Int,
    var language: String
)  : Parcelable