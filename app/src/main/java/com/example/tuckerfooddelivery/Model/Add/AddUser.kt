package com.example.tuckerfooddelivery.Model.Add

import android.content.ContentValues.TAG
import android.util.Log
import com.example.tuckerfooddelivery.Model.Data.User
import com.example.tuckerfooddelivery.Model.Fetch.db

fun addUser(name :String, email :String , phone : String, bio : String){
    val user = User(
        name ,
        email,
        phone,
        bio
    )

    db.collection("User")
        .document(phone)
        .set(user)
        .addOnSuccessListener {
            Log.d(TAG, "DOCUMENT SNAPSHOT ADDED AT LOC : $phone")
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error Adding Document", e)
        }

}