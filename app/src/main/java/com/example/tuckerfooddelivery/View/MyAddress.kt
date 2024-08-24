package com.example.tuckerfooddelivery.View

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.ui.theme.TuckerFoodDeliveryTheme
/*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TuckerFoodDeliveryTheme {
                MyApp()
            }
        }
    }
}*/

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "address_screen") {
        composable("address_screen") {
            AddressScreen(navController)
        }
        composable("add_address_screen") {
            AddAddressScreen(navController)
        }
    }
}

@Composable
fun AddressScreen(navController: NavHostController) {
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    Column(modifier = Modifier.fillMaxSize()
        .verticalScroll(ScrollState(1))) {
        TopAppBar(
            title = { Text("My Address") },
            navigationIcon = {
                IconButton(onClick = { /* Handle back navigation */ }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            },
            backgroundColor = Color.White,
            contentColor = Color.Black,
            elevation = 0.dp
        )
        Spacer(modifier = Modifier.height(16.dp))
        AddressCard(
            label = "HOME",
            address = "2464 Royal Ln. Meso, New Jersey 45463",
            icon = Icons.Default.Home,
            onEditClick = { /* Handle edit */ },
            onDeleteClick = { /* Handle delete */ }
        )
        Spacer(modifier = Modifier.height(10.dp))
        AddressCard(
            label = "WORK",
            address = "3891 Ranchview Dr, Richardson, California 62639",
            icon = Icons.Default.AccountBox,
            onEditClick = { /* Handle edit */ },
            onDeleteClick = { /* Handle delete */ }
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { navController.navigate("add_address_screen") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Mustard_yellow)
        ) {
            Text(text = "ADD NEW ADDRESS", color = Color.White, fontSize = 22.sp)
        }
       // Spacer(modifier = Modifier.height(500.dp))
    }
}

@Composable
fun AddressCard(
    label: String,
    address: String,
    icon: ImageVector,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .background(Color(0xFFF5F5F5))
                .padding(16.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier
                    .size(45.dp)
                    .padding(end = 16.dp)
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = label, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = address, fontSize = 14.sp)
            }
            IconButton(onClick = onEditClick) {
                Icon(imageVector = Icons.Filled.Edit, contentDescription = "Edit")
            }
            IconButton(onClick = onDeleteClick) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete")
            }
        }
    }
}

@Composable
fun AddAddressScreen(navController: NavController) {
    // Implement your Add Address screen UI here
    // For simplicity, we just show a text and a button to go back
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Add Address Screen")
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Back")
        }
    }
}

@Composable
fun BackIcon(onBackClick: () -> Unit) {
    Icon(
        imageVector = Icons.Default.ArrowBack,
        contentDescription = "Back",
        modifier = Modifier
            .size(24.dp)
            .clickable { onBackClick() }
    )
}

