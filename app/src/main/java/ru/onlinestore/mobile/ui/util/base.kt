package ru.onlinestore.mobile.ui.util

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.network.ktor3.KtorNetworkFetcherFactory
import org.koin.android.ext.koin.androidLogger
import org.koin.compose.KoinApplication
import org.koin.core.logger.Level
import ru.onlinestore.mobile.di.RemoteSourceModule
import ru.onlinestore.mobile.di.RepositoryModule
import ru.onlinestore.mobile.di.UseCaseModule
import ru.onlinestore.mobile.di.ViewModelModule
import ru.onlinestore.mobile.di.koinModule
import ru.onlinestore.mobile.ui.theme.OnlineStoreTheme

@Composable
fun ImageNetwork(
    link: String,
    contentDescription: String? = null,
    shape: Shape = RoundedCornerShape(0.dp),
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
    OnlineStoreTheme {
        KoinApplication(
            application = {
                modules(
                    koinModule,
                    UseCaseModule,
                    RepositoryModule,
                    RemoteSourceModule,
                    ViewModelModule
                )
                androidLogger(Level.DEBUG)
            },
            content = content
        )
    }