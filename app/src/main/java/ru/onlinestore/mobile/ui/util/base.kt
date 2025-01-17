package ru.onlinestore.mobile.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.network.ktor3.KtorNetworkFetcherFactory
import org.koin.android.ext.koin.androidLogger
import org.koin.compose.KoinApplication
import org.koin.core.logger.Level
import ru.onlinestore.mobile.di.koinModule

@Composable
fun ImageNetwork(
    link: String,
    contentDescription: String? = null,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    AsyncImage(
        model = link,
        contentDescription = contentDescription,
        imageLoader = ImageLoader.Builder(context).apply {
            components { add(KtorNetworkFetcherFactory()) }
        }.build(),
        modifier = modifier
    )
}

@Composable
fun KoinPreview(content: @Composable () -> Unit) =
    KoinApplication(
        application = {
            modules(koinModule)
            androidLogger(Level.DEBUG)
        },
        content = content
    )