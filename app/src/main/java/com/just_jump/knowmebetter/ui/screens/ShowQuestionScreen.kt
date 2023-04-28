package com.just_jump.knowmebetter.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.just_jump.knowmebetter.R
import com.just_jump.knowmebetter.domain.datamodels.ConfigQuestionsDataModel
import com.just_jump.knowmebetter.ui.components.LoaderCircular
import com.just_jump.knowmebetter.ui.screens.viewmodels.ShowQuestionViewModel
import com.just_jump.knowmebetter.ui.theme.dark_grey_color
import com.just_jump.knowmebetter.ui.theme.dark_grey_transparent_color
import com.just_jump.knowmebetter.ui.theme.light_1_green_color
import com.just_jump.knowmebetter.ui.theme.light_green_color
import com.just_jump.knowmebetter.utilities.getCategory
import com.just_jump.knowmebetter.utilities.getCategoryNameById

@ExperimentalMaterial3Api
@Composable
fun ShowQuestionScreen(
    configQuestions: ConfigQuestionsDataModel,
    onClickToBack: () -> Unit,
) {
    // instance of the viewModel.
    val viewModel = hiltViewModel<ShowQuestionViewModel>()

    // var to check the singles executions.
    var checkExecute: Boolean by remember { mutableStateOf(true) }
    var loadingExecute: Boolean by remember { mutableStateOf(false) }

    // var to control when show and hide the loader.
    var loaderControl by remember { mutableStateOf(false) }

    // var to save the question.
    var questions by remember { mutableStateOf("") }

    // observable to check when the list if update.
    viewModel.questionsList.observeForever {
        loadingExecute = true
        loaderControl = false
        questions = viewModel.getQuestion()
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text =
                        when (configQuestions.language) {
                            stringResource(R.string.en) -> stringResource(R.string.question_en)
                            stringResource(R.string.es) -> stringResource(R.string.question_es)
                            else -> stringResource(R.string.option_Unknown)
                        },
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onClickToBack() }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.content_description_back),
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = dark_grey_color,
                    titleContentColor = Color.White,
                )
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = it.calculateTopPadding())
                    .clickable {
                        if (loadingExecute) {
                            questions = viewModel.getQuestion()
                        }
                    }
            ) {
                Image(
                    painter = painterResource(R.mipmap.background_show_question_screen),
                    contentDescription = stringResource(R.string.content_description_background),
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text =
                        when (configQuestions.language) {
                            stringResource(R.string.en) -> stringResource(R.string.category_en)
                            stringResource(R.string.es) -> stringResource(R.string.category_es)
                            else -> stringResource(R.string.option_Unknown)
                        },
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = light_1_green_color
                    )
                    getCategoryNameById(
                        configQuestions.category,
                        getCategory(configQuestions.language)
                    )?.let { category ->
                        Text(
                            text = category,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = light_green_color
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .fillMaxHeight(0.7f)
                            .clip(RoundedCornerShape(30.dp))
                            .background(dark_grey_transparent_color),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        if (checkExecute) {
                            when (configQuestions.language) {
                                stringResource(R.string.en) -> questions =
                                    stringResource(R.string.load_question_en)

                                stringResource(R.string.es) -> questions =
                                    stringResource(R.string.load_question_es)
                            }
                            viewModel.getQuestionsList(configQuestions)
                            checkExecute = false
                            loaderControl = true
                        }

                        Text(
                            text = questions,
                            color = Color.White,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(25.dp)
                        )
                        if (loaderControl) {
                            LoaderCircular()
                        }
                    }
                }

                Text(
                    text =
                    when (configQuestions.language) {
                        stringResource(R.string.en) -> stringResource(R.string.message_touch_screen_en)
                        stringResource(R.string.es) -> stringResource(R.string.message_touch_screen_es)
                        else -> stringResource(R.string.option_Unknown)
                    },
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = light_green_color,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 10.dp)
                )
            }
        }
    )
}