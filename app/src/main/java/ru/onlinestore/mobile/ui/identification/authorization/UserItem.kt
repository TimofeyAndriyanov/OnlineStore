package ru.onlinestore.mobile.ui.identification.authorization

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.onlinestore.mobile.ui.util.ImageNetwork

@Composable
@Preview(
    showBackground = true,
    device = "id:Xiaomi POCO M5s"
)
private fun UserItemPreview() =
    UserItem(
        linkAvatar = "",
        name = "",
        onClick = {  }
    )

@Composable
fun UserItem(
    linkAvatar: String,
    name: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(
                start = 16.dp,
                top = 8.dp,
                bottom = 8.dp,
                end = 16.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(space = 16.dp)
    ) {
        ImageNetwork(
            link = linkAvatar,
            modifier = Modifier
                .height(40.dp)
                .width(40.dp),
            shape = RoundedCornerShape(100.dp)
        )
        Text(
            text = name,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier

        )
    }
}