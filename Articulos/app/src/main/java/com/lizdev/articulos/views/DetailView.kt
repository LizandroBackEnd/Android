package com.lizdev.articulos.views

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lizdev.articulos.navigation.Screen

@Composable
fun DetailView(navController: NavController, id: Int?, nombre: String?) {
    val context = LocalContext.current

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Detalle del Artículo")
        Text("ID: ${id ?: "N/A"}")
        Text("Nombre: ${nombre ?: "Desconocido"}")

        LinearProgressIndicator(progress = { 0.5f }, modifier = Modifier.padding(vertical = 8.dp))

        Button(onClick = {
            if (id == null || nombre.isNullOrBlank()) {
                Toast.makeText(context, "No se puede vender: datos incompletos", Toast.LENGTH_SHORT).show()
            } else {
                navController.navigate("${Screen.Sell.route}?id=$id&nombre=$nombre")
            }
        },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Vender")
        }

        Spacer(Modifier.height(8.dp))

        Button(onClick = {
            if (id == null || nombre.isNullOrBlank()) {
                Toast.makeText(context, "No se puede eliminar: datos incompletos", Toast.LENGTH_SHORT).show()
            } else {
                navController.navigate("${Screen.Delete.route}?id=$id&nombre=$nombre")
            }
        },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Eliminar")
        }

        Button(
            onClick = {
                if (id == null) {
                    Toast.makeText(context, "No se puede actualizar: datos incompletos", Toast.LENGTH_SHORT).show()
                } else {
                    navController.navigate("${Screen.Update.route}?id=$id")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Actualizar")
        }
    }
}

