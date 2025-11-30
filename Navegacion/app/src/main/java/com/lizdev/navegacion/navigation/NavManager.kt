package com.lizdev.navegacion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lizdev.navegacion.views.DetailView
import com.lizdev.navegacion.views.HomeView

@Composable
fun NavManager() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home) {
        composable <Home> {
            HomeView(navController)
        }
        composable<Detail> {
            DetailView(navController)
        }
    }

}