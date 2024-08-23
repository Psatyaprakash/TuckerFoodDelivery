package com.example.tuckerfooddelivery.Model.Data

import android.media.Image
import androidx.compose.ui.graphics.painter.Painter

data class Cart(
    val name: String = "",
    val price: Int = 0,
    var count: Int = 0,
    val size: String = "",
//    val image: Painter
)
