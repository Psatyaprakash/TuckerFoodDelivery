package com.example.tuckerfooddelivery.ViewModel

import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.storage.storage

val storage = Firebase.storage
val storageRef = storage.reference

//Variable storing Total Cart value
var totalCartPrice_global=0
var totalAmount=0
var platformFee=5


//Updating price in cart function
fun updatePrice(){
    totalCartPrice_global = ClassicFrenchFries_LargePrice + ClassicFrenchFries_RegularPrice +
            PizzaCalzone_10Price + PizzaCalzone_14Price + PizzaCalzone_16Price
}


//Global Variables used for items
//ClassicFrenchFries item
var ClassicFrenchFries_Cart=0
var ClassicFrenchFries_Wishlist =0
var ClassicFrenchFries_Regular=0
var ClassicFrenchFries_Large=0
var ClassicFrenchFries_RegularPrice=0
var ClassicFrenchFries_LargePrice=0

//PizzaCalzone item
var PizzaCalzone_Cart=0
var PizzaCalzone_Wishlist =0
var PizzaCalzone_10=0
var PizzaCalzone_14=0
var PizzaCalzone_16=0
var PizzaCalzone_10Price=0
var PizzaCalzone_14Price=0
var PizzaCalzone_16Price=0

//Profile
var userName = ""
var userEmail = ""
var userPhone = "1023456789"
var userBio = ""

//User
var loggedInAs = ""
var userPrimaryAddress = "BHB Colony,New Delhi"

//Screen Dimension
var ScreenHeight = 0.dp
var ScreenWidth = 0.dp
