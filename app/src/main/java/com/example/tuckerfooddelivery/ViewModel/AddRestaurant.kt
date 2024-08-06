package com.example.tuckerfooddelivery.ViewModel

import android.content.ContentValues.TAG
import android.util.Log
import com.example.tuckerfooddelivery.Model.Data.Contact
import com.example.tuckerfooddelivery.Model.Data.Menu
import com.example.tuckerfooddelivery.Model.Data.Restaurant

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
}