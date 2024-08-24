package com.example.tuckerfooddelivery.Model.Fetch

import android.content.ContentValues.TAG
import android.util.Log
import com.example.tuckerfooddelivery.Model.Data.Cart

fun fetchCart(onResult: (List<Cart>) -> Unit) {
    db.collection("Cart")
        .get()
        .addOnSuccessListener { result ->
            val cartList = result.map { document -> document.toObject(Cart::class.java) }
            onResult(cartList)
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error getting document", e)
        }
}
/*fun fetchCart(onResult: (List<Cart>) -> Unit) {
    val db = FirebaseFirestore.getInstance()
    db.collection("Cart")
        .get()
        .addOnSuccessListener { result ->
            val cartList = result.map { document ->
                document.toObject(Cart::class.java)
            }
            onResult(cartList)
        }
        .addOnFailureListener { e ->
            Log.w("Firestore", "Error getting documents", e)
        }
}
*/