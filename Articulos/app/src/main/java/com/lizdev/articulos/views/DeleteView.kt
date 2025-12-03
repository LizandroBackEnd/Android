package com.lizdev.articulos.views

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lizdev.articulos.model.ArticuloViewModel
import com.lizdev.articulos.navigation.Screen

@Composable
fun DeleteView(navController: NavController, id: Int?, nombre: String?, articuloViewModel: ArticuloViewModel) {
    val context = LocalContext.current

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Eliminar Artículo")
        Text("ID: ${id ?: "N/A"}")
        Text("Nombre: ${nombre ?: "Desconocido"}")

        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            if (id == null || nombre.isNullOrBlank()) {
                Toast.makeText(context, "No se puede eliminar: datos incompletos", Toast.LENGTH_SHORT).show()
            } else {
                articuloViewModel.eliminarArticulo(id)
                Toast.makeText(context, "Artículo $nombre eliminado", Toast.LENGTH_SHORT).show()
                navController.navigate(Screen.Stock.route + "?filter=")
            }
        },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Confirmar Eliminación")
        }
    }
}

