package ru.onlinestore.mobile.ui.products

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.onlinestore.mobile.ui.entities.ProductUI
import ru.onlinestore.mobile.ui.util.ImageNetwork

@Preview(
    showBackground = true,
    device = "id:Xiaomi POCO M5s"
)
@Composable
private fun ProductItemPreview() =
    ProductItem(product = ProductUI.default())

@Composable
fun ProductItem(product: ProductUI) {
    Row(
        content = {
            ImageNetwork(
                link = product.thumbnail,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .height(65.dp)
                    .width(65.dp)
                    .background(Color.White)
            )
            Column(
                content = {
                    Text(
                        text = product.title,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = "${product.price}$",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 12.dp,
                bottom = 12.dp
            )
    )
}