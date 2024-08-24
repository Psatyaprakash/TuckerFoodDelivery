package com.example.tuckerfooddelivery.View

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Composition
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

@Composable
fun Delivery(navController: NavController){
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .size(height = 175.dp, width = 0.dp)
                .background(Mustard_yellow),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            
            Text(text = "Rosengarden Restaurant", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = "Order is on the way !!", color= Color.White, fontSize = 23.sp, fontWeight = FontWeight.Bold)
            Box(modifier = Modifier
                .size(150.dp, 30.dp)
                .background(Color.Gray)
                .align(Alignment.CenterHorizontally)
            ){
                Text(text = "Arriving in 10 mins", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.align(
                    Alignment.Center))
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .size(height = 500.dp, width = 0.dp)
                .verticalScroll(rememberScrollState())
                .horizontalScroll(rememberScrollState())
        ) {
            Image(painter = painterResource(id = R.drawable.map), contentDescription = "",
                modifier = Modifier.size(height = 600.dp, width = 476.82.dp)
                    .align(Alignment.CenterHorizontally))
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .size(height = 200.dp, width = 0.dp)
                .background(Mustard_yellow)
                .padding(20.dp)
        ) {
            Text(text = "Mr. Tipendra is your delivery partner", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = R.drawable.profileimg), contentDescription = "", modifier = Modifier.size(50.dp))
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(text = "Tipendra Gada", color = Color.White, fontWeight = FontWeight.ExtraBold, fontSize = 21.sp)
                    Text(text = "200+ five star deliveries", color = Color.White, fontWeight = FontWeight.ExtraBold, fontSize = 16.sp)
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    border = BorderStroke(width = 0.dp, color = Color.Transparent),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Call",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(7.dp))
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.call),
                            contentDescription = "",
                            Modifier
                                .size(27.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    border = BorderStroke(width = 0.dp, color = Color.Transparent),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Chat",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(7.dp))
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.chat),
                            contentDescription = "",
                            Modifier
                                .size(27.dp)
                                .align(Alignment.Center)
                        )
                    }


                }
            }
        }
    }
}