package com.lizdev.articulos.components

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.lizdev.articulos.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(currentRoute:  String?) {
    TopAppBar(
        title = {Text(getScreenLabel(currentRoute))},
    )
}

fun getScreenLabel(route: String?): String {
    return when (route) {
        Screen.Home.route -> Screen.Home.label
        Screen.Add.route -> Screen.Add.label
        Screen.Stock.route -> Screen.Stock.label
        Screen.Detail.route -> Screen.Detail.label
        Screen.Sell.route -> Screen.Sell.label
        Screen.Delete.route -> Screen.Delete.label
        Screen.Settings.route -> Screen.Settings.label
        else -> ""
    }
}