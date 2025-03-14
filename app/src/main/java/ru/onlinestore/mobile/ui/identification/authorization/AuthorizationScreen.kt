package ru.onlinestore.mobile.ui.identification.authorization

import android.util.Log
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material.icons.rounded.List
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ru.onlinestore.mobile.ui.entities.auth.AuthRequestBodyUI
import ru.onlinestore.mobile.ui.entities.state.AuthState

@Composable
@Preview(
    showBackground = true,
    device = "id:Xiaomi POCO M5s"
)
private fun AuthorizationScreenPreview() =
    AuthorizationScreen(
        state = AuthState(),
        auth = {}
    )

@Composable
fun AuthorizationScreen(
    state: AuthState,
    auth: (AuthRequestBodyUI) -> Unit
) {
    val hostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Log.d("AuthorizationScreen", state.toString())
    Column(
        content = {
            Text(
                text = "Войти в аккаунт",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(bottom = 35.dp)
            )
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(text = "Имя пользователя") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Пароль") },
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Button(
                    onClick = {
                        auth(
                            AuthRequestBodyUI(
                                username = username,
                                password = username
                            )
                        )
                        if (state.invalidResponse.message.isNotEmpty())
                            scope.launch { hostState.showSnackbar(message = state.invalidResponse.message) }
                    },
                    enabled = username.isNotEmpty() and password.isNotEmpty(),
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth()
                        .weight(50f)
                        .padding(end = 10.dp)
                ) { Text(text = "Войти") }
                FloatingActionButton(
                    onClick = {
                        scope.launch {

                        }
                    },
                    elevation = FloatingActionButtonDefaults.elevation(0.dp,0.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.List,
                        contentDescription = null
                    )
                }
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 10.dp,
                end = 10.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )

    Box(
        content = {
            SnackbarHost(
                hostState = hostState,
                snackbar = {
                    Snackbar(
                        content = {
                            Text(
                                text = it.visuals.message,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    )
                }
            )
        },
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .offset(y = 50.dp)
            .padding(
                start = 15.dp,
                end = 15.dp
            )
    )
}