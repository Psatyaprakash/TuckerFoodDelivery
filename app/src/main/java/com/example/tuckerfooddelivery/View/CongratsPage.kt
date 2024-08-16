package com.example.tuckerfooddelivery.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.tuckerfooddelivery.R

@Composable
fun Congrats(navController: NavController){
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ){
        Column(modifier = Modifier
            .padding(0.dp, 40.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier
                .fillMaxWidth(),
                Alignment.Center
            ){

                Image(painter = painterResource(id = R.drawable.middle_icon),
                    contentDescription = "" ,
                    Modifier
                        .size(200.dp)
                )
                Image(painter = painterResource(id = R.drawable.congrats_icon),
                    contentDescription = "" ,
                    Modifier
                        .size(500.dp)
                )
            }

            Text(text = "Congratulations!", fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "You successfully made a payment\n" +
                "Enjoy our service!" ,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = {navController.navigate("Delivery")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Mustard_yellow)
                ) {
                Text(text = "TRACK ORDER", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(1.dp))
        }
    }
}