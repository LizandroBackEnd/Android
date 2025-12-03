package com.lizdev.articulos.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object Home : Screen("HomeView", "Inicio", Icons.Default.Home)
    object Add : Screen("AddView", "Agregar", Icons.Default.Add)
    object Stock : Screen("StockView", "Stock", Icons.Default.List)
    object Detail :  Screen("DetailView", "Detalle", Icons.Default.Info)
    object Sell : Screen("SellView", "Vender", Icons.Default.ShoppingCart)
    object Delete : Screen("DeleteView", "Eliminar", Icons.Default.Delete)
    object Settings :  Screen("SettingsView", "Configuracion", Icons.Default.Settings)
    object Update : Screen("UpdateView", "Actualizar", Icons.Default.Edit)
}
