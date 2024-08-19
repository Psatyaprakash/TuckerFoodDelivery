package com.example.tuckerfooddelivery.View

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.ui.theme.TuckerFoodDeliveryTheme


@Composable
fun ThankYouScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // Header Section
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFD700))
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = "Back Arrow",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Thank you so much!!",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Image Section
        Image(
            painter = painterResource(id = R.drawable.donor1),
            contentDescription = "Donor Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(bottom = 10.dp),
            contentScale = ContentScale.Crop
        )

        // Thank You Message
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFD700), RoundedCornerShape(12.dp))
                .padding(16.dp)
        ) {
            Text(
                text = "Dear Valued Donor,\n\n" +
                        "We are incredibly grateful for your generous donation in support of our food delivery app. Your contribution is making a meaningful difference in the lives of those battling hunger and bringing smiles to many faces. Thanks to your contribution, our pledge program continues to grow and make a tangible impact on the communities we serve. Whether you are donating to our meals initiative, supporting our campaigns, or simply spreading the word, your generosity is greatly appreciated.Your support helps us all go one step closer to fighting hunger, and your kind efforts are helping to lead the charge in this battle. We wish to keep you updated on the impact of your contributions through personalized reports and stories. By staying connected, you are not only making a difference today, but also creating a better world for tomorrow.",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                textAlign = TextAlign.Left
            )
        }
    }
}

