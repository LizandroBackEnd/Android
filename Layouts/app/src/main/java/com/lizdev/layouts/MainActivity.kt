package com.lizdev.layouts

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.lizdev.layouts.ui.theme.LayoutsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutsTheme {
                //LayoutBox()
                LayoutConstraintLayout()

            }
        }
    }
}

@Composable
fun LayoutBox () {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Box (
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .align(Alignment.TopStart)
        )
        Box (
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .align(Alignment.TopCenter)
        )
        Box (
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .align(Alignment.TopEnd)
        )
        Box (
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .align(Alignment.CenterStart)
        )
        Box (
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .align(Alignment.Center)
        )
        Box (
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .align(Alignment.CenterEnd)
        )
        Box (
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .align(Alignment.BottomStart)
        )
        Box (
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .align(Alignment.BottomCenter)
        )
        Box (
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .align(Alignment.BottomEnd)
        )

    }
}

@Composable
fun LayoutConstraintLayout() {
    ConstraintLayout (modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxBlue, boxGreen, boxMagenta, boxYellow) = createRefs()
        val topGuide = createGuidelineFromTop(0.2f)
        val startGuide = createGuidelineFromStart(0.2f)

        Box (modifier = Modifier.size(100.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(parent.top, margin = 20.dp)
            start.linkTo(parent.start)
            end.linkTo(boxBlue.start)
        })

        Box (modifier = Modifier.size(100.dp).background(Color.Blue).constrainAs(boxBlue){
            top.linkTo(parent.top, margin = 20.dp)
            start.linkTo(boxRed.end)
            end.linkTo(parent.end)
        })

        Box (modifier = Modifier.size(100.dp).background(Color.Green).constrainAs(boxGreen){
            top.linkTo(topGuide)
            start.linkTo(startGuide)
        })

        Box (modifier = Modifier.size(100.dp).background(Color.Magenta).constrainAs(boxMagenta){
            top.linkTo(boxYellow.bottom)
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end, margin = 16.dp)
        })

        Box (modifier = Modifier.size(100.dp).background(Color.Yellow).constrainAs(boxYellow){
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)

        })
        
    }


}