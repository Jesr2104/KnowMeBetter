package com.just_jump.knowmebetter.domain.datamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuestionDataModel (
    val id: Int = 0,
    val category: String = "",
    val question: String = ""
)  : Parcelable