package com.example.tuckerfooddelivery.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tuckerfooddelivery.R

@Composable
fun UserReviews(navController: NavHostController) {
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    Column(
        modifier = Modifier
            .padding(15.dp)
            //.size(width = 500.dp, height = 655.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        TextButton(
            onClick = { navController.navigate("ProfileView") },
            colors = ButtonDefaults.buttonColors(Color.LightGray),
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .size(55.dp)
                .background(Color.Gray, CircleShape)
        ) {
            Image(
                painter = painterResource(id = R.drawable.leftarrow_icon),
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Recently Ordered from",
            fontSize = 24.sp,
            color = Mustard_yellow,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = "Rose Garden Restaurant",
            fontSize = 30.sp,
            color = Mustard_yellow,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            TextButton(
                onClick = {},
                colors = ButtonDefaults.buttonColors(Mustard_yellow_light),
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .size(50.dp)
                //.background(Mustard_yellow_light, CircleShape)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.user_icon),
                    contentDescription = "",
                    modifier = Modifier
                        .size(25.dp),
                    alignment = Alignment.Center
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Ajay has delivered your order",
                //fontWeight = FontWeight.Bold,
                fontSize = 19.sp,
                modifier = Modifier.padding(5.dp)
            )
        }
        Row(
            modifier = Modifier.padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.grp),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp),
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.width(2.dp))
            // Feedback and rating for delivery services
            Column(
                modifier = Modifier.padding(5.dp)
            ) {
                Text(
                    text = "Please rate Ajay Kumar's service",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
                Text(
                    text = "Your feedback will help him improve",
                    fontSize = 14.8.sp,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(30.dp))
            Image(
                painter = painterResource(id = R.drawable.rate1),
                contentDescription = "",
                modifier = Modifier.size(35.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.rate2),
                contentDescription = "",
                modifier = Modifier.size(35.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.rate3),
                contentDescription = "",
                modifier = Modifier.size(35.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.rate4),
                contentDescription = "",
                modifier = Modifier.size(35.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.rate5),
                contentDescription = "",
                modifier = Modifier.size(35.dp)
            )

        }
        Spacer(modifier = Modifier.height(10.dp))
        var Feedback by remember {
            mutableStateOf("")
        }
        Spacer(modifier = Modifier.width(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),

        ) {
            Spacer(modifier = Modifier.width(55.dp))
            OutlinedTextField(value = "Feedback", onValueChange = {Feedback = it}, modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp))
        }


        Row(
            modifier = Modifier.padding(15.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_icon),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .size(58.dp)
                    .padding(0.dp,8.dp,0.dp,0.dp),
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.width(2.dp))
            // rating and feedback for food
            Column(
                modifier = Modifier.padding(5.dp)
            ) {
                Text(
                    text = "Please rate the food",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
                Text(
                    text = "Your feedback will impact the restaurant's overall rating and will help others make better choices.",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(30.dp))
            Image(
                painter = painterResource(id = R.drawable.rate1),
                contentDescription = "",
                modifier = Modifier.size(35.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.rate2),
                contentDescription = "",
                modifier = Modifier.size(35.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.rate3),
                contentDescription = "",
                modifier = Modifier.size(35.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.rate4),
                contentDescription = "",
                modifier = Modifier.size(35.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.rate5),
                contentDescription = "",
                modifier = Modifier.size(35.dp)
            )

        }
        Spacer(modifier = Modifier.height(10.dp))
        var FeedbackFood by remember {
            mutableStateOf("")
        }
        Spacer(modifier = Modifier.width(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),

            ) {
            Spacer(modifier = Modifier.width(55.dp))
            OutlinedTextField(value = "Feedback", onValueChange = {FeedbackFood = it}, modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp))
        }
    }
}
