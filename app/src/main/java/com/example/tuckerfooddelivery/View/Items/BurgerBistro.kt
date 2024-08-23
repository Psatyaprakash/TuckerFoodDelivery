package com.example.tuckerfooddelivery.View.Items

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tuckerfooddelivery.Model.Add.addCart
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.View.Profile.CircularButtonWithSymbol


var BurgerBistro_Cart=0
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BurgerBistro(navController: NavController) {
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)

    var selectedButtonIndex by remember { mutableStateOf(1) }

    @Composable
    fun getButtonColor(index: Int): Color {
        return if (index == selectedButtonIndex) Mustard_yellow else colorResource(id = R.color.White_Blue)
    }

    fun onButtonClick(index: Int) {
        selectedButtonIndex = index
    }
    //Jaggu
    var totalprice: Int by remember { mutableStateOf(116) }
    val unitPriceRegular: Int by remember { mutableIntStateOf(116) }
    val unitPriceLarge: Int by remember { mutableStateOf(189) }
    var size by remember { mutableStateOf("Regular") }
    val Item_Name = "BurgerBistro"
    val Name = "Burger Bistro"

    var count by remember {
        mutableStateOf<Int>(1)
    }
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)

//Jaggu
    Column(
        Modifier
            .fillMaxSize()
            .padding(0.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .background(White)
                .fillMaxHeight(.8f)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(15.dp))
                //Jaggu
            Row(verticalAlignment = Alignment.CenterVertically) {
                CircularButtonWithSymbol {
                    navController.popBackStack()
                }
                Spacer(modifier = Modifier.width(1.dp))
                Text(
                    text = "Details",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                shape = RoundedCornerShape(16.dp),
                backgroundColor = Mustard_yellow,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
            ) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.burger_bistro),
                        contentDescription = "Burger Bistro",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(220.dp)
                    )
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Add",
                        tint = Color.White,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(40.dp)
                            .background(Color.Red, shape = CircleShape)
                            .padding(8.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = Name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(10.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Soft burger buns filled with spicy and juicy Grilled chicken beast with veggies and sauces.",
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                //horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.star__),
                    contentDescription = "Pizza",
                    modifier = Modifier
                        //.align(Alignment.Top)
                        .size(30.dp)
                        .padding(0.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = "4.7",
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(horizontal = 2.dp)
                )
                Spacer(modifier = Modifier.width(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.truck__),
                    contentDescription = "Pizza",
                    modifier = Modifier
                        .size(35.dp)
                        .padding(0.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Free",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(horizontal = 2.dp)
                )

                Spacer(modifier = Modifier.width(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.clock__),
                    contentDescription = "Pizza",
                    modifier = Modifier
                        .size(35.dp)
                        .padding(0.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "20 min",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(horizontal = 2.dp)
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 1.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "SIZE:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.
                    padding(horizontal = 10.dp)
                )
                //Jaggu
                TextButton(onClick = {
                        onButtonClick(1);
                        totalprice = unitPriceRegular
                    },
                    colors = ButtonDefaults.textButtonColors(
                        getButtonColor(1)
                    ),
                    modifier = Modifier
                        .size(height = 50.dp, width = 100.dp),
                    shape = RoundedCornerShape(15.dp)
                ){
                    Text(text = "Regular", fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.width(30.dp))
                TextButton(onClick = { onButtonClick(2);
                    totalprice = unitPriceLarge },
                    colors = ButtonDefaults.textButtonColors(
                        getButtonColor(2)
                    ),
                    modifier = Modifier
                        .size(height = 50.dp, width = 100.dp),
                    shape = RoundedCornerShape(15.dp)
                ){
                    Text(text = "Large", fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.width(20.dp))
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "INGRIDENTS", fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 10.dp))
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 0.dp)
                    .fillMaxWidth(),
                //.align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.salt),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.kfc),
                        contentDescription = "",
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.garlic),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.onion),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.chilli),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
            }
//            Spacer(modifier = Modifier.height(75.dp))

        }
//Jaggu Whole column

        Column(
            modifier = Modifier
                .background(colorResource(id = R.color.White_Blue))
                .fillMaxWidth()
//                    .fillMaxHeight(.2f)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(5.dp, 2.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Rs ${totalprice * count}", //to get total price
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 20.dp, horizontal = 10.dp),
                    fontSize = 25.sp
                )
                Row(modifier = Modifier
                    .width(120.dp)
                    .background(Mustard_yellow, shape = RoundedCornerShape(30.dp)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    IconButton(onClick = {
                        if (count == 1) count = 1 else count--
                    }) { //to set default limit as 1
                        Icon(
                            Icons.Default.KeyboardArrowDown,
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    Text(
                        text = "$count",
                        fontSize = 20.sp
                    )

                    IconButton(onClick = { count++ }) {
                        Icon(
                            Icons.Default.KeyboardArrowUp,
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }

                TextButton(
                    onClick = {
                        if(totalprice == unitPriceRegular)size = "Regular" else size = "Large"
                        addCart(Item_Name,Name,totalprice ,count,size)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Mustard_yellow),
                    modifier = Modifier
                        .padding(2.dp, 0.dp)
                        .height(54.dp),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Icon(
                        Icons.Default.AddShoppingCart,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
                TextButton(
                    onClick = {
                        try {
                            navController.navigate("AddToCart")
                        } catch (e: Exception) {
                            Log.e("Navigation Error", e.toString())
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Mustard_yellow),
                    modifier = Modifier
                        .padding(2.dp, 0.dp)
                        .height(54.dp),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Icon(
                        Icons.Default.ShoppingCart,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }

    }
}


