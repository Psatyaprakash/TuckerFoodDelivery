package com.example.tuckerfooddelivery.View

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tuckerfooddelivery.R
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import com.example.tuckerfooddelivery.ui.theme.TuckerFoodDeliveryTheme
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize

import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button

import androidx.compose.material3.Card

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Shapes
//import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush

import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import androidx.test.espresso.*
//import androidx.test.espresso.base.Default
import com.example.tuckerfooddelivery.View.Start
import com.example.tuckerfooddelivery.View.Start2
import com.example.tuckerfooddelivery.View.Start3


@Composable
fun Pizza(navController: NavController) {
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    Column {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .size(width = 500.dp, height = 655.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                TextButton(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(Color.Gray),
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Gray, CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.leftarrow),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )
                }
                Spacer(modifier = Modifier.width(1.dp))
                Text(
                    text = "Details",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                shape = RoundedCornerShape(16.dp),
                backgroundColor = Mustard_yellow,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
//                colors = CardColors(
//                    containerColor = Mustard_yellow_light, contentColor = Color.Black,
//                    disabledContentColor = Mustard_yellow,
//                    disabledContainerColor = Mustard_yellow
//                )
            ) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pizza_img),
                        contentDescription = "Pizza",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(200.dp)
                    )
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Add",
                        tint = Color.White,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(40.dp)
                            .background(Color.Red, shape = CircleShape)
                            .padding(8.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Pizza Calzone European",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(10.dp)
            )
            Spacer(modifier = Modifier.height(13.dp))
            Text(
                text = "Prosciutto e funghi is a pizza variety that is topped with tomato sauce.",
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 1.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.star),
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
                    painter = painterResource(id = R.drawable.truck),
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
                    painter = painterResource(id = R.drawable.clock),
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
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 1.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "SIZE:", modifier = Modifier.padding(horizontal = 10.dp))
                TextButton(onClick = {  },
                    colors = ButtonDefaults.buttonColors(containerColor = Mustard_yellow),
                    modifier = Modifier
                        .size(60.dp),
                    shape = CircleShape
                ){
                    Text(text = "10''", fontSize = 25.sp)
                }
//                Box(
//                    modifier = Modifier
//                        .size(45.dp)
//                        .clip(CircleShape)
//                        .background(Color.LightGray)
//                        .align(Alignment.CenterVertically)
//                ) {
//                    Text(text = "10''", modifier = Modifier.align(Alignment.Center))
//                }
                Spacer(modifier = Modifier.width(30.dp))
                TextButton(onClick = { navController.navigate("Pizza_2") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                    modifier = Modifier
                        .size(60.dp),
                    shape = CircleShape
                ){
                    Text(text = "14''", fontSize = 25.sp)
                }
//                Box(
//                    modifier = Modifier
//                        .size(45.dp)
//                        .clip(CircleShape)
//                        .background(Mustard_yellow)
//                        .align(Alignment.CenterVertically)
//                ) {
//                    Text(text = "14''", modifier = Modifier.align(Alignment.Center))
//                }
                Spacer(modifier = Modifier.width(30.dp))
                TextButton(onClick = { navController.navigate("Pizza_3") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                    modifier = Modifier
                        .size(60.dp),
                    shape = CircleShape
                ){
                    Text(text = "16''", fontSize = 25.sp)
                }
//                Box(
//                    modifier = Modifier
//                        .size(45.dp)
//                        .clip(CircleShape)
//                        .background(Color.LightGray)
//                        .align(Alignment.CenterVertically)
//                ) {
//                    Text(text = "16''", modifier = Modifier.align(Alignment.Center))
//                }
                Spacer(modifier = Modifier.width(20.dp))
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "INGRIDENTS", modifier = Modifier.padding(horizontal = 10.dp))
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 0.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.salt),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.kfc),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.garlic),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.onion),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.chilli),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
            }
            Spacer(modifier = Modifier.height(75.dp))
            Card(  //for scrolling purpose
                shape = RoundedCornerShape(16.dp),
                backgroundColor = Mustard_yellow,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
//            colors = CardColors(
//                containerColor = Mustard_yellow_light, contentColor = Color.Black,
//                disabledContentColor = Mustard_yellow,
//                disabledContainerColor = Mustard_yellow
//            )
            ) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pizza_img),
                        contentDescription = "Pizza",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(200.dp)
                    )
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Add",
                        tint = Color.White,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(40.dp)
                            .background(Color.Red, shape = CircleShape)
                            .padding(8.dp)
                    )
                }
            }

        }
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .size(height = 350.dp, width = 700.dp)
        ) {
            Row(
                modifier = Modifier.padding(10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "$26",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(20.dp),
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.width(150.dp))
                Box(modifier = Modifier
                    .size(height = 50.dp, width = 150.dp)
                    .background(color = Mustard_yellow, shape = CircleShape)
                    .align(Alignment.CenterVertically)) {
                    Row {
                        IconButton(onClick = { /* TODO: Add action for microphone */ }) {
                            Icon(
                                Icons.Default.KeyboardArrowDown,
                                contentDescription = null,
                                modifier = Modifier.size(50.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        var count = 0
                        Text(
                            text = "0", modifier = Modifier
                                .padding(vertical = 15.dp)
                                .padding(horizontal = 15.dp),
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.width(1.dp))
                        IconButton(onClick = { /* TODO: Add action for microphone */ }) {
                            Icon(
                                Icons.Default.KeyboardArrowUp,
                                contentDescription = null,
                                modifier = Modifier.size(50.dp)
                            )
                        }
                    }
                }

            }
               TextButton(onClick = { /*TODO*/ },
                   colors = ButtonDefaults.buttonColors(containerColor = Mustard_yellow),
                   border = BorderStroke(width = 0.dp, color = Color.Transparent),
                   elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                   modifier = Modifier
                       .padding(horizontal = 20.dp, vertical = 20.dp)
                       //.size(height = 40.dp, width = 400.dp),
                       .fillMaxWidth()
                       .height(54.dp),
                   shape = RoundedCornerShape(15.dp)
               ){
                  Text(text = "ADD TO CART", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 20.sp)
                   Spacer(modifier = Modifier.height(100.dp))
               }
            }
        }
    }
@Composable
fun Pizza_2(navController: NavController){
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    Column {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .size(width = 500.dp, height = 655.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                TextButton(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(Color.Gray),
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Gray, CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.leftarrow),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )
                }
                Spacer(modifier = Modifier.width(1.dp))
                Text(
                    text = "Details",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                shape = RoundedCornerShape(16.dp),
                backgroundColor = Mustard_yellow,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pizza),
                        contentDescription = "Pizza",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(200.dp)
                    )
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Add",
                        tint = Color.White,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(40.dp)
                            .background(Color.Red, shape = CircleShape)
                            .padding(8.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Pizza Calzone European",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(10.dp)
            )
            Spacer(modifier = Modifier.height(13.dp))
            Text(
                text = "Prosciutto e funghi is a pizza variety that is topped with tomato sauce.",
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 1.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.star),
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
                    painter = painterResource(id = R.drawable.truck),
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
                    painter = painterResource(id = R.drawable.clock),
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
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 1.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "SIZE:", modifier = Modifier.padding(horizontal = 10.dp))
                TextButton(onClick = { navController.navigate("Pizza") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                    modifier = Modifier
                        .size(60.dp),
                    shape = CircleShape
                ){
                    Text(text = "10''", fontSize = 25.sp)
                }
                Spacer(modifier = Modifier.width(30.dp))
                TextButton(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Mustard_yellow),
                    modifier = Modifier
                        .size(60.dp),
                    shape = CircleShape
                ){
                    Text(text = "14''", fontSize = 25.sp)
                }
                Spacer(modifier = Modifier.width(30.dp))
                TextButton(onClick = { navController.navigate("Pizza_3") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                    modifier = Modifier
                        .size(60.dp),
                    shape = CircleShape
                ){
                    Text(text = "16''", fontSize = 25.sp)
                }
                Spacer(modifier = Modifier.width(20.dp))
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "INGRIDENTS", modifier = Modifier.padding(horizontal = 10.dp))
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 0.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.salt),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.kfc),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.garlic),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.onion),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.chilli),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
            }
        }
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .size(height = 350.dp, width = 700.dp)
        ) {
            Row(
                modifier = Modifier.padding(10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "$32",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(20.dp),
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.width(150.dp))
                Box(modifier = Modifier
                    .size(height = 50.dp, width = 150.dp)
                    .background(color = Mustard_yellow, shape = CircleShape)
                    .align(Alignment.CenterVertically)) {
                    Row {
                        IconButton(onClick = { /* TODO: Add action for microphone */ }) {
                            Icon(
                                Icons.Default.KeyboardArrowDown,
                                contentDescription = null,
                                modifier = Modifier.size(50.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        var count = 0
                        Text(
                            text = "0", modifier = Modifier
                                .padding(vertical = 15.dp)
                                .padding(horizontal = 15.dp),
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.width(1.dp))
                        IconButton(onClick = { /* TODO: Add action for microphone */ }) {
                            Icon(
                                Icons.Default.KeyboardArrowUp,
                                contentDescription = null,
                                modifier = Modifier.size(50.dp)
                            )
                        }
                    }
                }

            }
            TextButton(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Mustard_yellow),
                border = BorderStroke(width = 0.dp, color = Color.Transparent),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 20.dp)
                    //.size(height = 40.dp, width = 400.dp),
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(15.dp)
            ){
                Text(text = "ADD TO CART", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}
@Composable
fun Pizza_3(navController: NavController){
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    Column {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .size(width = 500.dp, height = 655.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                TextButton(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(Color.Gray),
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Gray, CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.leftarrow),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )
                }
                Spacer(modifier = Modifier.width(1.dp))
                Text(
                    text = "Details",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                shape = RoundedCornerShape(16.dp),
                backgroundColor = Mustard_yellow,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
//                colors = CardColors(
//                    containerColor = Mustard_yellow_light, contentColor = Color.Black,
//                    disabledContentColor = Mustard_yellow,
//                    disabledContainerColor = Mustard_yellow
//                )
            ) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pizza),
                        contentDescription = "Pizza",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(200.dp)
                    )
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Add",
                        tint = Color.White,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(40.dp)
                            .background(Color.Red, shape = CircleShape)
                            .padding(8.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Pizza Calzone European",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(10.dp)
            )
            Spacer(modifier = Modifier.height(13.dp))
            Text(
                text = "Prosciutto e funghi is a pizza variety that is topped with tomato sauce.",
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 1.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.star),
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
                    painter = painterResource(id = R.drawable.truck),
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
                    painter = painterResource(id = R.drawable.clock),
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
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 1.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "SIZE:", modifier = Modifier.padding(horizontal = 10.dp))
                TextButton(onClick = { navController.navigate("Pizza") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                    modifier = Modifier
                        .size(60.dp),
                    shape = CircleShape
                ){
                    Text(text = "10''", fontSize = 25.sp)
                }
                Spacer(modifier = Modifier.width(30.dp))
                TextButton(onClick = { navController.navigate("Pizza_2")},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                    modifier = Modifier
                        .size(60.dp),
                    shape = CircleShape
                ){
                    Text(text = "14''", fontSize = 25.sp)
                }
                Spacer(modifier = Modifier.width(30.dp))
                TextButton(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Mustard_yellow),
                    modifier = Modifier
                        .size(60.dp),
                    shape = CircleShape
                ){
                    Text(text = "16''", fontSize = 25.sp)
                }
                Spacer(modifier = Modifier.width(20.dp))
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "INGRIDENTS", modifier = Modifier.padding(horizontal = 10.dp))
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 0.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.salt),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.kfc),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.garlic),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.onion),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.chilli),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
            }
        }
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .size(height = 350.dp, width = 700.dp)
        ) {
            Row(
                modifier = Modifier.padding(10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "$38",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(20.dp),
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.width(150.dp))
                Box(modifier = Modifier
                    .size(height = 50.dp, width = 150.dp)
                    .background(color = Mustard_yellow, shape = CircleShape)
                    .align(Alignment.CenterVertically)) {
                    Row {
                        IconButton(onClick = { /* TODO: Add action for microphone */ }) {
                            Icon(
                                Icons.Default.KeyboardArrowDown,
                                contentDescription = null,
                                modifier = Modifier.size(50.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        var count = 0
                        Text(
                            text = "0", modifier = Modifier
                                .padding(vertical = 15.dp)
                                .padding(horizontal = 15.dp),
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.width(1.dp))
                        IconButton(onClick = { /* TODO: Add action for microphone */ }) {
                            Icon(
                                Icons.Default.KeyboardArrowUp,
                                contentDescription = null,
                                modifier = Modifier.size(50.dp)
                            )
                        }
                    }
                }

            }
            TextButton(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Mustard_yellow),
                border = BorderStroke(width = 0.dp, color = Color.Transparent),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 20.dp)
                    //.size(height = 40.dp, width = 400.dp),
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(15.dp)
            ){
                Text(text = "ADD TO CART", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}






