package ru.onlinestore.mobile.ui.log_in

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ListAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.onlinestore.mobile.R
import ru.onlinestore.mobile.ui.entities.log_in.LogInRequestBodyUI
import ru.onlinestore.mobile.ui.entities.state.LogInState
import ru.onlinestore.mobile.ui.util.KoinPreview

@Composable
@Preview(showBackground = true)
private fun LogInScreenPreview() = KoinPreview { LogInScreen(LogInState()) {} }

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun LogInScreen(
    state: LogInState,
    logIn: (LogInRequestBodyUI) -> Unit
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .padding(start = 36.dp, end = 36.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(22.dp, 22.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.log_in_to_your_account),
                style = MaterialTheme.typography.headlineLargeEmphasized,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(stringResource(R.string.username)) },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(stringResource(R.string.password)) },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextWithIconButton(
                onClick = {},
                label = stringResource(R.string.user_list),
                icon = Icons.AutoMirrored.Filled.ListAlt
            )
            Button(
                onClick = { logIn(LogInRequestBodyUI(username, password)) },
                enabled = false
            ) { Text(stringResource(R.string.log_in)) }
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun OutlinedTextWithIconButton(
    onClick: () -> Unit,
    label: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    val size = ButtonDefaults.ExtraSmallContainerHeight
    OutlinedButton(onClick, modifier) {
        Icon(icon, null, Modifier.size(ButtonDefaults.iconSizeFor(size)))
        Spacer(Modifier.size(ButtonDefaults.iconSpacingFor(size)))
        Text(label, style = ButtonDefaults.textStyleFor(size))
    }
}

//ListItem(
//    overlineContent = {
//        Text("")
//    },
//    headlineContent = {
//        Text("")
//    },
//    leadingContent = {
//
//    }
//)