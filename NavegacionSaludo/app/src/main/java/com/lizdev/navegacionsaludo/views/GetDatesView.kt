package com.lizdev.navegacionsaludo.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lizdev.navegacionsaludo.components.FieldsViews
import com.lizdev.navegacionsaludo.components.MainButtonsView
import com.lizdev.navegacionsaludo.components.SpacerView
import com.lizdev.navegacionsaludo.components.TitleView
import com.lizdev.navegacionsaludo.navigation.Home

@Composable
fun GetDatesView (navController: NavController, name: String, age: Int) {

    var name by remember { mutableStateOf(name) }
    var age by remember { mutableStateOf(age.toString()) }
    val focus = remember { FocusRequester() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView("DATOS RECIBIDOS")
        SpacerView()
        FieldsViews(name = name, age = age, onNameChange = {name = it}, onAgeChange = {age = it})
        SpacerView()
        MainButtonsView(
            name = "Regresar",
            onClick = {
                navController.previousBackStackEntry?.savedStateHandle?.set("nombre", name)
                navController.previousBackStackEntry?.savedStateHandle?.set("edad", age)
                navController.popBackStack()
            },
            onClear = {
                name = ""
                age = ""
                focus.requestFocus()
            }
        )
    }
}