package com.lizdev.saludo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lizdev.saludo.ui.theme.SaludoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SaludoTheme {
                Saludo()
            }
        }
    }
}
@Composable
fun Saludo() {
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var saludo by remember { mutableStateOf("") }

    val context = LocalContext.current
    val foucsManager = LocalFocusManager.current

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image (
            painter = painterResource(R.drawable.ic_user),
            contentDescription = "USUARIO",
            modifier = Modifier.size(100.dp)
        )
        Text (
            text = "SALUDO",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField (
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            singleLine = true,
        )
        OutlinedTextField (
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Edad") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Row (
            modifier = Modifier
                .padding(12.dp)
        ) {
            Button (
                onClick = {
                    if(nombre.isEmpty() || edad.isEmpty()) {
                        Toast.makeText(context, "Falta capturar campos", Toast.LENGTH_LONG).show()
                    } else {
                        saludo = "Hola $nombre tienes $edad años"
                        Toast.makeText(context, saludo, Toast.LENGTH_SHORT).show()
                    }
                }
            ) {
                Text (text = "Saludar")
            }
            Spacer (modifier = Modifier.width(16.dp))
            Button (
                onClick = {
                    nombre = ""
                    edad = ""
                    saludo = ""
                    foucsManager.moveFocus(FocusDirection.Up)
                }
            ) {
                Text(text = "Limpiar")
            }
        }

    }

}
