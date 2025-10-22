package ru.onlinestore.mobile.ui.primary

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.onlinestore.mobile.ui.navigation.secondary.SecondaryNavDisplay
import ru.onlinestore.mobile.ui.navigation.secondary.keys.Main
import ru.onlinestore.mobile.ui.util.KoinPreview

@Preview
@Composable
private fun PrimaryScreenPreview() =
    KoinPreview { PrimaryScreen() }

@Composable
fun PrimaryScreen() {
    val backstack = remember { mutableStateListOf<Any>(Main) }

    Scaffold(
        bottomBar = { BottomNavigation(backstack) }
    ) { padding ->
        SecondaryNavDisplay(Modifier.padding(padding), backstack)
    }
}