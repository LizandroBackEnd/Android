package com.lizdev.appnavigation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lizdev.appnavigation.components.IconTitle
import com.lizdev.appnavigation.components.InfoCard
import com.lizdev.appnavigation.components.Space
import com.lizdev.appnavigation.components.TitleBar
import com.lizdev.appnavigation.navigation.Screen

@Composable
fun AboutView(navController: NavController) {
    Scaffold(
        topBar = {
            TitleBar(title = "Acerca de", showBackButton = true, onBackClick = { navController.popBackStack() })
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            IconTitle(icon = Icons.Default.Info, text = "Acerca de")

            InfoCard(title = "Mi App de Navegación") {
                Column {
                    Text("Esta es una aplicación de ejemplo que demuestra la navegación entre 5 vistas diferentes usando Jetpack Compose y Navigation Component.")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Características:")
                    Text("- Navegación entre pantallas")
                    Text("- Diseño moderno con Material 3")
                    Text("- Botones de retroceso funcionales")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("- Copyright ©2025 Lizandro Antonio Santos")
                }
            }

            Space(20.dp)

            Button(
                onClick = { navController.navigate(Screen.Inicio.route) {
                    popUpTo(Screen.Inicio.route) { inclusive = true }
                }},
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                Text("Volver al Inicio")
            }
        }
    }
}
