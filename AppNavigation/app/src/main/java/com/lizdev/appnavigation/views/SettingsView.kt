package com.lizdev.appnavigation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.lizdev.appnavigation.components.IconTitle
import com.lizdev.appnavigation.components.SettingsSwitch
import com.lizdev.appnavigation.components.TitleBar

@Composable
fun SettingsView(
    navController: NavController,
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit
) {
    val notificationsEnabled = remember { mutableStateOf(true) }
    Scaffold(
        topBar = {
            TitleBar(title = "Configuración", showBackButton = true, onBackClick = { navController.popBackStack() })
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            IconTitle(icon = Icons.Default.Settings, text = "Configuración")
            SettingsSwitch(
                text = "Notificaciones",
                checked = notificationsEnabled.value,
                onCheckedChange = { notificationsEnabled.value = it }
            )
            SettingsSwitch(
                text = "Modo Oscuro",
                checked = isDarkTheme,
                onCheckedChange = onThemeChange
            )
        }
    }}
