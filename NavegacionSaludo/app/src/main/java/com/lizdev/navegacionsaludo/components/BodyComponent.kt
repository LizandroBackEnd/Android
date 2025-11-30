package com.lizdev.navegacionsaludo.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleView(name: String) {
    Text(
        text = name,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}

@Composable
fun FieldsViews (name: String, age: String, onNameChange: (String) -> Unit, onAgeChange: (String) -> Unit) {

    OutlinedTextField(
        value = name,
        onValueChange =  onNameChange,
        label = {Text("Nombre")}
    )
    SpacerView()
    OutlinedTextField(
        value = age,
        onValueChange = onAgeChange,
        label = {Text("Edad")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun MainButtonsView (name: String, onClick: () -> Unit, onClear: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Button(onClick = onClick) {
            Text(text = name)
        }
        Spacer(modifier = Modifier.width(40.dp))
        Button(onClick = onClear) {
            Text(text =  "Limpiar")
        }
    }

}

@Composable
fun SpacerView() {
    Spacer(modifier = Modifier.padding(10.dp) )
}