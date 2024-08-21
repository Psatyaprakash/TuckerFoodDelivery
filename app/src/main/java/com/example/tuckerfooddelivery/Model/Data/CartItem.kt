package com.example.tuckerfooddelivery.Model.Data

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class Cart(
    val name: String = "",
    val price: Int = 0,
    var count: Int = 0,
//    val quantity: String
)

