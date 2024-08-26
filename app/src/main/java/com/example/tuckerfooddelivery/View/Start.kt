package com.example.tuckerfooddelivery.View

import android.widget.Toast
import androidx.compose.animation.expandIn
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.ViewModel.ScreenHeight
import com.example.tuckerfooddelivery.ViewModel.loggedInAs
import com.google.firebase.Firebase
import com.google.firebase.storage.storage
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

@Composable
fun Start(navController: NavHostController) {
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ){
        Column(modifier = Modifier
            .padding(40.dp)
            .fillMaxSize()
            .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(painter = painterResource(R.drawable.all_your_fav),
                contentDescription = "" ,
                Modifier
                    .size(300.dp)
                    .fillMaxWidth()
            )
            Text(text = "All your favorites" , fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier .height(20.dp) )
            Text(text = "Get all your loved foods in one once place you just place the order we do the rest" ,
                fontSize = 18.sp,
                textAlign = TextAlign.Center ,
                color = Color.Gray ,
                fontWeight = FontWeight.W700
            )
            Spacer(modifier = Modifier .height(40.dp) )
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
                Text(text = "Next" , fontSize = 22.sp , color = Color.White)
            }
             TextButton(onClick = { navController.navigate("Start3") }) {
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
            .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(R.drawable.order),
                contentDescription = "" ,
                Modifier
                    .size(300.dp)
            )
            Text(text = "Order from chosen chef" , fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier .height(20.dp) )
            Text(text = "Get all your loved foods in one once place, you just place the order we do the rest" ,
                fontSize = 18.sp,
                textAlign = TextAlign.Center ,
                color = Color.Gray ,
                fontWeight = FontWeight.W700
            )
            Spacer(modifier = Modifier .height(20.dp) )
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
            Button(onClick = { navController.navigate("Start3") },
                Modifier
                    .fillMaxWidth()
                    .padding(30.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Mustard_yellow)
            ) {
                Text(text = "Next" , fontSize = 22.sp , color = Color.White)
            }
            TextButton(onClick = { navController.navigate("Start3") }) {
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
            .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(R.drawable.delivery),
                contentDescription = "" ,
                Modifier
                    .size(400.dp)
                    , contentScale = ContentScale.FillWidth
            )
            Text(text = "Free delivery offers" , fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier .height(20.dp) )
            Text(text = "Get all your loved foods in one once place, you just place the order we do the rest" ,
                fontSize = 18.sp,
                textAlign = TextAlign.Center ,
                color = Color.Gray ,
                fontWeight = FontWeight.W700
            )
            Spacer(modifier = Modifier .height(10.dp) )
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
            Button(
                onClick = {
                    loggedInAs = "Customer";
                    navController.navigate("LoginScreen")
                },
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(40.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Mustard_yellow)
            ) {
                Text(text = "Get Started" , fontSize = 20.sp , color = Color.White)
            }
            Button(onClick = { loggedInAs = "Restaurant" ; navController.navigate("LoginScreen") },
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(40.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Mustard_yellow)
            ) {
                Text(text = "Continue As Restaurant" , fontSize = 18.sp , color = Color.White)
            }
        }
    }
}