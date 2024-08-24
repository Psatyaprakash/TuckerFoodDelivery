package com.example.tuckerfooddelivery.Model.Add

import android.content.ContentValues.TAG
import android.util.Log
import com.example.tuckerfooddelivery.Model.Data.Wishlist
import com.example.tuckerfooddelivery.Model.Fetch.db

fun addWishlist(name: String, price : Int, count : Int, size : String ) {
    val wishlist = Wishlist(
        name,
        price = price,
        count = count,
        size = size
    )


    db.collection("Wishlist")
        .document(name+"_$size" )
        .set(wishlist)
        .addOnSuccessListener {
            Log.d(TAG, "DOCUMENT SNAPSHOT ADDED AT LOC : $name _ $size")
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error Adding Document", e)
        }
}
