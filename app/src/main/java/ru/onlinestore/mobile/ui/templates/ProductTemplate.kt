package ru.onlinestore.mobile.ui.templates

import androidx.compose.ui.tooling.preview.Preview
import ru.onlinestore.mobile.ui.models.ProductUi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.*
import androidx.compose.ui.unit.*

@Composable
@Preview(device = "id:XiaomiPOCO M5s")
fun ProductTemplate(product: ProductUi? = null) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(5.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                TextTemplate(
                    label = "ID: ",
                    text = product?.id.toString(),
                    modifier = Modifier.padding(
                        start = 0.dp,
                        top = 0.dp,
                        end = 15.dp,
                        bottom = 0.dp
                    )
                )
                TextTemplate(
                    label = "Название:",
                    text = product?.title.toString(),
                    modifier = Modifier.padding(
                        start = 0.dp,
                        top = 0.dp,
                        end = 15.dp,
                        bottom = 0.dp
                    )
                )
            }
            TextTemplate(
                label = "Описание:",
                text = product?.description.toString(),
                modifier = Modifier.padding(
                    start = 0.dp,
                    top = 15.dp,
                    end = 0.dp,
                    bottom = 15.dp
                )
            )

            Row {
                TextTemplate(
                    label = "Бренд:",
                    text = product?.brand.toString(),
                    modifier = Modifier.padding(
                        start = 0.dp,
                        top = 0.dp,
                        end = 15.dp,
                        bottom = 0.dp
                    )
                )
                TextTemplate(
                    label = "Категория:",
                    text = product?.category.toString(),
                    modifier = Modifier.padding(
                        start = 0.dp,
                        top = 0.dp,
                        end = 0.dp,
                        bottom = 15.dp
                    )
                )
            }
            TextTemplate(
                label = "Цена:",
                text = product?.price.toString()
            )
        }
    }
}