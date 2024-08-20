package com.example.tuckerfooddelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tuckerfooddelivery.View.HomePage
import com.example.tuckerfooddelivery.ViewModel.AppNavigation
import okhttp3.Route

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
//            TuckerFoodDeliveryTheme {
            AppNavigation()
//            }
        }
    }
}

@Composable
fun MainScreen(navController: NavController , route: @Composable (NavController) -> Unit ) {
    Scaffold(
        modifier = Modifier.background(White),
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(White)
        ) {
            route(navController)
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomAppBar(
        containerColor = White,
        contentColor = colorResource(id = R.color.Mustard_yellow),
        modifier = Modifier.height(60.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            BottomNavIcon(Icons.Filled.Home, "Home", navController, "MainScreen")
            BottomNavIcon(Icons.Filled.Favorite, "Favourites", navController, "Favourites")
            BottomNavIcon(Icons.Filled.ShoppingCart, "Cart", navController, "Cart")
            BottomNavIcon(
                Icons.Filled.Notifications,
                "Notifications",
                navController,
                "Notification"
            )
            BottomNavIcon(Icons.Filled.Person, "Profile", navController, "ProfileView")
        }
    }
}

@Composable
fun BottomNavIcon(
    icon: ImageVector,
    description: String,
    navController: NavController,
    route: String,
) {
    Icon(
        imageVector = icon,
        contentDescription = description,
        modifier = Modifier
            .size(30.dp)
            .clickable { navController.navigate(route) }
    )
}
