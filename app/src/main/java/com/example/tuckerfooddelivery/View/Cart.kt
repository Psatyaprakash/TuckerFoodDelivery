package com.example.tuckerfooddelivery.View

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.View.Items.ClassicFrenchFriesCart
import com.example.tuckerfooddelivery.ViewModel.ClassicFrenchFries_Cart
import com.example.tuckerfooddelivery.ViewModel.ClassicFrenchFries_Large
import com.example.tuckerfooddelivery.ViewModel.ClassicFrenchFries_Regular
import com.example.tuckerfooddelivery.ViewModel.totalCartPrice_global


@Composable
fun Cart(navController: NavController) {
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    var totalCartPrice : Int by remember {
        mutableStateOf<Int>(0)
    }
    var ClassicFrenchFries_Price : Int by remember {
        mutableStateOf<Int>(0)
    }
    var PizzaCalzone_Price : Int by remember {
        mutableStateOf<Int>(0)
    }
    val context = LocalContext.current

    fun price_update() {
        totalCartPrice = totalCartPrice_global
    }
    Column {
        Column(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .size(height = 740.dp, width = 700.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Row {
                TextButton(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(Color.LightGray),
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Gray, CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.leftarrow),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )
                }
                Spacer(modifier = Modifier.width(1.dp))
                Text(
                    text = "Cart",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            if (ClassicFrenchFries_Cart == 1) {
                ClassicFrenchFriesCart(ClassicFrenchFries_Regular, ClassicFrenchFries_Large)
            }
//
//            if (PizzaCalzone_Cart == 1) {
//                PizzaCalzone_Price= PizzaCalzone_Cart()
//            }
        }


        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .size(height = 200.dp, width = 700.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                modifier = Modifier.padding(10.dp),
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "PRICE : Rs $totalCartPrice",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 20.dp, horizontal = 10.dp),
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.width(50.dp))

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                var value = 0
                TextButton(
                    onClick = { price_update() ;
                        createNotification(context, "Order Summary" , "Order placed \nTotal Price : $totalCartPrice")
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



