package com.lizdev.articulos.views

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lizdev.articulos.model.ArticuloViewModel
import com.lizdev.articulos.navigation.Screen

@Composable
fun SellView(navController: NavController, id: Int?, nombre: String?, articuloViewModel: ArticuloViewModel) {
    val context = LocalContext.current
    var cantidad by remember { mutableStateOf(1f) }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Vender Artículo")
        Text("ID: ${id ?: "N/A"}")
        Text("Nombre: ${nombre ?: "Desconocido"}")

        Spacer(Modifier.height(8.dp))

        Text("Cantidad: ${cantidad.toInt()}")
        Slider(
            value = cantidad,
            onValueChange = { cantidad = it },
            valueRange = 1f..10f
        )

        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            if (id == null || nombre.isNullOrBlank()) {
                Toast.makeText(context, "No se puede vender: datos incompletos", Toast.LENGTH_SHORT).show()
            } else {
                articuloViewModel.venderArticulo(id, cantidad.toInt())
                Toast.makeText(context, "Venta realizada de ${cantidad.toInt()} unidades de $nombre", Toast.LENGTH_SHORT).show()
                navController.navigate(Screen.Stock.route + "?filter=")
            }
        },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Confirmar Venta")
        }
    }
}


