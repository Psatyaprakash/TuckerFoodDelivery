package com.example.tuckerfooddelivery.ViewModel

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tuckerfooddelivery.View.HomePage
import com.example.tuckerfooddelivery.View.LoginScreen
import com.example.tuckerfooddelivery.View.Pizza
import com.example.tuckerfooddelivery.View.Pizza_2
import com.example.tuckerfooddelivery.View.Pizza_3
import com.example.tuckerfooddelivery.View.Rosegardenrestaurant_landingpage
import com.example.tuckerfooddelivery.View.SkyHighW_landingpage
import com.example.tuckerfooddelivery.View.Start
import com.example.tuckerfooddelivery.View.Start2
import com.example.tuckerfooddelivery.View.Start3
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
        startDestination = "Start"
    ) {
        composable("Start") { Start(navController) }
        composable("Start2") { Start2(navController) }
        composable("Start3") { Start3(navController) }
        composable("Start") { Start(navController) }
        composable("LoginScreen") { LoginScreen(navController) }
        composable("HomePage"){ HomePage(navController) }
        composable("Pizza"){ Pizza(navController) }
        composable("Pizza_2"){ Pizza_2(navController) }
        composable("Pizza_3"){ Pizza_3(navController) }

        composable("Rosegardenrestaurant_landingpage"){ Rosegardenrestaurant_landingpage(navController) }
        composable("SkyHighW_landingpage"){ SkyHighW_landingpage(navController) }
        composable("Fionah_landingpage"){ fionah_landingpage(navController) }

    }
}
