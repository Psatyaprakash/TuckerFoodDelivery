package com.example.tuckerfooddelivery.View

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tuckerfooddelivery.R


//Home Page UI
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun HomePage(navController: NavController) {
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Row {
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape)
                    .background(colorResource(id = R.color.Blue_Slight))
            ) {
                Image(
                    painter = painterResource(R.drawable.menu),
                    contentDescription = "3 bars",
                    Modifier
                        .size(22.dp)
                        .align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.width(5.dp))
            Column {
                Text(
                    text = "DELIVER TO",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )
                Text(
                    text = "Haldi Lab Office",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.width(180.dp))
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape)
                    .background(colorResource(id = R.color.Blue_Slight))


            ) {
                Image(
                    painter = painterResource(R.drawable.shopping_bag__2),
                    contentDescription = "Fire",
                    Modifier
                        .size(32.dp)
                        .align(Alignment.Center)
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = "Hey David, ", fontSize = 15.sp, color = Color.Black)
            Text(
                text = "Good Afternoon!",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        var text by remember { mutableStateOf("") }
        /*OutlinedTextField(
            value = text,
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 1.dp)
                .clip(RoundedCornerShape(size = 10.dp))
                .size(width = 490.dp, height = 50.dp),
            onValueChange = { text = it },
            label = { Text("Email ID or Mobile Number") },
            //leadingIcon = Icon.Default.LeftArrow
        )
        */

        var searchQuery by remember { mutableStateOf("") }

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp) ,
            placeholder = { Text("Search dishes, restaurants", color = Color.Black) },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null, tint = Color.Black) },
            trailingIcon = {
                IconButton(onClick = { /* TODO: Add action for microphone */ }) {
                    Icon(Icons.Default.Settings, contentDescription = null, tint = Color.Black)
                }
            },
//            colors = TextFieldDefaults.textFieldColors(
//                focusedIndicatorColor = colorResource(id = R.color.Blue_Slight),
//                unfocusedIndicatorColor = colorResource(id = R.color.Blue_Slight)
//            )
            colors = TextFieldDefaults.textFieldColors(containerColor = colorResource(id = R.color.Blue_Slight)),
            shape = RoundedCornerShape(20.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Text(
                text = "All Categories ",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.W500,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Spacer(
                modifier = Modifier
                    .width(135.dp)
                    .height(10.dp)
            )
            Text(
                text = "See all >",
                fontSize = 18.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
        ) {
            //Button1
            Button(
                onClick = { /* TODO: Insert action here */ },
                colors = ButtonDefaults.buttonColors(containerColor = Mustard_yellow),
                border = BorderStroke(width = 0.dp, color = Color.Transparent),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 5.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                ) {
                    Image(
                        painter = painterResource(R.drawable.fire),
                        contentDescription = "Fire",
                        Modifier
                            .size(30.dp)
                            .align(Alignment.Center)
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "All", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 18.sp)
                }
            }

            //Button2
            Button(
                onClick = { /* TODO: Insert action here */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = BorderStroke(width = 0.dp, color = Color.Transparent),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 5.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                ) {
                    Image(
                        painter = painterResource(R.drawable.hot_dog_icon),
                        contentDescription = "Hot Dog Icon",
                        Modifier
                            .size(27.dp)
                            .align(Alignment.Center)

                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Hot Dog", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 18.sp)
                }
            }

            //Button 3
            Button(
                onClick = { /* TODO: Insert action here */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = BorderStroke(width = 0.dp, color = Color.Transparent),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 5.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                ) {
                    Image(
                        painter = painterResource(R.drawable.burger_icon),
                        contentDescription = "Burger Icon",
                        Modifier
                            .size(27.dp)
                            .align(Alignment.Center)

                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Burger", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 18.sp)
                }
            }

            //Button 4
            Button(
                onClick = { /* TODO: Insert action here */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = BorderStroke(width = 0.dp, color = Color.Transparent),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 5.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                ) {
                    Image(
                        painter = painterResource(R.drawable.pizza),
                        contentDescription = "Pizza Icon",
                        Modifier
                            .size(27.dp)
                            .align(Alignment.Center)
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Pizza", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 18.sp)
                }
            }
        }



        Spacer(modifier = Modifier.height(12.dp))
        Row {
            Text(
                text = "Open Restaurants ",
                fontSize = 15.sp,
                color = Color.Black,
                fontWeight = FontWeight.W500,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Spacer(
                modifier = Modifier
                    .width(150.dp)
                    .height(10.dp)
            )
            Text(
                text = "See all >",
                fontSize = 15.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        //Card for Restaurant 1
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth()
                .size(width = 400.dp, height = 225.dp)
                .wrapContentHeight(),
            colors = CardColors(
                containerColor = Mustard_yellow_light,
                contentColor = Color.Black,
                disabledContentColor = Mustard_yellow,
                disabledContainerColor = Mustard_yellow
            ),
            onClick = {navController.navigate("Pizza")}
        ) {
            Image(
                painter = painterResource(id = R.drawable.restaurant_img_1),
                contentDescription = "Restaurant image 1",
                modifier = Modifier
                    .align(Alignment.Start)
                    .size(359.dp)
            )
        }
        Spacer(
            modifier = Modifier
                .height(25.dp)
                .width(10.dp)
        )
        Text(
            text = "Rose Garden Restaurant",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 20.sp,
            modifier = Modifier.padding(horizontal = 10.dp)
        )

        //Spacer(modifier = Modifier.height(1.dp).width(10.dp))
        Text(
            text = "Burger - Chicken - Rice - Wings ",
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 1.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.star_),
                contentDescription = "Star Rating icon",
                modifier = Modifier
                    .size(30.dp)
                    .padding(0.dp)
            )

            Text(
                text = "4.7",
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 2.dp)
            )
            Spacer(modifier = Modifier.width(40.dp))
            Image(
                painter = painterResource(id = R.drawable.truck_icon),
                contentDescription = "Truck icon",
                modifier = Modifier
                    .size(35.dp)
                    .padding(0.dp)
            )
            Text(
                text = "Free",
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 2.dp)
            )

            Spacer(modifier = Modifier.width(40.dp))
            Image(
                painter = painterResource(id = R.drawable.clock_icon),
                contentDescription = "Clock icon",
                modifier = Modifier
                    .size(35.dp)
                    .padding(0.dp)
            )
            Text(
                text = "20 min",
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 2.dp)
            )
        }

        //Restaurant2 card
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth()
                .size(width = 400.dp, height = 225.dp)
                .wrapContentHeight(),
            colors = CardColors(
                containerColor = Color.Transparent,
                contentColor = Color.Black,
                disabledContentColor = Mustard_yellow,
                disabledContainerColor = Mustard_yellow
            )
        ) {
            Box(
                modifier = Modifier
                    .size(height = 400.dp, width = 500.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.Transparent)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.restaurant_bg_2),
                    contentDescription = "Restaurant 2 image",
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .size(4009.dp),

                    )
                Image(
                    painter = painterResource(id = R.drawable.res_img_2),
                    contentDescription = "Restaurant 2 image",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(250.dp)
                )
            }
        }
        Spacer(
            modifier = Modifier
                .height(15.dp)
                .width(10.dp)
        )
        Text(
            text = "Billu Da Dhaba",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 20.sp,
            modifier = Modifier.padding(horizontal = 10.dp)
        )

        Text(
            text = "Pasta - Fish - Rice - Crabs ",
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 1.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.star_),
                contentDescription = "Star icon",
                modifier = Modifier
                    .size(30.dp)
                    .padding(0.dp)
            )

            Text(
                text = "4.3",
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 2.dp)
            )
            Spacer(modifier = Modifier.width(40.dp))
            Image(
                painter = painterResource(id = R.drawable.truck_icon),
                contentDescription = "Pizza",
                modifier = Modifier
                    .size(35.dp)
                    .padding(0.dp)
            )
            Text(
                text = "Free",
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 2.dp)
            )


            Spacer(modifier = Modifier.width(40.dp))
            Image(
                painter = painterResource(id = R.drawable.clock_icon),
                contentDescription = "Pizza",
                modifier = Modifier
                    .size(35.dp)
                    .padding(0.dp)
            )
            Text(
                text = "15 min",
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 2.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        //Card for Restaurant 1
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth()
                .size(width = 400.dp, height = 200.dp)
                .wrapContentHeight(),
            colors = CardColors(
                containerColor = Mustard_yellow_light,
                contentColor = Color.Black,
                disabledContentColor = Mustard_yellow,
                disabledContainerColor = Mustard_yellow
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.restaurant_img_3),
                contentDescription = "Pizza",
                modifier = Modifier
                    .align(Alignment.Start)
                    .size(450.dp)
            )
        }
        Spacer(
            modifier = Modifier
                .height(25.dp)
                .width(10.dp)
        )
        Text(
            text = "SkyHigh Way",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 20.sp,
            modifier = Modifier.padding(horizontal = 10.dp)
        )

        //Spacer(modifier = Modifier.height(1.dp).width(10.dp))
        Text(
            text = "Burger - Fries - Chicken - Wings ",
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 1.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.star_),
                contentDescription = "Pizza",
                modifier = Modifier
                    //.align(Alignment.Top)
                    .size(30.dp)
                    .padding(0.dp)
            )

            Text(
                text = "4.7",
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 2.dp)
            )
            Spacer(modifier = Modifier.width(40.dp))
            Image(
                painter = painterResource(id = R.drawable.truck_icon),
                contentDescription = "Pizza",
                modifier = Modifier
                    .size(35.dp)
                    .padding(0.dp)
            )
            Text(
                text = "Free",
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 2.dp)
            )

            Spacer(modifier = Modifier.width(40.dp))
            Image(
                painter = painterResource(id = R.drawable.clock_icon),
                contentDescription = "Pizza",
                modifier = Modifier
                    .size(35.dp)
                    .padding(0.dp)
            )
            Text(
                text = "20 min",
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 2.dp)
            )
        }
    }
}