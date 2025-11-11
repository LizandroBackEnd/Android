package com.lizdev.componentes

import android.R.attr.icon
import android.util.Log
import androidx.annotation.OptIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Componentes () {
    Card (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState())
    ) {
        NewTextView()
        NewTextField()
        CustomDivider()
        NewTextFieldOutlined()
        CustomDivider()
        NewImageView()
        CustomDivider()
        NewChip()
        CustomDivider()
        NewButton()
        CustomDivider()
        NewBadge()
        CustomDivider()
        NewChecks()
        CustomDivider()
        NewTextView()
        NewTextField()
        CustomDivider()
        NewTextFieldOutlined()
        CustomDivider()
        NewImageView()
        CustomDivider()
        NewChip()
        CustomDivider()
        NewButton()
        CustomDivider()
        NewBadge()
        CustomDivider()
        NewChecks()
        CustomDivider()
        NewTextView()
        NewTextField()
        CustomDivider()
        NewTextFieldOutlined()
        CustomDivider()
        NewImageView()
        CustomDivider()
        NewChip()
        CustomDivider()
        NewButton()
        CustomDivider()
        NewBadge()
        CustomDivider()
        NewChecks()
        CustomDivider()


    }
}

@Composable
fun NewChecks() {
    Row (verticalAlignment = Alignment.CenterVertically) {
        var isCheckboxChecked by remember { mutableStateOf(false) }
        Checkbox(checked = isCheckboxChecked, onCheckedChange = {isCheckboxChecked = it })
        Text(text = "Terminos y condiciones")
        Spacer(modifier = Modifier.weight(1f))
        var isSwitchChecked by remember { mutableStateOf(true) }
        Text(text = "Anuncios")
        Switch(checked = isSwitchChecked, onCheckedChange = {isSwitchChecked = it})
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewBadge () {
    Row (horizontalArrangement = Arrangement.spacedBy(58.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 32.dp)) {
        var contador by remember {mutableStateOf(0)}
        BadgedBox(badge = {
            Badge{
                val bagdeNumber = contador.toString()
                Text(text = bagdeNumber,
                    modifier = Modifier.semantics {
                        contentDescription = "$bagdeNumber items" }
                        .clickable {
                            contador++
                        })
            }
        }) {
            Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "Cart")
        }

        OutlinedButton(onClick = { /* TODO */}) {
            Text(text = "View Cart")
            BadgedBox(badge = {
                Badge {
                    val badgeNumber = "5"
                    Text(text = badgeNumber, modifier = Modifier.semantics {
                        contentDescription = "$badgeNumber items" })
                }
            }) {
                Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "Cart")
            }
        }
    }
}

@Composable
fun NewButton() {
    Row (horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Button(onClick = {}) {Text(text = "Finish")}
        Button(onClick = {/* TODO */}) {
            Icon(imageVector = Icons.Filled.Close, contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize))
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        }
        OutlinedButton(onClick = {/* TODO */}) { Text(text = "Back")}
        TextButton(onClick = {/* TODO */}) { Text(text = "Exit")}
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewChip() {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        SuggestionChip(
            onClick = { Log.d("Suggestion chip", "hello word")},
            label = {Text("Suggestion chip")},
        )
        AssistChip(
            onClick = { Log.d("Assist chip", "Hola Mundo")},
            label = {Text("Assist chip")},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Localized description",
                    modifier = Modifier.size(AssistChipDefaults.IconSize)
                )
            }
        )
        var selected by remember { mutableStateOf(false) }
        FilterChip(
            onClick = {selected = !selected},
            label = {
                Text("Filter chip")
            },
            selected = selected,
            leadingIcon = if (selected) {
                {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "Done icon",
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            } else {
                null
            }
        )
    }
}

@Composable
fun NewImageView() {
    Row(horizontalArrangement = Arrangement.spacedBy(24.dp),
        modifier = Modifier.padding(12.dp)) {
        Image (
            painter = painterResource(id = R.drawable.android),
            contentDescription = "Logo",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Image (
            painter = painterResource(id = R.drawable.android),
            contentDescription = "Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .aspectRatio(4f / 3f)
        )
        Image (
            painter = painterResource(id = R.drawable.android),
            contentDescription = "Logo",
            modifier = Modifier
                .size(80.dp)
                .blur(radius = 8.dp, edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(8.dp)))


        )
    }
}

@Composable
fun CustomDivider(){
    Spacer(modifier = Modifier.height(8.dp))
    HorizontalDivider(Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun MyPassword() {
    var passwordValue by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = passwordValue,
       onValueChange = {passwordValue = it },
        label = {Text("Password")},
        singleLine = true,
        placeholder = {Text("Password")},
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon =  {
            val image = if (passwordVisible)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            val description =  if (passwordVisible) "Hide password" else "Show password"

            if (passwordValue.isNotEmpty()) {
                Icon(imageVector = Icons.Filled.Clear, contentDescription = "Limpiar",
                    modifier = Modifier.padding(end = 44.dp).clickable {passwordValue = ""})

                IconButton(onClick = {passwordVisible = !passwordVisible}) {
                    Icon(imageVector = image, description)
                }
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun NewTextFieldOutlined() {
    var textvalue by remember { mutableStateOf("") }
    OutlinedTextField(
        value = textvalue,
        onValueChange = {textvalue = it},
        label = {Text(text = stringResource(R.string.ciclo_de_vida))},
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
     var passwordValue by remember { mutableStateOf("") }
    OutlinedTextField(
        value = passwordValue,
        onValueChange = {passwordValue = it},
        label = {Text(text = "Contraseña")},
        visualTransformation = PasswordVisualTransformation(),
        trailingIcon = {
            if (passwordValue.isNotEmpty()) {
                Icon(imageVector = Icons.Filled.Clear, contentDescription = "Limpiar",
                    modifier = Modifier.clickable{passwordValue = ""})
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
    MyPassword()
}

@Composable
fun NewTextField() {
    var textValue by remember { mutableStateOf("Hi") }
    TextField(
        value = textValue,
        onValueChange = {textValue = it},
        label = {Text(text = "Escribe algo")},
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun NewTextView() {
    Column {
        Text(
            text = "Jetpack Compose",
            color = Color.DarkGray,
            fontSize = 28.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Magenta,
                    offset = Offset(2f, 2f),
                    blurRadius = 4f
                )
            )
        )
        Text(
            text = "The best Jetpack Compose Course Dispositivos Moviles by the Dr. Ricardo Armando M.R All reserved 2025",
            style = MaterialTheme.typography.bodyLarge,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 18.sp
                )
            )
            {
                append("Batman")
            }
            append(", Bruce Wayne")
        })
        Text(
            text = "Let's go to the next one",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

