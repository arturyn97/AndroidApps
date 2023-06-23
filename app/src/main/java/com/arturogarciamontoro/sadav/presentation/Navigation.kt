package com.arturogarciamontoro.sadav.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.arturogarciamontoro.sadav.presentation.features.NavGraphs
import com.arturogarciamontoro.sadav.presentation.theme.ApplicationSanDavAndroidTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.NavGraph

@NavGraph(
    default = true
)
annotation class DefaultNavGraph(
    val start: Boolean = false
)

@Composable
fun Navigation() {

    val navController = rememberNavController()

    ApplicationSanDavAndroidTheme() {
        DestinationsNavHost(
            navController = navController,
            navGraph = NavGraphs.default
        )
    }

}