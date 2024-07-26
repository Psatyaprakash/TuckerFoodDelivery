package com.example.tuckerfooddelivery.View

import androidx.compose.animation.expandIn
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tuckerfooddelivery.R

@Composable
fun Start(navController: NavHostController) {
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
//        slideOutHorizontally {  }
    ){
        Column(modifier = Modifier
            .padding(40.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(R.drawable.all_your_fav),
                contentDescription = "" ,
                Modifier
                    .size(500.dp)
                )
            Text(text = "All your favorites" , fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier .height(20.dp) )
            Text(text = "Get all your loved foods in one once place,\n" +
                    "you just place the order we do the rest" ,
                fontSize = 18.sp,
                textAlign = TextAlign.Center ,
                color = Color.Gray ,
                fontWeight = FontWeight.W700
            )
            Spacer(modifier = Modifier .height(100.dp) )
            Row{
                for (i in 1..3) {
                    var col_mus = Mustard_yellow_light

                    if (i == 1)
                        col_mus = Mustard_yellow

                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(col_mus)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                }
            }
            Spacer(modifier = Modifier .height(10.dp) )
            Button(onClick = { navController.navigate("Start2") },
                Modifier
                    .fillMaxWidth()
                    .padding(30.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Mustard_yellow)
            ) {
                Text(text = "Next" , fontSize = 22.sp)
            }
            TextButton(onClick = { navController.navigate("Login") }) {
                Text(text = "Skip", fontSize = 25.sp, fontFamily = FontFamily.SansSerif , color = Color.Black)
            }
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}


@Composable
fun Start2(navController: NavHostController) {
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ){
        Column(modifier = Modifier
            .padding(40.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(R.drawable.order),
                contentDescription = "" ,
                Modifier
                    .size(500.dp)
                )
            Text(text = "Order from chosen chef" , fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier .height(20.dp) )
            Text(text = "Get all your loved foods in one once place,\n" +
                    "you just place the order we do the rest" ,
                fontSize = 18.sp,
                textAlign = TextAlign.Center ,
                color = Color.Gray ,
                fontWeight = FontWeight.W700
            )
            Spacer(modifier = Modifier .height(100.dp) )
            Row{
                for (i in 1..3) {
                    var col_mus = Mustard_yellow_light

                    if (i == 2)
                        col_mus = Mustard_yellow

                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(col_mus)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                }
            }
            Spacer(modifier = Modifier .height(10.dp) )
            Button(onClick = { navController.navigate("Start3") },
                Modifier
                    .fillMaxWidth()
                    .padding(30.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Mustard_yellow)
            ) {
                Text(text = "Next" , fontSize = 22.sp)
            }
            TextButton(onClick = { navController.navigate("Login") }) {
                Text(text = "Skip", fontSize = 25.sp, fontFamily = FontFamily.SansSerif , color = Color.Black)
            }
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}


@Composable
fun Start3(navController: NavHostController) {
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ){
        Column(modifier = Modifier
            .padding(40.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(R.drawable.delivery),
                contentDescription = "" ,
                Modifier
                    .size(500.dp)
                )
            Text(text = "Free delivery offers" , fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier .height(20.dp) )
            Text(text = "Get all your loved foods in one once place,\n" +
                    "you just place the order we do the rest" ,
                fontSize = 18.sp,
                textAlign = TextAlign.Center ,
                color = Color.Gray ,
                fontWeight = FontWeight.W700
            )
            Spacer(modifier = Modifier .height(100.dp) )
            Row{
                for (i in 1..3) {
                    var col_mus = Mustard_yellow_light

                    if (i == 3)
                        col_mus = Mustard_yellow

                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(col_mus)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                }
            }
            Spacer(modifier = Modifier .height(10.dp) )
            Button(onClick = { navController.navigate("ItemDetails") },
                Modifier
                    .fillMaxWidth()
                    .padding(30.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Mustard_yellow)
            ) {
                Text(text = "Get Started" , fontSize = 22.sp)
            }

            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}

