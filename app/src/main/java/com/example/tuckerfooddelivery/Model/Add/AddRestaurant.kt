package com.example.tuckerfooddelivery.Model.Add

import android.content.ContentValues.TAG
import android.util.Log
import com.example.tuckerfooddelivery.Model.Data.Contact
import com.example.tuckerfooddelivery.Model.Data.MenuCategory
import com.example.tuckerfooddelivery.Model.Data.Restaurant
import com.example.tuckerfooddelivery.Model.Fetch.db

fun addRestaurant(name: String, id: String, contact: Contact, menuCategory: MenuCategory) {
    val restaurant = Restaurant(
        id = id,
        name = name,
        contact = contact,
        menu = listOf(menuCategory) // Assuming one category; you can adapt this if needed
    )
    db.collection("Restro")
        .document(id + "_" + name)
        .set(restaurant)
        .addOnSuccessListener {
            Log.d(TAG, "DOCUMENT SNAPSHOT ADDED AT LOC : $id _ $name")
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error Adding Document", e)
        }
}



/*
fun addRestaurant(name: String, id: String, contact: Contact, menu: Menu) {
    val restaurant = Restaurant(
        name,
        id,
        contact,
        menu
    )
    db.collection("Restro")
        .document(id + "_" + name)
        .set(restaurant)
        .addOnSuccessListener {
            Log.d(TAG, "DOCUMENT SNAPSHOT ADDED AT LOC : $id _ $name")
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error Adding Document", e)
        }
}*/
