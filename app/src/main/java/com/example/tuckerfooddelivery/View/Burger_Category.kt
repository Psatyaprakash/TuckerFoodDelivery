package com.example.tuckerfooddelivery.View

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Burger_Category(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(17.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp),
            TopStart
        ) {
            CircularButtonWithSymbol(onClick = { /* handle click */ })
        }


        }
}