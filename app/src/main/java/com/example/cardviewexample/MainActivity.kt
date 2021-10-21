package com.example.cardviewexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import com.example.cardviewexample.components.toslacard.ToslaCardView
import com.example.cardviewexample.components.toslacard.ToslaCardView2
import com.example.cardviewexample.data.CardData
import com.example.cardviewexample.ui.theme.CardViewExampleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardViewExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainActivityUI()
                }
            }
        }
    }
}

@Composable
fun MainActivityUI() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ToslaCardView(dummyCard)
        ToslaCardView2(dummyCard)
    }
}

private val dummyCard = CardData(
    "Cihat Mert Baykal",
    "5166 4353 3340 0130",
    "10/25",
    "336"
)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CardViewExampleTheme {
        MainActivityUI()
    }
}