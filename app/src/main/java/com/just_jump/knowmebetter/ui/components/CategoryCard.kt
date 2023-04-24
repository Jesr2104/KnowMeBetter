package com.just_jump.knowmebetter.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.just_jump.knowmebetter.domain.datamodels.CategoryDataModel

@ExperimentalMaterial3Api
@Composable
fun CategoryCard(category: CategoryDataModel, onClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp, start = 15.dp, end = 15.dp),
        onClick = { onClick(category.id) }
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                text = category.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = category.description
            )
        }
    }
}