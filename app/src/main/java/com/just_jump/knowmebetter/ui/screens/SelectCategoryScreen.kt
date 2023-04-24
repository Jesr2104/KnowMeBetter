package com.just_jump.knowmebetter.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.just_jump.knowmebetter.domain.datamodels.CategoryDataModel
import com.just_jump.knowmebetter.ui.components.CategoryCard
import com.just_jump.knowmebetter.utilities.getCategory

@ExperimentalMaterial3Api
@Composable
fun SelectCategoryScreen(onClick: (Int) -> Unit) {
    val categories: List<CategoryDataModel> = getCategory()

    Column {
        Text(
            text = "Select a category",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
        LazyColumn{
            items(categories) { itemCategory ->
                CategoryCard(itemCategory, onClick)
            }
        }
    }
}