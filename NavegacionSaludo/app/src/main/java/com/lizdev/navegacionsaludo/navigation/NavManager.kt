package com.lizdev.navegacionsaludo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.lizdev.navegacionsaludo.views.GetDatesView
import com.lizdev.navegacionsaludo.views.HomeView

@Composable
fun NavManager() {
    val navController  = rememberNavController()

    NavHost(navController = navController, startDestination = Home) {
        composable <Home> {
            HomeView(navController)
        }
        composable <GetDates> { backStackEntry ->
            val getDates = backStackEntry.toRoute<GetDates>()
            GetDatesView(navController, name = getDates.name, age = getDates.age)
        }
    }

}