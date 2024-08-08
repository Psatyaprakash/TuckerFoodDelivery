package com.example.tuckerfooddelivery.View.Category

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.example.tuckerfooddelivery.View.CircularButtonWithSymbol

@Composable
fun Burger_Category(navController: NavController){
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
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Burgers",
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
                text = "Popular Burgers",
                fontSize = 18.sp
            )
        }

        //third row of two burger cards
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
                    .clickable { navController.navigate("BurgerBistro") },
                shape = RoundedCornerShape(15.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(10.dp) // Add some padding inside the card
                ) {
                    Image(
                        painter = painterResource(R.drawable.burger_bistro),
                        contentDescription = "Burger Bistro Image",
                        modifier = Modifier
                            .size(96.dp)
                    )
                    Text(
                        text = "Burger Bistro",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp) // Adjust top padding
                    )
                    Text(
                        text = "Rose Garden",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 1.dp)
                    )
                    Row(
                        modifier = Modifier.padding(top = 2.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = "Rs.116",
                            modifier = Modifier.padding(top = 12.dp),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                        Spacer(modifier = Modifier.width(22.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.width(40.dp))
            Card(
                modifier = Modifier
                    .height(230.dp)
                    .width(130.dp)
                    .clickable { navController.navigate("SmokingBurger") },
                shape = RoundedCornerShape(15.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(8.dp) // Add some padding inside the card
                ) {
                    Image(
                        painter = painterResource(R.drawable.smokinburger),
                        contentDescription = "Smokin burger Image",
                        modifier = Modifier
                            .size(97.dp)
                    )
                    Text(
                        text = "Smokin burger",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp) // Adjust top padding
                    )
                    Text(
                        text = "Fiona Hatty",
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
                            text = "Rs.135",
                            modifier = Modifier.padding(top = 12.dp),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                        Spacer(modifier = Modifier.width(25.dp))

                    }
                }
            }
        }
        //4th row of two burger cards
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
                    .clickable { navController.navigate("ClassicBurger") },
                shape = RoundedCornerShape(15.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(7.dp) // Add some padding inside the card
                ) {
                    Image(
                        painter = painterResource(R.drawable.classicburger),
                        contentDescription = "Classic Burger Image",
                        modifier = Modifier
                            .size(90.dp)
                    )
                    Text(
                        text = "Classic Burger",
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
                            .padding(top = 2.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = "Rs.135",
                            modifier = Modifier.padding(top = 12.dp),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                        Spacer(modifier = Modifier.width(25.dp))

                    }
                }
            }

        }

    }
}