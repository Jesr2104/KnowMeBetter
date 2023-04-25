package com.just_jump.knowmebetter.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.just_jump.knowmebetter.R

@Composable
fun LanguageDropdownMenu(
    language: String,
    onLanguageSelected: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    var currentLanguage by remember { mutableStateOf("") }

    LaunchedEffect(language) {
        currentLanguage = language
    }

    Box(modifier = Modifier.wrapContentSize()) {
        TextButton(
            onClick = { expanded = true },
            modifier = Modifier.padding(10.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                when (currentLanguage) {
                    "EN" -> {
                        Image(
                            painter = painterResource(R.mipmap.icon_english),
                            contentDescription = "language-selector",
                            modifier = Modifier.size(25.dp)
                        )
                    }

                    "ES" -> {
                        Image(
                            painter = painterResource(R.mipmap.icon_spanish),
                            contentDescription = "language-selector",
                            modifier = Modifier.size(25.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text =
                    when (currentLanguage) {
                        "EN" -> "English"
                        "ES" -> "Spanish"
                        else -> "Unknown"
                    },
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .background(Color.White)
                .padding(
                    top = 3.dp,
                    bottom = 3.dp,
                    start = 5.dp,
                    end = 5.dp
                )
        ) {
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onLanguageSelected("EN")
                    currentLanguage = "EN"
                },
                leadingIcon = {
                    Image(
                        painter = painterResource(R.mipmap.icon_english),
                        contentDescription = "language-selector",
                        modifier = Modifier.size(20.dp)
                    )
                },
                text = { Text("English") },
            )
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onLanguageSelected("ES")
                    currentLanguage = "ES"
                },
                leadingIcon = {
                    Image(
                        painter = painterResource(R.mipmap.icon_spanish),
                        contentDescription = "language-selector",
                        modifier = Modifier.size(20.dp)
                    )
                },
                text = { Text("Spanish") },
            )
        }
    }
}