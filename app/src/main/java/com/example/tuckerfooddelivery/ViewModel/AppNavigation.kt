package com.example.tuckerfooddelivery.ViewModel

import com.example.tuckerfooddelivery.View.Profile.FAQScreen
import android.os.Build
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tuckerfooddelivery.View.Category.Burger_Category
import com.example.tuckerfooddelivery.View.Items.AmericanCorn
import com.example.tuckerfooddelivery.View.Items.BlueLagoon
import com.example.tuckerfooddelivery.View.Items.BuffaloWings
import com.example.tuckerfooddelivery.View.Items.BurgerBistro
import com.example.tuckerfooddelivery.View.Cart
import com.example.tuckerfooddelivery.View.Category.Fries_Category
import com.example.tuckerfooddelivery.View.Category.Mocktails_Category
import com.example.tuckerfooddelivery.View.Category.Momos_Category
import com.example.tuckerfooddelivery.View.Category.Pizza_Category
import com.example.tuckerfooddelivery.View.Category.Roll_Category
import com.example.tuckerfooddelivery.View.Category.Starters_Category
import com.example.tuckerfooddelivery.View.Category.Wings_Category
import com.example.tuckerfooddelivery.View.HomePage
import com.example.tuckerfooddelivery.View.LoginScreen
import com.example.tuckerfooddelivery.View.Restaurants.Rosegardenrestaurant_landingpage
import com.example.tuckerfooddelivery.View.Restaurants.SkyHighW_landingpage
import com.example.tuckerfooddelivery.View.Start
import com.example.tuckerfooddelivery.View.Start2
import com.example.tuckerfooddelivery.View.Start3
import com.example.tuckerfooddelivery.View.Restaurants.fionah_landingpage
import com.example.tuckerfooddelivery.View.Items.ChickenWings
import com.example.tuckerfooddelivery.View.Items.ClassicBurger
import com.example.tuckerfooddelivery.View.Items.ClassicFrenchFries
import com.example.tuckerfooddelivery.View.Items.CrispyChickenRoll
import com.example.tuckerfooddelivery.View.Items.ManchowSoup
import com.example.tuckerfooddelivery.View.Items.MargheritaCornPizza
import com.example.tuckerfooddelivery.View.Items.MexicanPepperoniPizza
import com.example.tuckerfooddelivery.View.Items.NepaliDumplingMomos
import com.example.tuckerfooddelivery.View.Items.OrangeMimosa
import com.example.tuckerfooddelivery.View.Items.PaneerRoll
import com.example.tuckerfooddelivery.View.Items.PeriPeriFries
import com.example.tuckerfooddelivery.View.Items.PizzaCalzone
import com.example.tuckerfooddelivery.View.Items.SmokingBurger
import com.example.tuckerfooddelivery.View.Storage
import com.example.tuckerfooddelivery.View.Items.TibetanMomos
import com.example.tuckerfooddelivery.View.Profile.PersonalInfoDetails
import com.example.tuckerfooddelivery.View.Profile.ProfileView
import com.example.tuckerfooddelivery.View.Profile.UserReviews


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
        startDestination = "HomePage"
    ) {
        composable("Storage"){ Storage() }
//        composable("NotificationScreen"){ NotificationScreen(NotificationTitle,NotiC ) }

        composable("Start") { Start(navController) }
        composable("Start2") { Start2(navController) }
        composable("Start3") { Start3(navController) }
        composable("LoginScreen") { LoginScreen(navController) }
        composable("HomePage"){ HomePage(navController) }
        //items
        composable("PizzaCalzone"){ if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            PizzaCalzone(navController)
        }
        }
        composable("ClassicFrenchFries"){ ClassicFrenchFries(navController) }
        composable("BurgerBistro"){ BurgerBistro(navController) }
        composable("TibetanMomos"){ TibetanMomos(navController) }
        composable("BlueLagoon"){ BlueLagoon(navController) }
        composable("ChickenWings"){ ChickenWings(navController) }
        composable("SmokingBurger"){ SmokingBurger(navController) }
        composable("MexicanPepperoniPizza"){ MexicanPepperoniPizza(navController) }
        composable("CrispyChickenRoll"){ CrispyChickenRoll(navController) }
        composable("AmericanCorn"){ AmericanCorn(navController) }
        composable("BuffaloWings"){ BuffaloWings(navController) }
        composable("ManchowSoup"){ ManchowSoup(navController) }
        composable("PaneerRoll"){ PaneerRoll(navController) }
        composable("MargheritaCornPizza"){ MargheritaCornPizza(navController) }
        composable("ClassicBurger"){ ClassicBurger(navController) }
        composable("NepaliDumplingMomos"){ NepaliDumplingMomos(navController) }
        composable("PeriPeriFries"){ PeriPeriFries(navController) }
        composable("OrangeMimosa"){ OrangeMimosa(navController) }
        //categories
        composable("Burger_Category"){ Burger_Category(navController) }
        composable("Wings_Category"){ Wings_Category(navController) }
        composable("Starters_Category"){ Starters_Category(navController) }
        composable("Roll_Category"){ Roll_Category(navController) }
        composable("Pizza_Category"){ Pizza_Category(navController) }
        composable("Fries_Category"){ Fries_Category(navController) }
        composable("Momos_Category"){ Momos_Category(navController) }
        composable("Mocktails_Category"){ Mocktails_Category(navController) }
        //Restaurants
        composable("Rosegardenrestaurant_landingpage"){ Rosegardenrestaurant_landingpage(navController) }
        composable("SkyHighW_landingpage"){ SkyHighW_landingpage(navController) }
        composable("Fionah_landingpage"){ fionah_landingpage(navController) }
        //Cart
        composable("Cart"){ Cart(navController) }

        //Profile
        composable("ProfileView") { ProfileView(navController) }
        composable("PersonalInfoDetails") { PersonalInfoDetails(navController) }
        composable("UserReviews") { UserReviews(navController) }
        composable("FAQScreen") { FAQScreen(navController) }

    }
}
