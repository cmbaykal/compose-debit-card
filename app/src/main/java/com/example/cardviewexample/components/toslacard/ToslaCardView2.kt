package com.example.cardviewexample.components.toslacard

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardviewexample.base.color
import com.example.cardviewexample.data.CardData
import com.example.cardviewexample.ui.theme.CardViewExampleTheme

@Composable
fun ToslaCardView2(card: CardData? = null) {
    var rotated by remember { mutableStateOf(false) }

    val rotation by animateFloatAsState(
        targetValue = if (rotated) 180f else 0f,
        animationSpec = tween(500)
    )

    val frontAlpha by animateFloatAsState(
        targetValue = if (!rotated) 1f else 0f,
        animationSpec = tween(500)
    )

    val backAlpha by animateFloatAsState(
        targetValue = if (rotated) 1f else 0f,
        animationSpec = tween(500)
    )

    Box(
        modifier = Modifier
            .width(290.dp)
            .height(180.dp)
            .padding(10.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { rotated = !rotated },
        contentAlignment = Alignment.Center,
    ) {
        Card(
            backgroundColor = "#aa1e19".color,
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier
                .fillMaxSize()
                .alpha(backAlpha)
                .graphicsLayer {
                    rotationY = rotation + 180f
                    cameraDistance = 90f
                    alpha = backAlpha
                },
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
                .graphicsLayer {
                    rotationY = rotation
                    cameraDistance = 90f
                    alpha = frontAlpha
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
fun ToslaCard2Preview() {
    CardViewExampleTheme {
        ToslaCardView2()
    }
}