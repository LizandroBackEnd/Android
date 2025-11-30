package com.lizdev.navegacionsaludo.views

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lizdev.navegacionsaludo.components.FieldsViews
import com.lizdev.navegacionsaludo.components.MainButtonsView
import com.lizdev.navegacionsaludo.components.SpacerView
import com.lizdev.navegacionsaludo.components.TitleView
import com.lizdev.navegacionsaludo.navigation.GetDates

@Composable
fun HomeView (navController: NavController) {

    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    val focus = remember { FocusRequester() }
    val context = LocalContext.current

    LaunchedEffect(navController.currentBackStackEntry) {
        val savedDates = navController.currentBackStackEntry?.savedStateHandle
        savedDates?.get<String>("nombre")?.let { name = it }
        savedDates?.get<String>("edad")?.let { age = it }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView("SALUDO")
        SpacerView()
        FieldsViews(name = name, age =  age, onNameChange = {name = it }, onAgeChange = {age = it})
        MainButtonsView(
            name = "Enviar",
            onClick = {
                if (name.isNotBlank() && age.isNotBlank()) {
                    navController.navigate(GetDates(name, age.toInt()))
                } else {
                    Toast.makeText(context, "Faltan capturar datos", Toast.LENGTH_LONG).show()
                }
            },
            onClear = {
                name = ""
                age = ""
                focus.requestFocus()
            }
        )
    }
}