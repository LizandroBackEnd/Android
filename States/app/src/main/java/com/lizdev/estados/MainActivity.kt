package com.lizdev.estados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lizdev.estados.ui.theme.EstadosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EstadosTheme {
                //StateSample1()
                //StateSample2()
                //StateSample3()

                //var text by rememberSaveable() { mutableStateOf("") }
                //StateSample4(value = text, onValueChange = { text = it})

                val (value, onValueChange ) = rememberSaveable() { mutableStateOf("") }
                StateSample5(value = value, onValueChange = onValueChange)

            }
        }
    }
}

@Composable
fun StateSample1() {
    val text = remember { mutableStateOf("") }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField (
            value = text.value,
            onValueChange = { text.value = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer (Modifier.height(6.dp))
        Text (
            text = text.value,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(10.dp)
        )
        Spacer (Modifier.height(6.dp))
        Button (
            onClick = {
                text.value = ""
            },
            enabled = text.value.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text (text = "Clear")
        }
    }
}

@Composable
fun StateSample2() {
    var text by remember { mutableStateOf("") }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.Center
    ) {
        OutlinedTextField (
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer (modifier = Modifier.height(6.dp))
        Text (
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(10.dp)
        )
        Spacer (modifier = Modifier.height(6.dp))
        Button (
            onClick = {
                text = ""
            },
            enabled = text.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Clear")
        }
    }
}

@Composable
fun StateSample3 () {
    var text by rememberSaveable { mutableStateOf("") }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField (
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer (modifier = Modifier.height(6.dp))
        Text (
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(10.dp)
        )
        Spacer (modifier = Modifier.height(6.dp))
        Button (
            onClick = {
                text = ""
            },
            enabled = text.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Clear")
        }
    }
}

@Composable
fun StateSample4 (value: String, onValueChange: (String)-> Unit) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField (
            value = value,
            onValueChange = { onValueChange },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer (modifier = Modifier.height(6.dp))
        Text (
            text = value,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(10.dp)
        )
        Spacer (modifier = Modifier.height(6.dp))
        Button (
            onClick = {
                onValueChange("")
            },
            enabled = value.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text (text = "Clear")
        }
    }
}

@Composable
fun StateSample5 (value: String, onValueChange: (String) -> Unit) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField (
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer (modifier = Modifier.height(6.dp))
        Text (
            text = value,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(10.dp)
        )
        Spacer (modifier = Modifier.height(6.dp))
        Button (
            onClick = {
                onValueChange("")
            },
            enabled = value.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text (text = "Clear")
        }
    }
}