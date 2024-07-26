package com.example.tuckerfooddelivery.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter

@Composable
fun CircularButtonWithSymbol(onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Color.Gray),
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier
            .size(50.dp)
            .background(Color.Transparent, CircleShape)
    ) {
        Text(
            text = "<",
            fontSize = 24.sp,
            color = Color.White,
        )
    }
}

@Composable
fun PersonalInfoDetails(navController: NavController) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var bio by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(17.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            CircularButtonWithSymbol(onClick = { /* handle click */ })
        }

        Text(
            text = "Personal Info",
            color = Color.Black,
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 11.dp) // Adjust spacing if needed
        )

        // Profile Image and Edit Button
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize()
                .padding(top = 60.dp)
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberImagePainter(data = "https://www.bing.com/images/search?view=detailV2&ccid=7hFAXSqY&id=CC0399CC4062E603BD734E0EF136B2C10A280510&thid=OIP.7hFAXSqYekM7JbRZma2zUwHaEm&mediaurl=https%3a%2f%2fwww.pngitem.com%2fpimgs%2fm%2f159-1595932_python-logo-png-transparent-images-logo-transparent-background.png&exph=535&expw=860&q=google+python+logo&simid=608042017004537305&FORM=IRPRST&ck=E62F0753280B23CB03B0752D4B290D5B&selectedIndex=5&itb=0"),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )
            Spacer(modifier = Modifier.height(5.dp))
            TextButton(
                onClick = { /* handle image edit click */ },
            ) {
                Text("Edit Image", color = Color.Blue)
            }
            Spacer(modifier = Modifier.height(5.dp))
        }

        // Form Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 200.dp) // Adjust the top padding to ensure space for the profile image
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = "FULL NAME", color = Color.Black, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(10.dp))
            // Name
            TextField(
                value = fullName,
                onValueChange = { fullName = it },
                label = { Text("Enter your name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            // Email
            Text(text = "E-MAIL", color = Color.Black, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Enter your Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            // Phone Number
            Text(text = "PHONE NUMBER", color = Color.Black, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Enter your Phone Number") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            // Bio
            Text(text = "BIO", color = Color.Black, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = bio,
                onValueChange = { bio = it },
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
