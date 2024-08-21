package com.example.tuckerfooddelivery.Model.Add

import android.content.ContentValues.TAG
import android.icu.util.Calendar
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import com.example.tuckerfooddelivery.Model.Data.Cart
import com.example.tuckerfooddelivery.Model.Fetch.db
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
fun addCart(name: String, price : Int, count : Int) {
    val cart = com.example.tuckerfooddelivery.Model.Data.Cart(
        name = name,
        price = price,
        count = count
    )
var quan = price * count
    db.collection("Cart")
        .document(name + "_" + quan)
        .set(cart)
        .addOnSuccessListener {
            Log.d(TAG, "DOCUMENT SNAPSHOT ADDED AT LOC : $name _ $quan")
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error Adding Document", e)
        }

}
/*    val currentDate = LocalDate.now()
// Format the date to a readable string
    val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")
    val formattedDate = currentDate.format(formatter)*/
