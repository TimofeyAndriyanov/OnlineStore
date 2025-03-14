package ru.onlinestore.mobile.ui.identification.authorization

import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListDialog(onDismissRequest: () -> Unit) {

    BasicAlertDialog(
        onDismissRequest = onDismissRequest,
        content = {

        }
    )
}