package com.lizdev.appnavigation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
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
fun DetailView(navController: NavController) {
    Scaffold(
        topBar = {
            TitleBar(title = "Detalles", showBackButton = true, onBackClick = { navController.popBackStack() })
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            IconTitle(icon = Icons.Default.Build, text = "Detalles de la Aplicación")

            InfoCard(title = "Información Técnica") {
                Column {
                    Text("- Versión: 1.0.0")
                    Text("- Desarrollado con Jetpack Compose")
                    Text("- Navegación con Navigation Component")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("- Elaborado por: Lizandro Antonio Santos")
                }
            }

            Space(20.dp)

            Button(
                onClick = { navController.navigate(Screen.AcercaDe.route) },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                Text("Ver Más Información")
            }
        }
    }
}
