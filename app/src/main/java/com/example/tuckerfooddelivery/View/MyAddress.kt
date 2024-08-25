package com.example.tuckerfooddelivery.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.View.Profile.CircularButtonWithSymbol
import com.example.tuckerfooddelivery.ViewModel.userPrimaryAddress


@Composable
fun AddressScreen(navController: NavHostController) {
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)

    Column(modifier = Modifier
        .fillMaxSize()
    ) {
        Row(
            Modifier
                .padding(15.dp, 20.dp, 10.dp, 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            CircularButtonWithSymbol {navController.popBackStack()}
            Spacer(modifier = Modifier.width(1.dp))
            Text(
                text = "My Address",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
        }
        AddressCard(
            label = "HOME",
            address = "2464 Royal Ln. Meso, New Jersey 45463",
            icon = Icons.Default.Home,
            onEditClick = { /* Handle edit */ },
            onDeleteClick = { /* Handle delete */ }
        )
        Spacer(modifier = Modifier.height(12.dp))
        AddressCard(
            label = "WORK",
            address = "3891 Ranchview Dr, Richardson, California 62639",
            icon = Icons.Default.AccountBox,
            onEditClick = { /* Handle edit */ },
            onDeleteClick = { /* Handle delete */ }
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { navController.navigate("SaveLocationScreen") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Mustard_yellow)
        ) {
            Text(text = "ADD NEW ADDRESS", color = Color.White, fontSize = 20.sp)
        }
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
    if (label == "HOME"){ userPrimaryAddress = address }

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

