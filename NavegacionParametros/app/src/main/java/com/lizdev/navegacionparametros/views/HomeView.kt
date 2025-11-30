package com.lizdev.navegacionparametros.views

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lizdev.navegacionparametros.components.ActionButton
import com.lizdev.navegacionparametros.components.MainButton
import com.lizdev.navegacionparametros.components.TitleBar
import com.lizdev.navegacionparametros.components.TitleView
import com.lizdev.navegacionparametros.navigation.Detail

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar("HomeView") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Red
                )
            )
        },
        floatingActionButton = { ActionButton() }
    ) {
        ContentHomeView(navController)
    }
}

@Composable
fun ContentHomeView(navController: NavController) {

    var opcional by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        TitleView("Home View")
        Spacer(modifier = Modifier.padding(10.dp))
        TextField(
            value = opcional,
            onValueChange = {opcional = it},
            label = {Text("Opcional")}
        )
        Spacer(modifier = Modifier.padding(10.dp))
        MainButton(name = "Detail View", backColor = Color.Red, color = Color.White) {
            navController.navigate(Detail(id = 1234, opcional = opcional))
        }
    }
}