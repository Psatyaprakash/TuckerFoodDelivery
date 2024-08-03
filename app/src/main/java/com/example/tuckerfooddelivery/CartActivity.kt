package com.example.tuckerfooddelivery

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.tuckerfooddelivery.ViewModel.AppNavigation

// CartActivity.kt
class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Your Jetpack Compose setup
            AppNavigation()
        }
    }
/*
    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    override fun onResume() {
        super.onResume()
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent?) {
        intent?.let {
            val navigateTo = it.getStringExtra("navigate_to")
            if (navigateTo == "cart") {
                // Use Jetpack Navigation Compose to navigate to the Cart Composable
                val navController = findNavController(R.id.nav_host_fragment) // Assuming you have a NavHostFragment
                navController.navigate(R.id.cartFragment) // Ensure this action is defined in your navigation graph
            }
        }
    }
*/
}
