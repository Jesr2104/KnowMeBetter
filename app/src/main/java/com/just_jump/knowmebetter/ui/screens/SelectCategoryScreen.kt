package com.just_jump.knowmebetter.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.just_jump.knowmebetter.domain.datamodels.MyCategory
import com.just_jump.knowmebetter.utilities.getCategory

@Composable
fun SelectCategoryScreen() {
    val categories: List<MyCategory> = getCategory()

    Column {
        Text("Select a category:")
        LazyColumn {
            items(categories) { itemCategory ->
                Text(itemCategory.name)
            }
        }
    }
}