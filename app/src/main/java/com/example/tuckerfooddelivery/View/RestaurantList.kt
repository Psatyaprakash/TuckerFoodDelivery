package com.example.tuckerfooddelivery.View

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tuckerfooddelivery.Model.Data.Restaurant
import com.example.tuckerfooddelivery.ViewModel.fetchRestaurant

@Composable
fun RestaurantList() {
    val restaurantList = remember { mutableStateOf<List<Restaurant>>(emptyList()) }

    LaunchedEffect(Unit) {
        fetchRestaurant { restaurant ->
            restaurantList.value = restaurant
        }
    }

    LazyColumn {
        items(restaurantList.value, key = { it.id }) { restaurant ->
            Text(
                text = "Name: ${restaurant.name}, ID: ${restaurant.id}, \n" +
                        " Phone: ${restaurant.contact.phone}, Email: ${restaurant.contact.email}" +
                        " ",
                fontSize = 20.sp,
                fontWeight = FontWeight.W500,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}