package com.lizdev.articulos.views

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lizdev.articulos.model.ArticuloViewModel
import com.lizdev.articulos.navigation.Screen

@Composable
fun UpdateView(navController: NavController, id: Int?, articuloViewModel: ArticuloViewModel){
    val context = LocalContext.current
    val articulo = articuloViewModel.articulos.find { it.id == id }

    var nombre by remember { mutableStateOf(articulo?.nombre ?: "") }
    var precio by remember { mutableStateOf(articulo?.precio?.toString() ?: "") }
    var stock by remember { mutableStateOf(articulo?.stock?.toString() ?: "") }
    var activo by remember { mutableStateOf(articulo?.activo ?: false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Actualizar Articulo", modifier = Modifier.padding(bottom = 16.dp))
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre")},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = stock,
            onValueChange = { stock = it },
            label = { Text("Stock")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = activo, onCheckedChange = { activo = it })
            Spacer(Modifier.width(8.dp))
            Text("Activo")
        }
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                if (articulo != null) {
                    articuloViewModel.eliminarArticulo(articulo.id)
                    articuloViewModel.agregarArticulo(
                        nombre,
                        precio.toDoubleOrNull() ?: 0.0,
                        stock.toIntOrNull() ?: 0,
                        activo
                    )
                    Toast.makeText(context, "Se ha actualizado correctamente", Toast.LENGTH_SHORT).show()
                    navController.navigate(Screen.Stock.route + "?filter=")
                } else {
                    Toast.makeText(context, "No se encotro el articulo", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar cambios")
        }
    }
}