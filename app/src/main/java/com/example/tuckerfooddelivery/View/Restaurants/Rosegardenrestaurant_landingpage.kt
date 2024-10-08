package com.example.tuckerfooddelivery.View.Restaurants

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
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
fun Rosegardenrestaurant_landingpage(navController: NavController) {
    MainScreen(navController = navController) {
        RoseGarden(navController = it)
    }
}

@Composable
fun RoseGarden(navController: NavController){
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    Scaffold(
        modifier = Modifier.background(White),
        topBar = {
            TopAppBar(title =
            {
                Row(Modifier
                    .padding(5.dp,0.dp)
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CircularButtonWithSymbol(onClick = { navController.popBackStack() })


                    Text(
                        text = "Rose Garden Restaurant",
                        color = Mustard_yellow,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(20.dp),
                        textAlign = TextAlign.Center
                    )
                }
            },
                backgroundColor = White,
                modifier = Modifier
                    .height(60.dp)
            )
        },

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding),
            verticalArrangement = Arrangement.Top
        ) {

            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Saheed Nagar Bhubaneswar \nPincode: 751024",
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
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Perfect for breakfast, lunch, or dinner. They have an onsite bar, serve a variety of alcoholic beverages, and provide convenient options like curbside pickup and dine-in cozy atmosphere and friendly staff make you feel like part of the family.",
                textAlign = TextAlign.Justify,
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
//        Text(
//            text = "all you can eat",
//            textAlign = TextAlign.Center,
//            color = Color.Black,
//            fontSize = 16.sp,
//            modifier = Modifier
//                .fillMaxWidth()
//        )
            Text(
                text = "MENU",
                //textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 25.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                shape = RectangleShape,
                colors = CardDefaults.cardColors(Color.Transparent),
                border = BorderStroke(3.dp, Mustard_yellow)
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
                                text = "20mins",
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
                TextButton(onClick = { navController.navigate("BurgerBistro") }) {
                    Text(
                        text = "Burger Bistro",
                        fontSize = 22.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold
                    )
                }

                IconButton(onClick = { navController.navigate("BurgerBistro") }) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Go back",
                        modifier = Modifier.size(22.dp)
                    )
                }
            }

            // PizzaCalzone Button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(onClick = { navController.navigate("PizzaCalzone") }) {
                    Text(
                        text = "Pizza Calzone",
                        fontSize = 22.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold
                    )
                }

                IconButton(onClick = { navController.navigate("PizzaCalzone") }) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Go back",
                        modifier = Modifier.size(22.dp)
                    )
                }
            }


            // Hotdogs Button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(onClick = { navController.navigate("TibetanMomos") }) {
                    Text(
                        text = "Tibetan Momos",
                        fontSize = 22.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold
                    )
                }

                IconButton(onClick = { navController.navigate("TibetanMomos") }) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Go back",
                        modifier = Modifier.size(22.dp)
                    )
                }
            }


            // Wings Button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(onClick = { navController.navigate("ClassicFrenchFries") }) {
                    Text(
                        text = "Classic French Fries",
                        fontSize = 22.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold
                    )
                }

                IconButton(onClick = { navController.navigate("ClassicFrenchFries") }) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Go to Wings category",
                        modifier = Modifier.size(22.dp)
                    )
                }
            }

            // Pizza Button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(onClick = { navController.navigate("BlueLagoon") }) {
                    Text(
                        text = "Blue Lagoon",
                        fontSize = 22.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold
                    )
                }

                IconButton(onClick = { navController.navigate("BlueLagoon") }) {
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
                TextButton(onClick = { navController.navigate("ChickenWings") }) {
                    Text(
                        text = "Chicken Wings",
                        fontSize = 22.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold
                    )
                }

                IconButton(onClick = { navController.navigate("ChickenWings") }) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Go back",
                        modifier = Modifier.size(22.dp)
                    )
                }
            }
        }
    }
}
