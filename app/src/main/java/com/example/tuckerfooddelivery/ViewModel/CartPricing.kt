package com.example.tuckerfooddelivery.ViewModel


//Variable storing Total Cart value
var totalCartPrice_global=0


//Updating price in cart function
fun updatePrice(){
    totalCartPrice_global = ClassicFrenchFries_LargePrice + ClassicFrenchFries_RegularPrice
}


//Global Variables used for items
//ClassicFrenchFries item
var ClassicFrenchFries_Cart=0
var ClassicFrenchFries_Regular=0
var ClassicFrenchFries_Large=0
var ClassicFrenchFries_RegularPrice=0
var ClassicFrenchFries_LargePrice=0