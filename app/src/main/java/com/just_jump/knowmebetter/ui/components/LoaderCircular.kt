package com.just_jump.knowmebetter.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.just_jump.knowmebetter.ui.theme.light_grey_color

@Composable
fun LoaderCircular() {
    val sizeLoader = 32.dp
    val strokeLoader = 4.dp

    CircularProgressIndicator(
        modifier = androidx.compose.ui.Modifier
            .size(sizeLoader),
        color = light_grey_color,
        strokeWidth = strokeLoader
    )
}