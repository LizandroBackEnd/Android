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
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lizdev.articulos.navigation.Screen

@Composable
fun SettingsView(navController: NavController, isDarkTheme: Boolean, onThemeChange: (Boolean) -> Unit) {
    val context = LocalContext.current
    var notificationsEnabled by remember { mutableStateOf(true) }
    var idioma by remember { mutableStateOf("es") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Configuración", modifier = Modifier.padding(bottom = 16.dp))

        // Modo oscuro
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Switch(
                checked = isDarkTheme,
                onCheckedChange = {
                    onThemeChange(it)
                    Toast.makeText(
                        context,
                        if (it) "Modo oscuro activado" else "Modo claro activado",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )
            Spacer(Modifier.width(8.dp))
            Text("Modo Oscuro")
        }

        Spacer(Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = notificationsEnabled,
                onCheckedChange = {
                    notificationsEnabled = it
                    Toast.makeText(
                        context,
                        if (it) "Notificaciones activadas" else "Notificaciones desactivadas",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )
            Spacer(Modifier.width(8.dp))
            Text("Notificaciones")
        }

        Spacer(Modifier.height(16.dp))

        Text("Idioma:", modifier = Modifier.align(Alignment.Start))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            RadioButton(
                selected = idioma == "es",
                onClick = {
                    idioma = "es"
                    Toast.makeText(context, "Idioma cambiado a Español", Toast.LENGTH_SHORT).show()
                }
            )
            Spacer(Modifier.width(8.dp))
            Text("Español")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            RadioButton(
                selected = idioma == "en",
                onClick = {
                    idioma = "en"
                    Toast.makeText(context, "Idioma cambiado a Inglés", Toast.LENGTH_SHORT).show()
                }
            )
            Spacer(Modifier.width(8.dp))
            Text("Inglés")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(Screen.Home.route + "?user=Usuario") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver al Inicio")
        }
    }
}

