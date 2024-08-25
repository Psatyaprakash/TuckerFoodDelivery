package com.example.tuckerfooddelivery.View

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.tuckerfooddelivery.Model.Data.Contact
import com.example.tuckerfooddelivery.Model.Data.MenuCategory
import com.example.tuckerfooddelivery.Model.Data.MenuItem
import com.example.tuckerfooddelivery.Model.Data.Restaurant
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

//DisplaySecondMenuCategory("kvqdTlZiSbAlmYadzgS2")


@Composable
fun _addRestaurantScreen() {
    var name by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var zipcode by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    var categories by remember { mutableStateOf(listOf<MenuCategory>()) }
    var newCategoryName by remember { mutableStateOf("") }
    var newItemName by remember { mutableStateOf("") }
    var newItemPrice by remember { mutableStateOf("") }
    var newItemImages by remember { mutableStateOf("") }

    val db = FirebaseFirestore.getInstance()
    val context = LocalContext.current

    fun addCategory() {
        val newCategory = MenuCategory(
            name = newCategoryName,
            items = listOf() // Items will be added later
        )
        categories = categories + newCategory
        newCategoryName = ""
    }

    fun addItemToCategory(categoryIndex: Int) {
        val price = newItemPrice.toDoubleOrNull() ?: 0.0
        val images = newItemImages.split(",").map { it.trim() }

        val updatedCategories = categories.toMutableList()
        val category = updatedCategories[categoryIndex]

        val updatedItems = category.items + MenuItem(
            name = newItemName,
            price = price,
            images = images
        )

        updatedCategories[categoryIndex] = category.copy(items = updatedItems)
        categories = updatedCategories

        newItemName = ""
        newItemPrice = ""
        newItemImages = ""
    }


    fun addRestaurant() {

        val restaurant = Restaurant(
            id = null, // Firestore will generate a unique ID
            name = name,
            location = com.example.tuckerfooddelivery.Model.Data.Location(
                address = address,
                city = city,
                state = state,
                zipcode = zipcode,
                country = country
            ),
            contact = Contact(
                phone = phone,
                email = email
            ),
            menu = categories,
            opening_hours = emptyMap(), // Add real data if available
            reviews = emptyList() // Add real reviews if available
        )

        val restaurantCollection = db.collection("restaurants")

        restaurantCollection.add(restaurant)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(context, "Restaurant added with ID: ${documentReference.id}", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(context, "Error adding restaurant: $e", Toast.LENGTH_LONG).show()
            }
    }

    Column(modifier = Modifier
        .padding(16.dp)
        .verticalScroll(rememberScrollState())
    ) {
        Text(text = "Add Restaurant", style = MaterialTheme.typography.h6)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Restaurant Name") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Address") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("City") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = state,
            onValueChange = { state = it },
            label = { Text("State") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = zipcode,
            onValueChange = { zipcode = it },
            label = { Text("Zipcode") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = country,
            onValueChange = { country = it },
            label = { Text("Country") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Menu Categories", style = MaterialTheme.typography.h6)

        TextField(
            value = newCategoryName,
            onValueChange = { newCategoryName = it },
            label = { Text("New Category Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = { addCategory() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Add Category")
        }

        Spacer(modifier = Modifier.height(16.dp))

        categories.forEachIndexed { index, category ->
            Text(text = "Category: ${category.name}", style = MaterialTheme.typography.h6)

            TextField(
                value = newItemName,
                onValueChange = { newItemName = it },
                label = { Text("New Item Name") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = newItemPrice,
                onValueChange = { newItemPrice = it },
                label = { Text("New Item Price") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = newItemImages,
                onValueChange = { newItemImages = it },
                label = { Text("Image URLs (comma separated)") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = { addItemToCategory(index) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Add Item")
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { addRestaurant() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Add Restaurant")
        }
    }
}
////////
suspend fun getSecondMenuCategory(restaurantId: String): MenuCategory? {
    val db = FirebaseFirestore.getInstance()
    return try {
        val documentSnapshot = db.collection("restaurants").document(restaurantId).get().await()
        val restaurant = documentSnapshot.toObject(Restaurant::class.java)
        restaurant?.menu?.getOrNull(1) // Get the second category (index 1)
    } catch (e: Exception) {
        // Handle errors
        e.printStackTrace()
        null
    }
}
////
@Composable
fun DisplaySecondMenuCategory(restaurantId: String) {
    var category by remember { mutableStateOf<MenuCategory?>(null) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(restaurantId) {
        coroutineScope.launch {
            category = getSecondMenuCategory(restaurantId)
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        if (category == null) {
            Column(
                Modifier
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){ CircularProgressIndicator() }
        } else {
            category?.let {
                Text(text = "Category: ${it.name}", style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(8.dp))
                it.items.forEach { item ->
                    Text(text = "Item: ${item.name}", style = MaterialTheme.typography.body1)
                    Text(text = "Price: $${item.price}", style = MaterialTheme.typography.body2)
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
        }
    }
}
/////
