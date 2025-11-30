package com.lizdev.appnavigation.navigation

sealed class Screen(val route: String) {
    object Inicio : Screen("inicio_view")
    object Perfil : Screen("perfil_view")
    object Configuracion : Screen("configuracion_view")
    object Detalles : Screen("detalles_view")
    object AcercaDe : Screen("acerca_de_view")
}