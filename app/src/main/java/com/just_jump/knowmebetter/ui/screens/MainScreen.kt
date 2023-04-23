package com.just_jump.knowmebetter.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.just_jump.knowmebetter.ui.navigation.NavigationHost

@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@Composable
fun MainScreen() {
    Scaffold { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavigationHost(rememberNavController())
        }
    }
}