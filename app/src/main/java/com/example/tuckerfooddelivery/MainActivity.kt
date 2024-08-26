package com.example.tuckerfooddelivery

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BabyChangingStation
import androidx.compose.material.icons.filled.BackHand
import androidx.compose.material.icons.filled.ChildCare
import androidx.compose.material.icons.filled.CleanHands
import androidx.compose.material.icons.filled.FoodBank
import androidx.compose.material.icons.filled.Hail
import androidx.compose.material.icons.filled.Handshake
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.navigation.NavController
import com.example.tuckerfooddelivery.View.Profile.CircularButtonWithSymbol
import com.example.tuckerfooddelivery.View.RestaurantList
import com.example.tuckerfooddelivery.View.Storage
import com.example.tuckerfooddelivery.View.ThankYouScreen
import com.example.tuckerfooddelivery.ViewModel.AppNavigation
import com.example.tuckerfooddelivery.ViewModel.ScreenHeight
import com.example.tuckerfooddelivery.ViewModel.ScreenWidth

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun MainScreen(navController: NavController , route: @Composable (NavController) -> Unit ) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    ScreenHeight = screenHeight
    ScreenWidth = screenWidth

    Scaffold(
        modifier = Modifier.background(White),
        /*topBar = {
            TopBar(navController, title = title)
        }*/
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
    val bottomNavHeight = 0.06 * ScreenHeight
    BottomAppBar(
        containerColor = colorResource(id = R.color.Mustard_yellow_light),
        contentColor = Black,
        modifier = Modifier.height(bottomNavHeight)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
/*            Image(painter = painterResource(R.drawable.pledge) ,
                contentDescription = "" ,
                Modifier.clickable { navController.navigate("Pledge") })*/
            BottomNavIcon(Icons.Filled.CleanHands, "Pledge", navController, "PledgeScreen")
            BottomNavIcon(Icons.Filled.Home, "Home", navController, "MainScreen")
//            BottomNavIcon(Icons.Filled.Favorite, "Favourites", navController, "Favourites")
            BottomNavIcon(Icons.Filled.ShoppingCart, "Cart", navController, "AddToCart")
//            BottomNavIcon(Icons.Filled.Person, "Profile", navController, "ProfileView")
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
    var size by remember{ mutableStateOf(40) }
    size = if (description == "Home") 55 else 35
    Icon(
        imageVector = icon,
        contentDescription = description,
        modifier = Modifier
            .size(size.dp)
            .clickable { navController.navigate(route) }
    )
}

@Composable
fun TopBar(navController: NavController, title : String){
    Row(Modifier.padding(5.dp,0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularButtonWithSymbol(onClick = { navController.popBackStack() })

        Spacer(modifier = Modifier.width(1.dp))
        Text(
            text = title,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
    }
}