package com.example.tuckerfooddelivery.View

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tuckerfooddelivery.MainScreen
import com.example.tuckerfooddelivery.R
//import com.example.tuckerfooddelivery.View.Items.ClassicFrenchFriesCart
//import com.example.tuckerfooddelivery.View.Items.PizzaCalzoneCart
import com.example.tuckerfooddelivery.View.Profile.CircularButtonWithSymbol
import com.example.tuckerfooddelivery.ViewModel.ClassicFrenchFries_Cart
import com.example.tuckerfooddelivery.ViewModel.ClassicFrenchFries_Large
import com.example.tuckerfooddelivery.ViewModel.ClassicFrenchFries_Regular
import com.example.tuckerfooddelivery.ViewModel.PizzaCalzone_10
import com.example.tuckerfooddelivery.ViewModel.PizzaCalzone_14
import com.example.tuckerfooddelivery.ViewModel.PizzaCalzone_16
import com.example.tuckerfooddelivery.ViewModel.PizzaCalzone_Cart
import com.example.tuckerfooddelivery.ViewModel.platformFee
import com.example.tuckerfooddelivery.ViewModel.totalAmount
import com.example.tuckerfooddelivery.ViewModel.totalCartPrice_global

@Composable
fun Carts(navController: NavController){
    MainScreen(navController) {
        Cart(navController = it)
    }
}

@Composable
fun Cart(navController: NavController) {
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    var totalCartPrice : Int by remember {
        mutableStateOf<Int>(totalCartPrice_global)
    }
    val context = LocalContext.current

    fun price_update() {
        totalCartPrice = totalCartPrice_global
    }
    totalAmount= totalCartPrice_global+platformFee
    Column {
        Column(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxWidth()
                .size(height = 700.dp, width = 0.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularButtonWithSymbol {
                    navController.popBackStack()
                }
                Spacer(modifier = Modifier.width(1.dp))
                Text(
                    text = "Cart",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
//            if (PizzaCalzone_Cart == 1) {
//                PizzaCalzoneCart(PizzaCalzone_10,PizzaCalzone_14,PizzaCalzone_16)
//            }
//            if (ClassicFrenchFries_Cart == 1) {
//                ClassicFrenchFriesCart(ClassicFrenchFries_Regular, ClassicFrenchFries_Large)
//            }
//

        }


        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .size(height = 300.dp, width = 700.dp)
                .verticalScroll(rememberScrollState())
                .padding(vertical = 20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Item Total : Rs $totalCartPrice",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding( horizontal = 10.dp),
                    fontSize = 23.sp
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Delivery Charge : Free\n" +
                            "Platform Fee : Rs $platformFee",
                    fontWeight = FontWeight.W300,
                    modifier = Modifier.padding(horizontal = 10.dp),
                    fontSize = 21.sp
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Total Amount : Rs $totalAmount",
                    fontWeight = FontWeight.Black,
                    modifier = Modifier.padding( horizontal = 10.dp),
                    fontSize = 25.sp
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                var value = 0
                TextButton(
                    onClick = { price_update() ;
                        createNotification(context, "Order Summary" , "Order placed \nTotal Amount : $totalAmount")
                              },
                    colors = ButtonDefaults.buttonColors(containerColor = Mustard_yellow),
                    border = BorderStroke(width = 0.dp, color = Color.Transparent),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 20.dp)
                        //.size(height = 40.dp, width = 400.dp),
                        .fillMaxWidth()
                        .height(54.dp),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Text(
                        text = " BUY NOW ",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 22.sp
                    )
                }
            }
        }
    }
}



