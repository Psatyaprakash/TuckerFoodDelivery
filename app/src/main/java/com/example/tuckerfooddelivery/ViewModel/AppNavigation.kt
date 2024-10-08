package com.example.tuckerfooddelivery.ViewModel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tuckerfooddelivery.MainScreen
import com.example.tuckerfooddelivery.View.AddToCart
import com.example.tuckerfooddelivery.View.AddressScreen
import com.example.tuckerfooddelivery.View.Category.Burger_Category
import com.example.tuckerfooddelivery.View.Category.Fries_Category
import com.example.tuckerfooddelivery.View.Category.Mocktails_Category
import com.example.tuckerfooddelivery.View.Category.Momos_Category
import com.example.tuckerfooddelivery.View.Category.Pizza_Category
import com.example.tuckerfooddelivery.View.Category.Roll_Category
import com.example.tuckerfooddelivery.View.Category.Starters_Category
import com.example.tuckerfooddelivery.View.Category.Wings_Category
import com.example.tuckerfooddelivery.View.Congrats
import com.example.tuckerfooddelivery.View.Delivery
import com.example.tuckerfooddelivery.View.HomePage
import com.example.tuckerfooddelivery.View.Items.AmericanCorn
import com.example.tuckerfooddelivery.View.Items.BlueLagoon
import com.example.tuckerfooddelivery.View.Items.BuffaloWings
import com.example.tuckerfooddelivery.View.Items.BurgerBistro
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
import com.example.tuckerfooddelivery.View.Items.TibetanMomos
import com.example.tuckerfooddelivery.View.LoginScreen
import com.example.tuckerfooddelivery.View.PledgeScreen
import com.example.tuckerfooddelivery.View.PreparedOrderScreen
import com.example.tuckerfooddelivery.View.Profile.FAQScreen
import com.example.tuckerfooddelivery.View.Profile.PersonalInfoDetails
import com.example.tuckerfooddelivery.View.Profile.ProfileView
import com.example.tuckerfooddelivery.View.Profile.UserReviews
import com.example.tuckerfooddelivery.View.Restaurant_Pages.RestaurantHomePage
import com.example.tuckerfooddelivery.View.Restaurant_Pages.Timing
import com.example.tuckerfooddelivery.View.Restaurants.Rosegardenrestaurant_landingpage
import com.example.tuckerfooddelivery.View.Restaurants.SkyHighW_landingpage
import com.example.tuckerfooddelivery.View.Restaurants.fionah_landingpage
import com.example.tuckerfooddelivery.View.SaveLocationScreen
import com.example.tuckerfooddelivery.View.Start
import com.example.tuckerfooddelivery.View.Start2
import com.example.tuckerfooddelivery.View.Start3
import com.example.tuckerfooddelivery.View.Storage
import com.example.tuckerfooddelivery.View.ThankYouScreen
import com.example.tuckerfooddelivery.View.Wishlist


//Navigation
@RequiresApi(Build.VERSION_CODES.O)
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
        composable("Storage"){ Storage() }
//        composable("NotificationScreen"){ NotificationScreen(NotificationTitle,NotificationContent ) }

        composable("Start") { Start(navController) }
        composable("Start2") { Start2(navController) }
        composable("Start3") { Start3(navController) }
        composable("LoginScreen") { LoginScreen(navController) }
        composable("MainScreen"){ MainScreen(navController, route={ HomePage(navController = it)}) }
        composable("HomePage"){ HomePage(navController) }
        composable("PledgeScreen") { PledgeScreen(navController) }
        composable("ThankYouScreen") { ThankYouScreen(navController) }

        //Congrats
        composable("Congrats"){ Congrats(navController = navController) }
        composable("Delivery"){ MainScreen(navController , route = { Delivery(navController = it)})}

        //Restaurant Homepage
        composable("RestaurantHomePage"){ RestaurantHomePage(navController = navController) }
        composable("Timing"){ Timing(navController = navController) }
        composable("PreparedOrderScreen"){ PreparedOrderScreen(navController = navController) }




        //items
        composable("PizzaCalzone"){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
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
        composable("Burger_Category"){ MainScreen(navController ,route= { Burger_Category(navController = it) }) }
        composable("Wings_Category"){ MainScreen(navController ,route= { Wings_Category(navController = it) }) }
        composable("Starters_Category"){  MainScreen(navController  , route = {Starters_Category(navController = it) } ) }
        composable("Roll_Category"){ MainScreen(navController, route = {Roll_Category( navController = it )}) }
        composable("Pizza_Category"){ MainScreen(navController ,route= { Pizza_Category(navController = it) }) }
        composable("Fries_Category"){ MainScreen(navController ,route= { Fries_Category(navController = it) }) }
        composable("Momos_Category"){  MainScreen(navController  , route = {Momos_Category(navController = it) } ) }
        composable("Mocktails_Category"){ MainScreen(navController, route = {Mocktails_Category( navController = it )}) }
        //composable("Mocktails_Category"){ Mocktails_Category(navController) }


        //Restaurants
        composable("Rosegardenrestaurant_landingpage"){ Rosegardenrestaurant_landingpage(navController) }
        composable("SkyHighW_landingpage"){ SkyHighW_landingpage(navController) }
        composable("Fionah_landingpage"){ fionah_landingpage(navController) }

        //Cart
//      composable("Carts"){ Carts(navController) }
        composable("AddToCart"){ AddToCart(navController) }
        composable("Wishlist"){ Wishlist(navController) }

        //Profile
        composable("ProfileView") { ProfileView(navController) }
        composable("PersonalInfoDetails") { PersonalInfoDetails(navController) }
        composable("UserReviews") { UserReviews(navController) }
        composable("FAQScreen") { FAQScreen(navController) }

        //Address
        composable("AddressScreen") { AddressScreen(navController) }
        composable("SaveLocationScreen") { SaveLocationScreen(navController) }

    }
}
