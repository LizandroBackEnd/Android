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
import com.lizdev.articulos.views.UpdateView

@Composable
fun NavManager(isDarkTheme: Boolean, onThemeChange: (Boolean) -> Unit) {
    val navController = rememberNavController()
    val articuloViewModel: ArticuloViewModel = viewModel()
    val backStackEntry = navController.currentBackStackEntryAsState().value
    val currentRoute = backStackEntry?.destination?.route

    val id = backStackEntry?.arguments?.getString("id")?.toIntOrNull()
    val nombre = backStackEntry?.arguments?.getString("nombre")

    val (hasStock, lastArticulo) = if (currentRoute?.substringBefore("?") == Screen.Stock.route) {
        val filter = backStackEntry?.arguments?.getString("filter") ?: ""
        val filtrados = articuloViewModel.articulos.filter {
            it.nombre.contains(filter, ignoreCase = true)
        }
        Pair(filtrados.isNotEmpty(), filtrados.lastOrNull())
    } else {
        Pair(true, null)
    }

    Scaffold(
        topBar = {
            TopBar(
                navController = navController,
                currentRoute = currentRoute,
                id = lastArticulo?.id ?: id,
                nombre = lastArticulo?.nombre ?: nombre,
                hasStock = hasStock
            )
        },
        bottomBar = { BottomBar(currentRoute, navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("${Screen.Home.route}?user={user}") { backStackEntry ->
                val user = backStackEntry.arguments?.getString("user") ?: "Invitado"
                HomeView(navController, user)
            }
            composable(Screen.Add.route) {
                AddView(navController, articuloViewModel)
            }
            composable("${Screen.Stock.route}?filter={filter}") { backStackEntry ->
                val filter = backStackEntry.arguments?.getString("filter") ?: ""
                StockView(navController, articuloViewModel, filter)
            }
            composable("${Screen.Detail.route}?id={id}&nombre={nombre}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                val nombre = backStackEntry.arguments?.getString("nombre")
                DetailView(navController, id, nombre)
            }
            composable("${Screen.Sell.route}?id={id}&nombre={nombre}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                val nombre = backStackEntry.arguments?.getString("nombre")
                SellView(navController, id, nombre, articuloViewModel)
            }
            composable("${Screen.Delete.route}?id={id}&nombre={nombre}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                val nombre = backStackEntry.arguments?.getString("nombre")
                DeleteView(navController, id, nombre, articuloViewModel)
            }
            composable("${Screen.Settings.route}?dark={dark}") { backStackEntry ->
                val dark = backStackEntry.arguments?.getString("dark")?.toBoolean() ?: isDarkTheme
                SettingsView(navController, dark, onThemeChange)
            }
            composable("${Screen.Update.route}?id={id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                UpdateView(navController, id, articuloViewModel)
            }
        }
    }
}






