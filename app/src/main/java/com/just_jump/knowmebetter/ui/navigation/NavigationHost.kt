package com.just_jump.knowmebetter.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.just_jump.knowmebetter.ui.screens.SelectCategoryScreen
import com.just_jump.knowmebetter.ui.screens.ShowQuestionScreen
import com.just_jump.knowmebetter.ui.screens.SplashScreen
import com.just_jump.knowmebetter.ui.theme.KnowMeBetterTheme
import com.just_jump.knowmebetter.utilities.passOnDataGet
import com.just_jump.knowmebetter.utilities.passOnDataSet

// Key for Parameters
const val KEY_ID_CATEGORY = "idCategory"

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
                SelectCategoryScreen {
                    navController.passOnDataSet(key = KEY_ID_CATEGORY, value = it)
                    navController.navigate(NavItem.ShowQuestion.route)
                }
            }

            composable(route = NavItem.ShowQuestion.route) {
                val idCategory = navController.passOnDataGet<Int>(KEY_ID_CATEGORY)
                if (idCategory != null) {
                    ShowQuestionScreen(
                        idCategory
                    ) { navController.popBackStack() }
                }
            }
        }
    }
}