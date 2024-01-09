package com.example.ecologic.ui.signinsignup

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.ecologic.ui.components.AuthUtil
import com.example.ecologic.ui.components.FirestoreUtil


@Composable
fun RegisterScreen(navController: NavController) {
    val context = LocalContext.current

    val username = remember { mutableStateOf(TextFieldValue()) }
    val usernameErrorState = remember { mutableStateOf(false) }

    val email = remember { mutableStateOf(TextFieldValue()) }
    val emailErrorState = remember { mutableStateOf(false) }

    val password = remember { mutableStateOf(TextFieldValue()) }
    val passwordErrorState = remember { mutableStateOf(false) }
    val passwordVisibility = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Red)) { append("") }
                withStyle(style = SpanStyle(color = Color.Black)) { append("Register") }
            },
            fontSize = 30.sp
        )

        Spacer(Modifier.size(16.dp))

        OutlinedTextField(
            value = username.value,
            onValueChange = {
                if (usernameErrorState.value) {
                    usernameErrorState.value = false
                }
                username.value = it
            },
            isError = usernameErrorState.value,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Enter Username*") }
        )
        if (usernameErrorState.value) {
            Text(text = "Required", color = Color.Red)
        }

        Spacer(Modifier.size(16.dp))

        OutlinedTextField(
            value = email.value,
            onValueChange = {
                if (emailErrorState.value) {
                    emailErrorState.value = false
                }
                email.value = it
            },
            isError = emailErrorState.value,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Enter Email*") }
        )
        if (emailErrorState.value) {
            Text(text = "Required", color = Color.Red)
        }

        Spacer(Modifier.size(16.dp))

        OutlinedTextField(
            value = password.value,
            onValueChange = {
                if (passwordErrorState.value) {
                    passwordErrorState.value = false
                }
                password.value = it
            },
            isError = passwordErrorState.value,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Enter Password*") },
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility.value = !passwordVisibility.value
                }) {
                    if (passwordVisibility.value) {
                        Icon(
                            imageVector = Icons.Default.VisibilityOff,
                            contentDescription = "visibility off",
                            tint = Color.Red
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.Visibility,
                            contentDescription = "visibility",
                            tint = Color.Red
                        )
                    }
                }
            },
            visualTransformation = if (passwordVisibility.value) PasswordVisualTransformation()
            else VisualTransformation.None
        )
        if (passwordErrorState.value) {
            Text(text = "Required", color = Color.Red)
        }

        Spacer(Modifier.size(16.dp))

        Button(
            onClick = {
                AuthUtil.registerUser(
                    email = email.value.text,
                    password = password.value.text,
                    username = username.value.text
                ) { success, errorMessage ->
                    if (success) {
                        // Registration successful
                        FirestoreUtil.addUserToFirestore(username = username.value.text)
                        Toast.makeText(context, "Registered successfully", Toast.LENGTH_SHORT).show()

                        // Navigate to the login screen after successful registration
                        navController.navigate("login")
                    } else {
                        // Registration failed, show error message
                        Toast.makeText(context, "Registration failed: $errorMessage", Toast.LENGTH_SHORT).show()
                    }
                }
            },
            content = { Text(text = "Register", color = Color.White) },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(Modifier.size(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            TextButton(onClick = {
                navController.navigate("login")
            }) {
                Text(text = "Already have an account? Login", color = Color.Red)
            }
        }
    }
}

@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewRegisterScreen() {
    RegisterScreen(navController = NavHostController(LocalContext.current))
}
