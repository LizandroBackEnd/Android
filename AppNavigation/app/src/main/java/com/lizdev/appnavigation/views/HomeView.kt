package com.lizdev.appnavigation.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lizdev.appnavigation.R
import com.lizdev.appnavigation.components.InfoCard
import com.lizdev.appnavigation.components.MainIconButton
import com.lizdev.appnavigation.components.ProfileImage
import com.lizdev.appnavigation.components.Space
import com.lizdev.appnavigation.components.TitleBar
import com.lizdev.appnavigation.navigation.Screen
import com.lizdev.appnavigation.navigation.UserProfile

@Composable
fun HomeView(navController: NavController, userProfile: UserProfile) {
    val imageId = R.drawable.yo

    Scaffold(
        topBar = {
            TitleBar(title = "APP NAVIGATION", showBackButton = false)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Space(20.dp)

            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                ProfileImage(idImage = R.drawable.yo)
            }

            Space(40.dp)

            MainIconButton(icon = Icons.Default.Person, text = "Ir a Perfil") {
                navController.navigate(Screen.Perfil.route)
            }
            Space()
            MainIconButton(icon = Icons.Default.Settings, text = "Ir a Configuración") {
                navController.navigate(Screen.Configuracion.route)
            }
            Space()
            MainIconButton(icon = Icons.Default.Build, text = "Ir a Detalles") {
                navController.navigate(Screen.Detalles.route)
            }
            Space()
            MainIconButton(icon = Icons.Default.Info, text = "Ir a Acerca de") {
                navController.navigate(Screen.AcercaDe.route)
            }

            Space(20.dp)
            InfoCard(title = "Datos de Perfil") {
                Column {
                    Text("Nombre: ${userProfile.name}")
                    Text("Email: ${userProfile.email}")
                }
            }
        }
    }
}
