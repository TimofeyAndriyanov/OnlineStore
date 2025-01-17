package ru.onlinestore.mobile.ui.primary

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import ru.onlinestore.mobile.ui.navigation.secondary.BottomNavigation
import ru.onlinestore.mobile.ui.navigation.secondary.SecondaryGraph
import ru.onlinestore.mobile.ui.util.KoinPreview

@Preview
@Composable
private fun PrimaryScreenPreview() =
    KoinPreview { PrimaryScreen() }

@Composable
fun PrimaryScreen() {
    val controller = rememberNavController()
    Scaffold(
        content = { padding ->
            SecondaryGraph(
                controller = controller,
                modifier = Modifier.padding(padding)
            )
        },
        bottomBar = { BottomNavigation(controller = controller) }
    )
}