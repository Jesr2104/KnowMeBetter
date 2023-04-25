package com.just_jump.knowmebetter.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.just_jump.knowmebetter.R
import com.just_jump.knowmebetter.ui.components.LoaderCircular
import com.just_jump.knowmebetter.ui.theme.light_green_color
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onNavigate: () -> Unit) {
    // var to check the singles executions.
    var checkExecute: Boolean by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.mipmap.background_splash_screen),
            contentDescription = "background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = 10.dp,
                    end = 10.dp
                )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Add the logo here.
                Image(
                    painter = painterResource(id = R.mipmap.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(300.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))

                // Add the slogan here.
                Text(
                    text = stringResource(R.string.slogan_app),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = light_green_color
                )
                Spacer(modifier = Modifier.height(25.dp))

                // show the loader
                if (checkExecute) {
                    LoaderCircular()
                }

                // delay until jump the de category select.
                LaunchedEffect(Unit) {
                    delay(1000)
                    onNavigate()
                    checkExecute = false
                }
            }

            Text(
                text = stringResource(R.string.app_version),
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
    }
}