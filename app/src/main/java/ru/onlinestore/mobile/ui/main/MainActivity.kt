package ru.onlinestore.mobile.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint
import ru.onlinestore.mobile.ui.models.ProductUi
import ru.onlinestore.mobile.ui.templates.ProductTemplate
import ru.onlinestore.mobile.ui.theme.black

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main()
        }
    }

    @Composable
    @Preview(device = "id:XiaomiPOCO M5s")
    @OptIn(ExperimentalMaterial3Api::class)
    fun Main() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Список продуктов",
                            style = TextStyle(
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                color = black
                            )
                        )
                    }
                )
            },
            bottomBar = {
                BottomAppBar {

                }
            },
            content = {
                Column(
                    modifier = Modifier.padding(it)
                ) {

                }
            }
        )
    }

    @Composable
    private fun ListProducts(listProducts: List<ProductUi>) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(listProducts) { product ->
                ProductTemplate(product = product)
            }
        }
    }
}
