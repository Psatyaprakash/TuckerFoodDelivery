package com.example.tuckerfooddelivery.View

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tuckerfooddelivery.R

@Composable
fun Roll_Category(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        //first row of categories
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                CircularButtonWithSymbol(onClick = { /* handle click */ })
            }
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .width(150.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(36.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                border = BorderStroke(1.dp, Color.Black),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = "    Rolls",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        // second row
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Popular Rolls",
                fontSize = 18.sp
            )
        }

        //third row of two cards
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 15.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start
        ) {
            Card(
                modifier = Modifier
                    .height(230.dp)
                    .width(130.dp)
                    .clickable { navController.navigate("CrispyChickenRoll") },
                shape = RoundedCornerShape(15.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(7.dp) // Add some padding inside the card
                ) {
                    Image(
                        painter = painterResource(R.drawable.chickencrispy_roll),
                        contentDescription = "roollImage",
                        modifier = Modifier
                            .size(96.dp)
                    )
                    Text(
                        text = "Crispy Chicken Roll",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 4.dp) // Adjust top padding
                    )
                    Text(
                        text = "Fiona Hatty",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 1.dp)
                    )
                    Row(
                        modifier = Modifier.padding(top = 1.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = "$10",
                            modifier = Modifier.padding(top = 12.dp),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                        Spacer(modifier = Modifier.width(22.dp))
                        TextButton(
                            onClick = { /* add this item to cart */ },
                            colors = ButtonDefaults.buttonColors(Color(0xFFD4AF37)),
                            shape = CircleShape,
                            contentPadding = PaddingValues(0.dp),
                            modifier = Modifier
                                .size(50.dp)
                                .background(Color.Transparent, CircleShape)
                        ) {
                            Text(
                                text = "+",
                                fontSize = 30.sp,
                                color = Color.Black,
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.width(40.dp))
            Card(
                modifier = Modifier
                    .height(230.dp)
                    .width(130.dp)
                    .clickable { navController.navigate("PaneerRoll") },
                shape = RoundedCornerShape(15.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(4.dp) // Add some padding inside the card
                ) {
                    Image(
                        painter = painterResource(R.drawable.paneer_roll),
                        contentDescription = "Roll Image",
                        modifier = Modifier
                            .size(97.dp)
                    )
                    Text(
                        text = "Veg Paneer Roll",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp) // Adjust top padding
                    )
                    Text(
                        text = "SkyHigh Way",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 1.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = "$10",
                            modifier = Modifier.padding(top = 12.dp),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                        Spacer(modifier = Modifier.width(25.dp))
                        TextButton(
                            onClick = { /* add this item to cart */ },
                            colors = ButtonDefaults.buttonColors(Color(0xFFD4AF37)),
                            shape = CircleShape,
                            contentPadding = PaddingValues(0.dp),
                            modifier = Modifier
                                .size(50.dp)
                                .background(Color.Transparent, CircleShape)
                        ) {
                            Text(
                                text = "+",
                                fontSize = 30.sp,
                                color = Color.Black,
                            )
                        }
                    }
                }
            }
        }

    }
}