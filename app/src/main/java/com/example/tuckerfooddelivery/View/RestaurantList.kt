package com.example.tuckerfooddelivery.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.tuckerfooddelivery.Model.Data.Restaurant
import com.example.tuckerfooddelivery.Model.Fetch.fetchRestaurant
import com.example.tuckerfooddelivery.ViewModel.storageRef

@Composable
fun RestaurantList() {
    val restaurantList = remember { mutableStateOf<List<Restaurant>>(emptyList()) }
    val isLoading = remember { mutableStateOf(true) }
    val errorMessage = remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current



    LaunchedEffect(Unit) {
        try {
            fetchRestaurant { restaurant ->
                restaurantList.value = restaurant
                isLoading.value = false
            }
        } catch (e: Exception) {
            errorMessage.value = "Failed to load restaurants"
            isLoading.value = false
        }
    }

    if (isLoading.value) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    } else if (errorMessage.value != null) {
        Text(text = errorMessage.value!!)
    } else {
        LazyColumn {
            items(restaurantList.value) { restaurant ->
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = "Name: ${restaurant.name}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "ID: ${restaurant.id ?: "N/A"}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = "Phone: ${restaurant.contact.phone}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = "Email: ${restaurant.contact.email}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Menu:",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    restaurant.menu.forEach { category ->
                        Text(
                            text = category.name,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        category.items.forEach { item ->
                            Text(
                                text = " - ${item.name}: $${item.price}",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))

                        // Async image loading
                        val imageUrl = remember { mutableStateOf<String?>(null) }

                        LaunchedEffect(category.name) {
                            try {
                                val imageRef = storageRef.child("Restro/Menu/Category/Item/Mocktail.jpg")
                                imageRef.downloadUrl.addOnSuccessListener { uri ->
                                    imageUrl.value = uri.toString()
                                }.addOnFailureListener {
                                    imageUrl.value = null
                                }
                            } catch (e: Exception) {
                                e.printStackTrace()
                                imageUrl.value = null
                            }
                        }

                        imageUrl.value?.let { url ->
                            Image(
                                painter = rememberImagePainter(
                                    coil.request.ImageRequest.Builder(context)
                                        .data(url)
                                        .crossfade(true)
                                        .build()
                                ),
                                contentDescription = "Mocktail Image",
                                modifier = Modifier.size(128.dp) // Set desired size
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

