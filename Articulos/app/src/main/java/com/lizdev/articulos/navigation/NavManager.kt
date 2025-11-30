package com.lizdev.articulos.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.lizdev.articulos.components.BottomBar
import com.lizdev.articulos.components.TopBar
import com.lizdev.articulos.model.ArticuloViewModel
import com.lizdev.articulos.views.AddView
import com.lizdev.articulos.views.DeleteView
import com.lizdev.articulos.views.DetailView
import com.lizdev.articulos.views.HomeView
import com.lizdev.articulos.views.SellView
import com.lizdev.articulos.views.SettingsView
import com.lizdev.articulos.views.StockView


@Composable
fun NavManager(isDarkTheme: Boolean, onThemeChange: (Boolean) -> Unit) {
    val navController = rememberNavController()
    val articuloViewModel: ArticuloViewModel = viewModel()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        topBar = { TopBar(currentRoute) },
        bottomBar = { BottomBar(currentRoute, navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Home
            composable("${Screen.Home.route}?user={user}") { backStackEntry ->
                val user = backStackEntry.arguments?.getString("user") ?: "Invitado"
                HomeView(navController, user)
            }

            // Add
            composable(Screen.Add.route) {
                AddView(navController, articuloViewModel)
            }

            // Stock
            composable("${Screen.Stock.route}?filter={filter}") { backStackEntry ->
                val filter = backStackEntry.arguments?.getString("filter") ?: ""
                StockView(navController, articuloViewModel, filter)
            }

            // Detail
            composable("${Screen.Detail.route}?id={id}&nombre={nombre}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                val nombre = backStackEntry.arguments?.getString("nombre")
                DetailView(navController, id, nombre)
            }

            // Sell
            composable("${Screen.Sell.route}?id={id}&nombre={nombre}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                val nombre = backStackEntry.arguments?.getString("nombre")
                SellView(navController, id, nombre, articuloViewModel)
            }

            // Delete
            composable("${Screen.Delete.route}?id={id}&nombre={nombre}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                val nombre = backStackEntry.arguments?.getString("nombre")
                DeleteView(navController, id, nombre, articuloViewModel)
            }

            // Settings
            composable("${Screen.Settings.route}?dark={dark}") { backStackEntry ->
                val dark = backStackEntry.arguments?.getString("dark")?.toBoolean() ?: isDarkTheme
                SettingsView(navController, dark, onThemeChange)
            }
        }
    }
}
