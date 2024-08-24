package com.example.tuckerfooddelivery.Model.Fetch

import android.content.ContentValues.TAG
import android.util.Log
import com.example.tuckerfooddelivery.Model.Data.Restaurant
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

val db = Firebase.firestore

fun fetchRestaurant(onResult: (List<Restaurant>) -> Unit) {
    db.collection("Restro")
        .get()
        .addOnSuccessListener { result ->
            val restaurantList = result.map { document -> document.toObject(Restaurant::class.java) }
            onResult(restaurantList)
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error getting document", e)
        }
}

/*
suspend fun fetchRestaurant(callback: (List<Restaurant>) -> Unit) {
    // Simulate network call or data retrieval
    val fetchedRestaurants = listOf<Restaurant>() // replace with actual data fetching
    callback(fetchedRestaurants)
}

*/