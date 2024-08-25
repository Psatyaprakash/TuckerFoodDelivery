package com.example.tuckerfooddelivery.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tuckerfooddelivery.R
//import com.example.tuckerfooddelivery.View.Items.ClassicFrenchFriesCart
//import com.example.tuckerfooddelivery.View.Items.ClassicFrenchFriesWishlist
//import com.example.tuckerfooddelivery.View.Items.PizzaCalzoneCart
//import com.example.tuckerfooddelivery.View.Items.PizzaCalzoneWishlist
import com.example.tuckerfooddelivery.ViewModel.ClassicFrenchFries_Cart
import com.example.tuckerfooddelivery.ViewModel.ClassicFrenchFries_Large
import com.example.tuckerfooddelivery.ViewModel.ClassicFrenchFries_Regular
import com.example.tuckerfooddelivery.ViewModel.ClassicFrenchFries_Wishlist
import com.example.tuckerfooddelivery.ViewModel.PizzaCalzone_10
import com.example.tuckerfooddelivery.ViewModel.PizzaCalzone_14
import com.example.tuckerfooddelivery.ViewModel.PizzaCalzone_16
import com.example.tuckerfooddelivery.ViewModel.PizzaCalzone_Cart
import com.example.tuckerfooddelivery.ViewModel.PizzaCalzone_Wishlist

@Composable
fun Favorites(navController: NavController) {

    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)

    Column {
        Column(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.White_Blue)),
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
                    text = "Wishlist",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }

//            if (PizzaCalzone_Wishlist == 1) {
//                PizzaCalzoneWishlist(navController)
//            }
//            if (ClassicFrenchFries_Wishlist == 1) {
//                ClassicFrenchFriesWishlist(navController)
//            }
        }
    }
}