package com.just_jump.knowmebetter.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.just_jump.knowmebetter.ui.screens.SplashScreen
import com.just_jump.knowmebetter.ui.theme.KnowMeBetterTheme

@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@Composable
fun NavigationHost(navController: NavHostController) {
    KnowMeBetterTheme {
        NavHost(navController = navController, NavItem.SplashScreen.route)
        {
            composable(route = NavItem.SplashScreen.route){
                SplashScreen()
            }
        }
    }
}