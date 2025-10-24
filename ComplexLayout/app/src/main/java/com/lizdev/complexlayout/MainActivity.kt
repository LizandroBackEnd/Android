package com.lizdev.complexlayout

import android.os.Bundle
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lizdev.complexlayout.ui.theme.ComplexLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComplexLayoutTheme {
                MyComplexLayout()
            }
        }
    }
}

@Composable
fun MyComplexLayout () {
    Column (modifier = Modifier.fillMaxSize()) {
        Box (modifier = Modifier
            .background(Color.Red)
            .weight(1f)
            .fillMaxWidth()
        )
        Box (modifier = Modifier
            .background(Color.Green)
            .weight(1f)
            .fillMaxWidth()
        ) {
            Row {
                Box (modifier = Modifier
                    .background(Color.Magenta)
                    .weight(1f)
                    .height(303.dp)
                )
                Box (modifier = Modifier
                    .background(Color.Black)
                    .weight(1f)
                    .height(303.dp)
                )
            }
        }
        Box (modifier = Modifier
            .background(Color.Yellow)
            .weight(1f)
            .fillMaxWidth()
        )
    }
}
