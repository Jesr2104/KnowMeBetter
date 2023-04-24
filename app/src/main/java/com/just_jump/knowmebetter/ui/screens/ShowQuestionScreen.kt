package com.just_jump.knowmebetter.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.just_jump.knowmebetter.ui.screens.viewmodels.ShowQuestionViewModel
import java.util.Random

@ExperimentalMaterial3Api
@Composable
fun ShowQuestionScreen(idCategory: Int, onClickToBack: () -> Unit) {

    val random = Random()

    // instance of the viewModel
    val viewModel = hiltViewModel<ShowQuestionViewModel>()

    // var to check the single execution on the api call.
    var checkExecute: Boolean by remember { mutableStateOf(true) }

    var questions by remember { mutableStateOf("") }

    viewModel.questionsList.observeForever {
        questions = it[random.nextInt(it.size)].question
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "titleScreen", fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = { onClickToBack() }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Gray,
                    titleContentColor = Color.White,
                )
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(top = it.calculateTopPadding())
                    .fillMaxSize()
                    .clickable {
                        if (viewModel.questionsList.value!!.size > 0) {
                            questions =
                                viewModel.questionsList.value!![random.nextInt(viewModel.questionsList.value!!.size)].question
                        }
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                if (checkExecute) {
                    viewModel.getQuestions(idCategory)
                    checkExecute = false
                }
                Text(
                    text = questions,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(25.dp)
                )
            }
        }
    )
}