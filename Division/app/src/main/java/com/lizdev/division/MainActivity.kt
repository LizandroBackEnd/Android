package com.lizdev.division

import android.R.attr.onClick
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
import androidx.compose.foundation.layout.height
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lizdev.division.ui.theme.DivisionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DivisionTheme {
                Division()
            }
        }
    }
}

@Composable
fun Division () {
    var a by rememberSaveable { mutableStateOf("") }
    var b by rememberSaveable { mutableStateOf("") }
    var context = LocalContext.current
    var focusManager = LocalFocusManager.current
    var resultado by rememberSaveable { mutableStateOf("") }


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text (
            text = "División",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Image (
            painter = painterResource(R.drawable.math),
            contentDescription = "DIVISION",
            modifier = Modifier.size(150.dp)
        )
        OutlinedTextField (
            value = a,
            onValueChange = { a = it },
            label  = { Text("A")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField (
            value = b,
            onValueChange = { b = it },
            label  = { Text("B")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Row (
            modifier = Modifier.padding(12.dp)
        ) {
            Button (
                onClick = {
                    val numA = a.toDoubleOrNull()
                    val numB = b.toDoubleOrNull()

                    if(numA == null || numB == null) {
                        Toast.makeText(context, "Faltan ingresar datos", Toast.LENGTH_LONG).show()
                    } else if (numB == 0.0) {
                        Toast.makeText(context, "No se puede dividir entre cero", Toast.LENGTH_LONG).show()
                    } else {
                        resultado = String.format("%.2f", numA / numB)
                        Toast.makeText(context, "Resultado: $resultado", Toast.LENGTH_LONG).show()
                    }
                },
            ) {
                Text (text = "Dividir")
            }
            Spacer (modifier = Modifier.width(16.dp))
            Button (
                onClick = {
                    a = ""
                    b = ""
                    resultado = ""
                    focusManager.moveFocus(FocusDirection.Up)
                }
            ) {
                Text (text = "Limpiar")
            }

        }

    }

}
