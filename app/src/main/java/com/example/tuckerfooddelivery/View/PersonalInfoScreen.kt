package com.example.tuckerfooddelivery.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircularButtonWithSymbol() {
    Box(
        modifier = Modifier
            .size(50.dp) // Size of the circle
            .background(Color.Transparent, CircleShape) // Circle background color
            .padding(10.dp) // Padding inside the circle
    ) {
        TextButton(
            onClick = { /* handle click */ },
            colors = ButtonDefaults.buttonColors(Color.Black), // Button color (optional)
            shape = CircleShape, // Circle shape
            modifier = Modifier
                .fillMaxSize() // Fills the size of the Box
                .padding(0.dp) // No extra padding for the button
        ) {
            Text(
                text = "<", // Symbol inside the button
                fontSize = 68.sp, // Font size of the symbol
                color = Color.Red, // Color of the symbol
            )
        }
    }
}

@Composable
fun PersonalInfoDetails() {
    var text by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(17.dp) // Padding for the whole Box
    ) {
        // Add the circular button
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp) // Padding to place the button inside the box
        ) {
            CircularButtonWithSymbol()
        }

        // Center Text
        Text(
            text = "Personal Info",
            color = Color.Black,
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.TopCenter) // Align text to the top center
                .padding(top = 70.dp)
                .fillMaxWidth()
        )

        // Form Content
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize()
                .padding(top = 120.dp) // Adjust to avoid overlapping with the centered text
        ) {
            Text(text = "FULL NAME", color = Color.Black, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(10.dp))
            // Name
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter your name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            // Email
            Text(text = "E-MAIL", color = Color.Black, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter your Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            // Phone Number
            Text(text = "PHONE NUMBER", color = Color.Black, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter your Phone Number") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            // Bio
            Text(text = "BIO", color = Color.Black, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter your bio") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
            )
            Spacer(modifier = Modifier.height(45.dp))
            Button(
                onClick = { /* handle click */ },
                colors = ButtonDefaults.buttonColors(Color(0xFFD4AF37)), // Mustard color
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
            ) {
                Text("SAVE", fontSize = 18.sp, color = Color.White)
            }
        }
    }
}
