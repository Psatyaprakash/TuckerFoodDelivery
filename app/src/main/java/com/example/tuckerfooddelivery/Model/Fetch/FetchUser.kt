package com.example.tuckerfooddelivery.Model.Fetch

import android.content.ContentValues.TAG
import android.util.Log
import com.example.tuckerfooddelivery.Model.Data.User

fun fetchUser(onResult: (List<User>) -> Unit) {
    db.collection("User")
        .get()
        .addOnSuccessListener { result ->
            val userList = result.map { document -> document.toObject(User::class.java) }
            onResult(userList)
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error getting document", e)
        }
}