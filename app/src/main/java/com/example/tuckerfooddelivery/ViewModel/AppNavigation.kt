package com.example.tuckerfooddelivery.ViewModel

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tuckerfooddelivery.View.Burger_Category
import com.example.tuckerfooddelivery.View.Cart
import com.example.tuckerfooddelivery.View.ClassicFrenchFries
import com.example.tuckerfooddelivery.View.Fries_Category
import com.example.tuckerfooddelivery.View.HomePage
import com.example.tuckerfooddelivery.View.LoginScreen
import com.example.tuckerfooddelivery.View.Mocktails_Category
import com.example.tuckerfooddelivery.View.Momos_Category
import com.example.tuckerfooddelivery.View.NotificationScreen
import com.example.tuckerfooddelivery.View.PizzaCalzone
import com.example.tuckerfooddelivery.View.Pizza_Category
import com.example.tuckerfooddelivery.View.Roll_Category
import com.example.tuckerfooddelivery.View.Rosegardenrestaurant_landingpage
import com.example.tuckerfooddelivery.View.SkyHighW_landingpage
import com.example.tuckerfooddelivery.View.Start
import com.example.tuckerfooddelivery.View.Start2
import com.example.tuckerfooddelivery.View.Start3
import com.example.tuckerfooddelivery.View.Starters_Category
import com.example.tuckerfooddelivery.View.Storage
import com.example.tuckerfooddelivery.View.Wings_Category
import com.example.tuckerfooddelivery.View.fionah_landingpage

//Navigation
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        enterTransition = { fadeIn(animationSpec = tween(200)) +
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(200)
                ) },
        exitTransition = { fadeOut(animationSpec = tween(200))  +
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(200) )},
        startDestination = "NotificationScreen"
    ) {
        composable("Storage"){ Storage() }
        composable("NotificationScreen"){ NotificationScreen() }

        composable("Start") { Start(navController) }
        composable("Start2") { Start2(navController) }
        composable("Start3") { Start3(navController) }
        composable("LoginScreen") { LoginScreen(navController) }
        composable("HomePage"){ HomePage(navController) }
        composable("PizzaCalzone"){ PizzaCalzone(navController) }
        composable("ClassicFrenchFries"){ ClassicFrenchFries(navController) }

        composable("Burger_Category"){ Burger_Category(navController) }
        composable("Wings_Category"){ Wings_Category(navController) }
        composable("Starters_Category"){ Starters_Category(navController) }
        composable("Roll_Category"){ Roll_Category(navController) }
        composable("Pizza_Category"){ Pizza_Category(navController) }
        composable("Fries_Category"){ Fries_Category(navController) }
        composable("Momos_Category"){ Momos_Category(navController) }
        composable("Mocktails_Category"){ Mocktails_Category(navController) }

        composable("Cart"){ Cart(navController) }
        composable("Rosegardenrestaurant_landingpage"){ Rosegardenrestaurant_landingpage(navController) }
        composable("SkyHighW_landingpage"){ SkyHighW_landingpage(navController) }
        composable("Fionah_landingpage"){ fionah_landingpage(navController) }

    }
}
