package com.example.tuckerfooddelivery.View.Restaurants

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tuckerfooddelivery.MainScreen
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.View.Profile.CircularButtonWithSymbol

@Composable
fun SkyHighW_landingpage(navController: NavController) {
    MainScreen(navController = navController) {
        SkyHighW(navController = it)
    }
}
@Composable
fun SkyHighW(navController: NavController){
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
            CircularButtonWithSymbol(onClick = { navController.popBackStack()})
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "SkyHigh Way Restaurant",
                color = Color(0xFFD4AF37),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 11.dp)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "orish bakek, New Delhi \nPincode: 105070",
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(3.dp)
        )
        Image(
            painter = painterResource(R.drawable.group_599),
            contentDescription = "Restaurant title",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Whether you're looking for a place to enjoy breakfast, lunch, or dinner, this venue has you covered. They feature an onsite bar with a wide array of alcoholic beverages. Take advantage of their curbside pickup or opt for a dine-in experience. The warm atmosphere and hospitable staff will make you feel welcome and comfortable.",
            textAlign = TextAlign.Justify,
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "MENU",
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
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
                            text = "3.9",
                            fontStyle = FontStyle.Italic,
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
                            fontStyle = FontStyle.Italic,
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
                            text = "24mins",
                            fontStyle = FontStyle.Italic,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        // Burger Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = { navController.navigate("ClassicBurger") }) {
                Text(
                    text = "Classic Burger",
                    fontSize = 22.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold
                )
            }

            IconButton(onClick = { navController.navigate("ClassicBurger") }) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Go back",
                    modifier = Modifier.size(22.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = { navController.navigate("PaneerRoll") }) {
                Text(
                    text = "Paneer Roll",
                    fontSize = 22.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold
                )
            }

            IconButton(onClick = { navController.navigate("PaneerRoll") }) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Go back" ,
                    modifier = Modifier.size(22.dp)
                )
            }
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = { navController.navigate("MargheritaCornPizza") }) {
                Text(
                    text = "Margherita Corn Pizza",
                    fontSize = 22.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold
                )
            }

            IconButton(onClick = { navController.navigate("MargheritaCornPizza") }) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Go back",
                    modifier = Modifier.size(22.dp)
                )
            }
        }



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick =  { navController.navigate("NepaliDumplingMomos") } ) {
                Text(
                    text = "Nepali Dumpling",
                    fontSize = 22.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold
                )
            }

            IconButton(onClick = { navController.navigate("NepaliDumplingMomos") }) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Go to Wings category",
                    modifier = Modifier.size(22.dp)
                )
            }
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = { navController.navigate("PeriPeriFries") }) {
                Text(
                    text = "Peri Peri Fries",
                    fontSize = 22.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold
                )
            }

            IconButton(onClick = { navController.navigate("PeriPeriFries") }) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Go back",
                    modifier = Modifier.size(22.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = { navController.navigate("OrangeMimosa") }) {
                Text(
                    text = "Orange Mimosa",
                    fontSize = 22.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold
                )
            }

            IconButton(onClick = { navController.navigate("OrangeMimosa") }) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Go back",
                    modifier = Modifier.size(22.dp)
                )
            }
        }
    }
}