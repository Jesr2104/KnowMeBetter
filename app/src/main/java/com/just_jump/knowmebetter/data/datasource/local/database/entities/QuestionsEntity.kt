package com.just_jump.knowmebetter.data.datasource.local.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions_table")
data class QuestionsEntity (
    @PrimaryKey @ColumnInfo(name = "idParty") var idParty: String,
)