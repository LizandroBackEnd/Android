package com.lizdev.layout1

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lizdev.layout1.ui.theme.Layout1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Layout1Theme {
                Layout()
            }
        }
    }
}

@Composable
fun Layout() {
    Column (modifier = Modifier.fillMaxSize()) {
        Box (modifier = Modifier
            .background(Color.Cyan)
            .weight(1f)
            .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Text (text = "Ejemplo 1", modifier = Modifier.padding(30.dp))
        }
        Row {
            Box (modifier = Modifier
                .background(Color.Red)
                .weight(1f)
                .height(303.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Text (text = "Ejemplo 2")
            }
            Box (modifier = Modifier
                .background(Color.Green)
                .weight(1f)
                .height(303.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                Text (text = "Ejemplo 3")
            }
        }
        Box (modifier = Modifier
            .background(Color.Magenta)
            .weight(1f)
            .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text (text = "Ejemplo 4")
        }
    }
}
