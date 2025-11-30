package com.lizdev.navegacionparametros.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lizdev.navegacionparametros.components.MainButton
import com.lizdev.navegacionparametros.components.MainIconButton
import com.lizdev.navegacionparametros.components.TitleBar
import com.lizdev.navegacionparametros.components.TitleView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(navController: NavController, id: Int, opcional: String) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar("DetailView") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue
                ),
                navigationIcon = {
                    MainIconButton(
                        icon = Icons.AutoMirrored.Default.ArrowBack
                    ) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        ContentDetailView(navController, id, opcional)
    }
}


@Composable
fun ContentDetailView(navController: NavController, id: Int, opcional: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView("Detail View")
        TitleView(id.toString())

        if (opcional == "") {
            Spacer(modifier = Modifier.height(16.dp))
        } else {
            TitleView(opcional)
        }

        MainButton(name = "Return Home", backColor = Color.Blue, color = Color.White) {
            navController.popBackStack()
        }
    }
}