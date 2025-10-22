package com.lizdev.column

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lizdev.column.ui.theme.ColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColumnTheme {
                MyColumn()
            }
        }
    }
}


@Composable
fun MyColumn () {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*Text (
            text = "Hola",
            modifier = Modifier
                .background(Color.Red)
                .weight(1f)
                .fillMaxWidth()
        )
        Text (
            text = "Hola",
            modifier = Modifier
                .background(Color.Cyan)
                .weight(1f)
                .fillMaxWidth()
        )
        Text (
            text = "Hola",
            modifier = Modifier
                .background(Color.Yellow)
                .weight(1f)
                .fillMaxWidth()
        )

        Text (
            text = "Hola",
            modifier = Modifier
                .background(Color.Red)
                .weight(1f)
                .fillMaxWidth()
        )
        Text (
            text = "Hola",
            modifier = Modifier
                .background(Color.Cyan)
                .weight(1f)
                .fillMaxWidth()
        )
        Text (
            text = "Hola",
            modifier = Modifier
                .background(Color.Yellow)
                .weight(1f)
                .fillMaxWidth()
        ) */
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
    }
}
