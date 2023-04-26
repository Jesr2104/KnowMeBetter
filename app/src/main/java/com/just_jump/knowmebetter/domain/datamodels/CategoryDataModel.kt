package com.just_jump.knowmebetter.domain.datamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryDataModel(
    val id: Int,
    val name: String,
    val description: String,
) : Parcelable