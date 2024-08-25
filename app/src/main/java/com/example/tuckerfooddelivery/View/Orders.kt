package com.example.tuckerfooddelivery.View

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tuckerfooddelivery.View.Profile.CircularButtonWithSymbol

@Composable
fun PreparedOrderScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(5.dp)
    ) {
        Row(Modifier
            .fillMaxWidth()
            .padding(20.dp,15.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            CircularButtonWithSymbol {
                navController.popBackStack()
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "All orders",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(1) { // Number of orders, in real scenario this will be dynamic
                OrderCard1()
                OrderCard2()
                OrderCard3()
                OrderCard4()
            }
        }
    }
}

@Composable
fun OrderCard1() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, Color(0xFFFFD700), RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "Order of Classic french fries \nplaced  by xyz myu",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "12-J, Sector 5, Kanpur Nagar, Uttar Pradesh, India",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "ITEMS",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "4 X Classic French Fries",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "ORDERED ON",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "2024-08-20 05:35:42",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "TOTAL",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "Rs. 534",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "PAYMENT MODE: ONLINE(UPI)",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = { /* Handle pick-up action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFD700)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Status : Completed", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Composable
fun OrderCard2() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, Color(0xFFFFD700), RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "Order of Smokin Burger \nplaced  by xyz myu",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "F-161, Katwaria Sarai, New Delhi, India",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "ITEMS",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "6 X Smokin Burger",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "ORDERED ON",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "2024-08-21 02:15:34",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "TOTAL",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "Rs. 730",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "PAYMENT MODE: CASH",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = { /* Handle pick-up action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFD700)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Processing", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Composable
fun OrderCard3() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, Color(0xFFFFD700), RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "Order of Classic Hotdog \nplaced  by xyz myu",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "H.No - 382, Sector 3,Type 4, R K Puram, New Delhi, India",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "ITEMS",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "2 X Classic Hotdog",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "ORDERED ON",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "2024-08-23 07:45:44",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "TOTAL",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "Rs.236",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "PAYMENT MODE: ONLINE(UPI)",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = { /* Handle pick-up action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFD700)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Cancel", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Composable
fun OrderCard4() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, Color(0xFFFFD700), RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "Order of Chicken Wings \nplaced  by xyz myu",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Qtr No- 14, Patia, Bhubaneswar, India",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "ITEMS",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "3 X Chicken Wings",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "ORDERED ON",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "2024-08-25 01:56:43",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "TOTAL",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "Rs. 454",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "PAYMENT MODE: ONLINE(UPI)",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = { /* Handle pick-up action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFD700)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Return", color = Color.White, fontSize = 16.sp)
        }
    }
}
