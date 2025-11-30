package com.lizdev.appnavigation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lizdev.appnavigation.components.FormTextField
import com.lizdev.appnavigation.components.IconTitle
import com.lizdev.appnavigation.components.Space
import com.lizdev.appnavigation.components.TitleBar
import com.lizdev.appnavigation.navigation.UserProfile

@Composable
fun ProfileView(
    navController: NavController,
    userProfile: UserProfile,
    onSave: (UserProfile) -> Unit
) {
    var nameState by remember { mutableStateOf(userProfile.name) }
    var emailState by remember { mutableStateOf(userProfile.email) }

    Scaffold(
        topBar = {
            TitleBar(title = "Perfil", showBackButton = true, onBackClick = { navController.popBackStack() })
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            IconTitle(icon = Icons.Default.Person, text = "Perfil de Usuario")
            Space(20.dp)

            FormTextField(label = "Nombre", value = nameState, onValueChange = { nameState = it })
            FormTextField(label = "Email", value = emailState, onValueChange = { emailState = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Space(30.dp)

            Button(
                onClick = {
                    onSave(UserProfile(nameState, emailState))
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                Text("Guardar Cambios")
            }
        }
    }
}
