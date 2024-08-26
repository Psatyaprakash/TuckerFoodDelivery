package com.example.tuckerfooddelivery.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.View.Profile.CircularButtonWithSymbol


@Composable
fun PledgeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            CircularButtonWithSymbol {
                navController.popBackStack()
            }
            Text(
                text = "  Take a Pledge !!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        // Top Image
        Image(
            painter = painterResource(id = R.drawable.pledge_1),
            contentDescription = "Pledge Image",
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp),
            contentScale = ContentScale.FillWidth
        )

        // Text Sections
        Text(
            text = "Our innovative food delivery app goes beyond just delivering meals. With our pledge feature, you can make a positive impact by donating meals to those in need. Join hands with us and help fight hunger in our communities.",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        Text(
            text = "What is the Pledge Feature?",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        Text(
            text = "The pledge feature is a community-driven initiative designed to tackle food insecurity. It allows you to contribute meals to local hunger-relief organizations with every order you place.",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Bullet Points
        Text(
            text = "\u2022 Fight hunger with your meals\n\u2022 Donating is easy and fast\n\u2022 Partner with local NGOs and charities\n\u2022 Track your contributions\n\u2022 Receive updates and acknowledgments",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Image Section
        Image(
            painter = painterResource(id = R.drawable.pledge_2),
            contentDescription = "Donation Image",
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.dp),
            contentScale = ContentScale.FillWidth
        )

        Text(
            text = "Why Your Donation Matters",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        Text(
            text = "Millions of tons of food are wasted every year. By donating meals, you're not just helping to reduce waste, but also making sure that the less fortunate have access to nourishing food. Your donations create a positive ripple effect, touching lives and making a real difference.",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        // Bottom Image
        Image(
            painter = painterResource(id = R.drawable.pledge_3),
            contentDescription = "Donation Image",
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp),
            contentScale = ContentScale.FillWidth
        )
        var Amount by remember {
            mutableStateOf("")
        }
        Text(
            text = "Enter Amount",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        OutlinedTextField(value = "100", onValueChange = {Amount = it}, modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 0.dp))
        Spacer(modifier = Modifier.height(10.dp))
        var Feedback by remember {
            mutableStateOf("")
        }
        Text(
            text = "Donation for",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        OutlinedTextField(value = "Child ..", onValueChange = {Feedback = it}, modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 0.dp))

        // Donate Button
        Button(
            onClick = { /* Handle donation */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(60.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.Mustard_yellow))
        ) {
            Text(
                text = "DONATE FOR CAUSE",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}
