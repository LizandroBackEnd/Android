package com.lizdev.navegacionparametros.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.lizdev.navegacionparametros.views.DetailView
import com.lizdev.navegacionparametros.views.HomeView

@Composable
fun NavManager() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home) {
        composable <Home> {
            HomeView(navController)
        }
        composable<Detail> { backStackEntry ->
            val detail = backStackEntry.toRoute<Detail>()
            DetailView(navController, id = detail.id, opcional = detail.opcional)
        }
    }

}