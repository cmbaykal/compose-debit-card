package com.example.cardviewexample.components.toslacard

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardviewexample.base.color
import com.example.cardviewexample.data.CardData
import com.example.cardviewexample.ui.theme.CardViewExampleTheme

@Composable
fun ToslaCardView(card: CardData? = null) {
    val expanded = remember { mutableStateOf(false) }

    val cardOffset by animateDpAsState(
        targetValue = if (expanded.value) 110.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = if (expanded.value) Spring.DampingRatioMediumBouncy else Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Box(
        modifier = Modifier
            .background(Color.Transparent)
            .width(290.dp)
            .height(180.dp)
            .padding(10.dp)
            .shadow(15.dp, RoundedCornerShape(14.dp)),
        contentAlignment = Alignment.Center,
    ) {
        Card(
            backgroundColor = "#aa1e19".color,
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier.fillMaxSize(),
        ) {
            Text(
                modifier = Modifier.padding(start = 24.dp, top = 20.dp),
                color = Color.White,
                fontSize = 12.sp,
                text = card?.owner ?: "Test User"
            )
            Text(
                modifier = Modifier.padding(start = 24.dp, top = 40.dp),
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                text = card?.cardNo ?: "**** **** **** ****"
            )
            Text(
                modifier = Modifier.padding(start = 24.dp, top = 70.dp),
                color = Color.White,
                fontSize = 12.sp,
                text = card?.expireDate ?: "xx/xx"
            )
            Text(
                modifier = Modifier.padding(start = 100.dp, top = 70.dp),
                color = Color.White,
                fontSize = 12.sp,
                text = card?.cvv ?: "xxx"
            )
        }
        Card(
            backgroundColor = "#ff6d64".color,
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier
                .fillMaxSize()
                .offset(y = cardOffset)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                )
                {
                    expanded.value = !expanded.value
                }
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Kart bilgilerini görmek için dokun",
                    fontSize = 12.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToslaCardPreview() {
    CardViewExampleTheme {
        ToslaCardView()
    }
}