package com.just_jump.knowmebetter.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.just_jump.knowmebetter.R
import com.just_jump.knowmebetter.domain.datamodels.CategoryDataModel
import com.just_jump.knowmebetter.domain.datamodels.ConfigQuestionsDataModel
import com.just_jump.knowmebetter.ui.components.CategoryCard
import com.just_jump.knowmebetter.ui.components.LanguageDropdownMenu
import com.just_jump.knowmebetter.ui.screens.viewmodels.SelectCategoryViewModel
import com.just_jump.knowmebetter.ui.theme.dark_grey_1_color
import com.just_jump.knowmebetter.ui.theme.dark_grey_color
import com.just_jump.knowmebetter.ui.theme.light_1_green_color
import com.just_jump.knowmebetter.utilities.getCategory

@ExperimentalMaterial3Api
@Composable
fun SelectCategoryScreen(onClick: (ConfigQuestionsDataModel) -> Unit) {
    // instance of the viewModel.
    val viewModel = hiltViewModel<SelectCategoryViewModel>()

    // var the save and get the value of the language  on the view.
    var language by remember { mutableStateOf("") }

    //get all the categories of the selected language.
    val categories: List<CategoryDataModel> = getCategory(language)

    // observable to know and change de value of the language
    viewModel.language.observeForever {
        language = it
    }

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name_full),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = dark_grey_color,
                    titleContentColor = Color.White,
                ),
                actions = {
                    LanguageDropdownMenu(language) {
                        viewModel.setLanguage(it)
                    }
                }
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = it.calculateTopPadding())
            ) {
                Image(
                    painter = painterResource(R.mipmap.background_select_category_screen),
                    contentDescription = stringResource(R.string.content_description_background),
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .padding(end = 80.dp, top = 15.dp, bottom = 10.dp)
                            .clip(RoundedCornerShape(0.dp, 20.dp, 200.dp, 0.dp))
                            .background(dark_grey_1_color)
                            .fillMaxWidth()

                    ) {
                        Text(
                            text =
                            when (language) {
                                stringResource(R.string.en) -> stringResource(R.string.select_category_en)
                                stringResource(R.string.es) -> stringResource(R.string.select_category_es)
                                else -> stringResource(R.string.option_Unknown)
                            },
                            fontWeight = FontWeight.Bold,
                            color = light_1_green_color,
                            textAlign = TextAlign.Center,
                            fontSize = 30.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = 20.dp,
                                    end = 35.dp,
                                    top = 15.dp,
                                    bottom = 15.dp
                                ),
                            style = TextStyle(
                                shadow = Shadow(
                                    offset = Offset(2f, 2f),
                                    color = Color.Black,
                                    blurRadius = 5f
                                )
                            )
                        )
                    }

                    LazyColumn {
                        items(categories) { itemCategory ->
                            if (language.isNotEmpty()) {
                                CategoryCard(itemCategory, language, onClick)
                            } else {
                                viewModel.getLanguage()
                            }
                        }
                        item {
                            Spacer(modifier = Modifier.height(15.dp))
                        }
                    }
                }
            }
        }
    )
}