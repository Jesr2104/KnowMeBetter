package com.just_jump.knowmebetter.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.just_jump.knowmebetter.domain.datamodels.CategoryDataModel
import com.just_jump.knowmebetter.domain.datamodels.ConfigQuestionsDataModel
import com.just_jump.knowmebetter.ui.components.CategoryCard
import com.just_jump.knowmebetter.ui.components.LanguageDropdownMenu
import com.just_jump.knowmebetter.ui.screens.viewmodels.SelectCategoryViewModel
import com.just_jump.knowmebetter.utilities.getCategory

@ExperimentalMaterial3Api
@Composable
fun SelectCategoryScreen(onClick: (ConfigQuestionsDataModel) -> Unit) {
    // instance of the viewModel.
    val viewModel = hiltViewModel<SelectCategoryViewModel>()

    val categories: List<CategoryDataModel> = getCategory()


    Scaffold(
        topBar = {
             SmallTopAppBar(
                 title = {
                     Text(
                         text = "Know Me Better!!",
                         fontSize = 24.sp,
                         fontWeight = FontWeight.Bold
                     )
                 },
                 colors = TopAppBarDefaults.smallTopAppBarColors(
                     containerColor = Color.Gray,
                     titleContentColor = Color.White,
                 ),
                 actions = {
                     LanguageDropdownMenu("EN"){
                         Log.e("Jesr", "Result: $it")
                     }
                 }
             )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(top = it.calculateTopPadding())
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Select a category",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
                LazyColumn {
                    items(categories) { itemCategory ->
                        CategoryCard(itemCategory, "EN", onClick)
                    }
                }
            }
        }
    )
}