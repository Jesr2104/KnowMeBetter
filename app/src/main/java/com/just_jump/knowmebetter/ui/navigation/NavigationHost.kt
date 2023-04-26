package com.just_jump.knowmebetter.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.just_jump.knowmebetter.domain.datamodels.ConfigQuestionsDataModel
import com.just_jump.knowmebetter.ui.screens.SelectCategoryScreen
import com.just_jump.knowmebetter.ui.screens.ShowQuestionScreen
import com.just_jump.knowmebetter.ui.screens.SplashScreen
import com.just_jump.knowmebetter.ui.theme.KnowMeBetterTheme
import com.just_jump.knowmebetter.utilities.passOnDataGet
import com.just_jump.knowmebetter.utilities.passOnDataSet

// Key for Parameters
const val KEY_CONFIG_QUESTION = "configQuestions"

@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@Composable
fun NavigationHost(navController: NavHostController) {
    KnowMeBetterTheme {
        NavHost(navController = navController, NavItem.SplashScreen.route)
        {
            composable(route = NavItem.SplashScreen.route) {
                SplashScreen {
                    navController.navigate(NavItem.SelectCategory.route)
                }
            }

            composable(route = NavItem.SelectCategory.route) {
                SelectCategoryScreen { configQuestions ->
                    navController.passOnDataSet(key = KEY_CONFIG_QUESTION, value = configQuestions)
                    navController.navigate(NavItem.ShowQuestion.route)
                }
            }

            composable(route = NavItem.ShowQuestion.route) {
                val configQuestions =
                    navController.passOnDataGet<ConfigQuestionsDataModel>(KEY_CONFIG_QUESTION)
                if (configQuestions != null) {
                    ShowQuestionScreen(
                        configQuestions
                    ) { navController.popBackStack() }
                }
            }
        }
    }
}