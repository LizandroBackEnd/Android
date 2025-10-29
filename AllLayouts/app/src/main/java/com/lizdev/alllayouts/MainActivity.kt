package com.lizdev.alllayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.constraintlayout.compose.ConstraintLayout
import com.lizdev.alllayouts.ui.theme.AllLayoutsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AllLayoutsTheme {
                //MyRow()
                //MyColumn()
                //MyBox()
                //MyConstraintLayout()
                MyComplexLayout()
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

@Composable
fun MyBox () {
    Box (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Box (modifier = Modifier
            .width(20.dp)
            .height(30.dp)
            .background(Color.Red)
            .verticalScroll(rememberScrollState())
        ) {
            Text (text = "Hola Hola Hola")
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




