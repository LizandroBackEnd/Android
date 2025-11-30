package com.lizdev.appnavigation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lizdev.appnavigation.views.AboutView
import com.lizdev.appnavigation.views.DetailView
import com.lizdev.appnavigation.views.HomeView
import com.lizdev.appnavigation.views.ProfileView
import com.lizdev.appnavigation.views.SettingsView

data class UserProfile(var name: String = "", var email: String = "")
@Composable
fun NavManager(isDarkTheme: Boolean, onThemeChange: (Boolean) -> Unit) {
    val navController = rememberNavController()
    var userProfile by remember { mutableStateOf(UserProfile("", "")) }
    NavHost(navController = navController, startDestination = Screen.Inicio.route) {

        composable(Screen.Inicio.route) {
            HomeView(navController, userProfile)
        }
        composable(Screen.Perfil.route) {
            ProfileView(navController, userProfile) { updatedProfile ->
                userProfile = updatedProfile
            }
        }
        composable(Screen.Configuracion.route) {
            SettingsView(
                navController,
                isDarkTheme = isDarkTheme,
                onThemeChange = onThemeChange
            )
        }
        composable(Screen.Detalles.route) {
            DetailView(navController)
        }
        composable(Screen.AcercaDe.route) {
            AboutView(navController)    }}}