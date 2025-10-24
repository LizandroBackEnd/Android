package com.lizdev.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.lizdev.constraintlayout.ui.theme.ConstraintLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConstraintLayoutTheme {
                MyConstraintLayout()
            }
        }
    }
}

@Composable
fun MyConstraintLayout () {
    ConstraintLayout (modifier = Modifier.fillMaxSize()){
        val (boxRed, boxMagenta, boxBlack, boxCyan, boxYellow) = createRefs()

        Box (modifier = Modifier.size(150.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        })
        Box (modifier = Modifier.size(150.dp).background(Color.Magenta).constrainAs(boxMagenta){
            bottom.linkTo(boxRed.top)
            start.linkTo(boxRed.end)
        })
        Box (modifier = Modifier.size(150.dp).background(Color.Black).constrainAs(boxBlack){
            top.linkTo(boxRed.bottom)
            end.linkTo(boxRed.start)
        })
        Box (modifier = Modifier.size(150.dp).background(Color.Cyan).constrainAs(boxCyan){
            bottom.linkTo(boxRed.top)
            end.linkTo(boxRed.start)
        })
        Box (modifier = Modifier.size(150.dp).background(Color.Yellow).constrainAs(boxYellow){
            top.linkTo(boxRed.bottom)
            start.linkTo(boxRed.end)
        })

    }
}
