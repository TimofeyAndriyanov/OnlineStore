package ru.onlinestore.mobile.ui.templates

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.onlinestore.mobile.ui.theme.black

@Composable
fun TextTemplate(
    label: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = label,
            style = TextStyle(
                fontSize = 11.sp,
                fontWeight = FontWeight.Black,
                color = black
            )
        )
        Text(
            text = text,
            style = TextStyle(
                fontSize = 19.sp,
                color = black
            )
        )
    }
}