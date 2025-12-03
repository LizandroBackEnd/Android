package com.lizdev.articulos.views

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lizdev.articulos.model.Articulo
import com.lizdev.articulos.model.ArticuloViewModel
import com.lizdev.articulos.navigation.Screen

@Composable
fun StockView(navController: NavController, articuloViewModel: ArticuloViewModel, filter: String) {
    val context = LocalContext.current
    val articulos = articuloViewModel.articulos.filter {
        it.nombre.contains(filter, ignoreCase = true)
    }
    val hasStock = articulos.isNotEmpty()

    LaunchedEffect(hasStock) {
        navController.currentBackStackEntry?.arguments?.putBoolean("hasStock", hasStock)
    }


    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Stock de Artículos")
        if (articulos.isEmpty()) {
            Toast.makeText(context, "No hay artículos", Toast.LENGTH_SHORT).show()
        }
        LazyColumn {
            items(articulos) { articulo ->
                Card(Modifier.fillMaxWidth().padding(8.dp)) {
                    Column(Modifier.padding(8.dp)) {
                        Text(articulo.nombre)
                        Text("Precio: ${articulo.precio}")
                        Text("Stock: ${articulo.stock}")
                        Button(onClick = {
                            navController.navigate("${Screen.Detail.route}?id=${articulo.id}&nombre=${articulo.nombre}")
                        }) {
                            Text("Ver Detalle")
                        }
                    }
                }
            }
        }
    }
}

