package com.example.tuckerfooddelivery.Model.Fetch

import android.content.ContentValues.TAG
import android.util.Log
import com.example.tuckerfooddelivery.Model.Data.Wishlist

fun fetchWishlist(onResult: (List<Wishlist>) -> Unit) {
    db.collection("Wishlist")
        .get()
        .addOnSuccessListener { result ->
            val wishlists = result.map { document -> document.toObject(Wishlist::class.java) }
            onResult(wishlists)
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error getting document", e)
        }
}