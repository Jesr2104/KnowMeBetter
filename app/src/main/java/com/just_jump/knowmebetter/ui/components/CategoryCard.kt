package com.just_jump.knowmebetter.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.just_jump.knowmebetter.domain.datamodels.CategoryDataModel
import com.just_jump.knowmebetter.domain.datamodels.ConfigQuestionsDataModel
import com.just_jump.knowmebetter.ui.theme.black_transparent_color
import com.just_jump.knowmebetter.ui.theme.dark_grey_transparent_color
import com.just_jump.knowmebetter.ui.theme.light_green_color

@ExperimentalMaterial3Api
@Composable
fun CategoryCard(
    category: CategoryDataModel,
    language: String,
    onClick: (ConfigQuestionsDataModel) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                bottom = 5.dp,
                start = 20.dp,
                end = 20.dp
            ),
        colors = CardDefaults.cardColors(
            containerColor = dark_grey_transparent_color
        ),
        onClick = {
            onClick(
                ConfigQuestionsDataModel(
                    category.id,
                    language
                )
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(BorderStroke(0.5.dp, black_transparent_color))
                .padding(15.dp)
        ) {
            Text(
                text = category.name,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    shadow = Shadow(
                        offset = Offset(2f, 2f),
                        color = Color.Black,
                        blurRadius = 6f
                    )
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = category.description,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = light_green_color
            )
        }
    }
}