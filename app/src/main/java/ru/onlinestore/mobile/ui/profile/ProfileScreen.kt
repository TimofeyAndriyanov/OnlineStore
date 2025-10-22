package ru.onlinestore.mobile.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ru.onlinestore.mobile.R
import ru.onlinestore.mobile.ui.entities.state.ProfileState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(state: ProfileState) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                { Text(stringResource(R.string.profile)) }
            )
        }
    ) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {

        }
    }
}