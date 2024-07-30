package com.example.tuckerfooddelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tuckerfooddelivery.ViewModel.AppNavigation
import com.example.tuckerfooddelivery.ui.theme.TuckerFoodDeliveryTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            TuckerFoodDeliveryTheme {
                AppNavigation()

            }
        }
    }
}

