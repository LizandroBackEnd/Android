package com.lizdev.articulos.components

import androidx.benchmark.traceprocessor.Row
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.lizdev.articulos.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navController: NavController,
    currentRoute: String?,
    id: Int? = null,
    nombre: String? = null,
    hasStock: Boolean = true
) {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = getScreenLabel(currentRoute),
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        },
        navigationIcon = {
            when (currentRoute?.substringBefore("?")) {
                Screen.Home.route, Screen.Settings.route, Screen.Add.route -> { }

                Screen.Stock.route -> {
                    IconButton(onClick = {
                        navController.navigate(Screen.Home.route + "?user=Usuario")
                    }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Regresar",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
                Screen.Detail.route -> {
                    IconButton(onClick = {
                        navController.navigate(Screen.Stock.route + "?filter=")
                    }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Regresar",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
                Screen.Sell.route, Screen.Delete.route, Screen.Update.route -> {
                    IconButton(onClick = {
                        navController.navigate(
                            "${Screen.Detail.route}?id=${id ?: 1}&nombre=${nombre ?: "Artículo"}"
                        )
                    }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Regresar",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }
        },
        actions = {
            if (currentRoute?.substringBefore("?") == Screen.Stock.route && hasStock) {
                IconButton(onClick = {
                    navController.navigate(
                        "${Screen.Detail.route}?id=${id ?: 1}&nombre=${nombre ?: "Artículo"}"
                    )
                }) {
                    Icon(
                        Icons.Default.ArrowForward,
                        contentDescription = "Siguiente",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

fun getScreenLabel(route: String?): String {
    val baseRoute = route?.substringBefore("?")
    return when (baseRoute) {
        Screen.Home.route -> Screen.Home.label
        Screen.Add.route -> Screen.Add.label
        Screen.Stock.route -> Screen.Stock.label
        Screen.Detail.route -> Screen.Detail.label
        Screen.Sell.route -> Screen.Sell.label
        Screen.Delete.route -> Screen.Delete.label
        Screen.Update.route -> Screen.Update.label
        Screen.Settings.route -> Screen.Settings.label
        else -> ""
    }
}
