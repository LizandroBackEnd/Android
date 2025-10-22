package com.lizdev.row

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lizdev.row.ui.theme.RowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RowTheme {
                MyRow()
            }
        }
    }
}

@Composable
fun MyRow() {
    Row (modifier = Modifier
        .fillMaxSize()
        .padding(12.dp)
        .horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        /*Text (
            text = "Hola",
            modifier = Modifier
                .background(Color.Red)
                .weight(1f)
                .fillMaxHeight()
        )
        Text (
            text = "Hola",
            modifier = Modifier
                .background(Color.Cyan)
                .weight(1f)
                .fillMaxHeight()
        )
        Text (
            text = "Hola",
            modifier = Modifier
                .background(Color.Yellow)
                .weight(1f)
                .fillMaxHeight()
        )
        Text (
            text = "Hola",
            modifier = Modifier
                .background(Color.Red)
                .weight(1f)
                .fillMaxHeight()
        )
        Text (
            text = "Hola",
            modifier = Modifier
                .background(Color.Cyan)
                .weight(1f)
                .fillMaxHeight()
        )
        Text (
            text = "Hola",
            modifier = Modifier
                .background(Color.Yellow)
                .weight(1f)
                .fillMaxHeight()
        )*/

        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Green))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Green))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Green))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Green))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Green))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Green))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Green))

    }
}

