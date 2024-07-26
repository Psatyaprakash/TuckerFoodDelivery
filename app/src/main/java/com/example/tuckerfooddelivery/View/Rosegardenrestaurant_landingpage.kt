package com.example.tuckerfooddelivery.View

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.shape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.ui.theme.PurpleGrey40
@Composable
fun Rosegardenrestaurant_landingpage() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(6.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularButtonWithSymbol(onClick = { /* handle click */ })
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Rose Garden Restaurant",
                color = Color(0xFFD4AF37),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 11.dp)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Patel Nagar, New Delhi \nPincode: 115800",
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(3.dp)
        )
        Image(
            painter = painterResource(R.drawable.group_597),
            contentDescription = "Rose Garden Restaurant title",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            shape = RectangleShape,
            colors = CardDefaults.cardColors(Color.Transparent),
            border = BorderStroke(3.dp, Color(0xFFD4AF37))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Rating",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(50.dp))
                    Text(
                        text = "Delivery",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.star),
                            contentDescription = "Rating",
                            modifier = Modifier.size(24.dp),
                            tint = Color(0xFFD4AF37)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "4.7",
                            fontSize = 16.sp
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.truck),
                            contentDescription = "delivery fee",
                            modifier = Modifier.size(24.dp),
                            tint = Color(0xFFD4AF37)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Free",
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.width(30.dp))
                        Icon(
                            painter = painterResource(R.drawable.clock),
                            contentDescription = "Delivery Time",
                            modifier = Modifier.size(20.dp),
                            tint = Color(0xFFD4AF37)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "20mins",
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        CategoryCard("Burger")
        CategoryCard("Chicken")
        CategoryCard("Hotdogs")
        CategoryCard("Wings")
        CategoryCard("Pizza")
    }
}

@Composable
fun CategoryCard(category: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(Color.Transparent),
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = category,
                    fontSize = 22.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Go to $category category",
                    modifier = Modifier.size(22.dp)
                )
            }
        }
    }
}
