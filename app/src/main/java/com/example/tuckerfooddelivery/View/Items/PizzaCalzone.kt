package com.example.tuckerfooddelivery.View.Items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.ViewModel.ClassicFrenchFries_Large
import com.example.tuckerfooddelivery.ViewModel.ClassicFrenchFries_LargePrice
import com.example.tuckerfooddelivery.ViewModel.ClassicFrenchFries_Regular
import com.example.tuckerfooddelivery.ViewModel.ClassicFrenchFries_RegularPrice
import com.example.tuckerfooddelivery.ViewModel.ClassicFrenchFries_Wishlist
import com.example.tuckerfooddelivery.ViewModel.PizzaCalzone_10
import com.example.tuckerfooddelivery.ViewModel.PizzaCalzone_10Price
import com.example.tuckerfooddelivery.ViewModel.PizzaCalzone_14
import com.example.tuckerfooddelivery.ViewModel.PizzaCalzone_14Price
import com.example.tuckerfooddelivery.ViewModel.PizzaCalzone_16
import com.example.tuckerfooddelivery.ViewModel.PizzaCalzone_16Price
import com.example.tuckerfooddelivery.ViewModel.PizzaCalzone_Cart
import com.example.tuckerfooddelivery.ViewModel.PizzaCalzone_Wishlist
import com.example.tuckerfooddelivery.ViewModel.updatePrice


@Composable
fun PizzaCalzone(navController: NavController) {

    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)

    var star by remember { mutableStateOf(0.0) }
    val deliver by remember { mutableStateOf("") }
    var deliveryTime by remember { mutableStateOf(0) }
    var price by remember { mutableStateOf(199) }
    var count by remember { mutableStateOf(1) }


    var selectedButtonIndex by remember { mutableStateOf(1) }

    fun getButtonColor(index: Int): Color {
        return if (index == selectedButtonIndex) Mustard_yellow else Color.LightGray
    }

    fun onButtonClick(index: Int) {
        selectedButtonIndex = index
    }

    /*
    All the values of the above variables will be retrieved from database
    So need not be hard coded
    For testing variables will be declared explicitly
    */

    star = 4.7
    deliveryTime = 20

    val unitPrice_10 = 199
    val unitPrice_14 = 239
    val unitPrice_16 = 259
    var count_10 by remember {
        mutableStateOf<Int>(1)
    }
    var count_14 by remember {
        mutableStateOf<Int>(1)
    }
    var count_16 by remember {
        mutableStateOf<Int>(1)
    }
    var totalprice by remember {
        mutableStateOf<Int>(0)
    }
    var totalprice_10: Int by remember {
        mutableStateOf<Int>(unitPrice_10 * count_10)
    }
    var totalprice_14: Int by remember {
        mutableStateOf<Int>(unitPrice_14 * count_14)
    }
    var totalprice_16: Int by remember {
        mutableStateOf<Int>(unitPrice_14 * count_14)
    }

    if (getButtonColor(1) == Mustard_yellow) {
        count = count_10
    } else if (getButtonColor(2) == Mustard_yellow) {
        count = count_14
    }

    totalprice_10 = unitPrice_10 * count_10
    totalprice_14 = unitPrice_14 * count_14
    totalprice_16 = unitPrice_16 * count_16


    Column {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .size(width = 500.dp, height = 555.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                TextButton(
                    onClick = { navController.popBackStack() },
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
                    text = "Details",
                    fontSize = 16.sp,
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
//                colors = CardColors(
//                    containerColor = Mustard_yellow_light, contentColor = Color.Black,
//                    disabledContentColor = Mustard_yellow,
//                    disabledContainerColor = Mustard_yellow
//                )
            ) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pizza_calzone),
                        contentDescription = "Pizza",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(200.dp)
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
                            .clickable(onClick = {
                                PizzaCalzone_Wishlist = 1;navController.navigate(
                                "Favorites"
                            )
                            })
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Pizza Calzone European",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(10.dp)
            )
            Spacer(modifier = Modifier.height(13.dp))
            Text(
                text = "Prosciutto e funghi is a pizza variety that is topped with tomato sauce.",
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 1.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "star",
                    modifier = Modifier
                        //.align(Alignment.Top)
                        .size(30.dp)
                        .padding(0.dp)
                )

                Text(
                    text = "$star",
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(horizontal = 2.dp)
                )
                Spacer(modifier = Modifier.width(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.truck),
                    contentDescription = "delivery",
                    modifier = Modifier
                        .size(35.dp)
                        .padding(0.dp)
                )
                Text(
                    text = if (deliver == "") "Free" else deliver,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(horizontal = 2.dp)
                )

                Spacer(modifier = Modifier.width(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.clock),
                    contentDescription = "delivery_time",
                    modifier = Modifier
                        .size(35.dp)
                        .padding(0.dp)
                )
                Text(
                    text = "$deliveryTime",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(horizontal = 2.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 1.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "SIZE : ",
                    modifier = Modifier.padding(horizontal = 10.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                TextButton(
                    onClick = { onButtonClick(1); price = 199 },
                    colors = ButtonDefaults.textButtonColors(
                        getButtonColor(1)
                    ),
                    modifier = Modifier
                        .size(60.dp),
                    shape = CircleShape
                ) {
                    Text(text = "10''", fontSize = 25.sp)
                }

                Spacer(modifier = Modifier.width(30.dp))
                TextButton(
                    onClick = { onButtonClick(2); price = 239 },
                    colors = ButtonDefaults.textButtonColors(getButtonColor(2)),
                    modifier = Modifier
                        .size(60.dp),
                    shape = CircleShape
                ) {
                    Text(text = "14''", fontSize = 25.sp)
                }

                Spacer(modifier = Modifier.width(30.dp))
                TextButton(
                    onClick = { onButtonClick(3); price = 259 },
                    colors = ButtonDefaults.textButtonColors(getButtonColor(3)),
                    modifier = Modifier
                        .size(60.dp),
                    shape = CircleShape
                ) {
                    Text(text = "16''", fontSize = 25.sp)
                }

                Spacer(modifier = Modifier.width(20.dp))
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "INGRIDENTS", modifier = Modifier.padding(horizontal = 10.dp))
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 0.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
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
                        painter = painterResource(id = R.drawable.garlic),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
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
            Spacer(modifier = Modifier.height(45.dp))
        }
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .size(height = 650.dp, width = 700.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Top
            ) {
                Row(
                    modifier = Modifier.padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.Start
                ) {

                    Text(
                        text = "Pizza(10'') : Rs $totalprice_10",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 20.dp, horizontal = 0.dp),
                        fontSize = 25.sp
                    )
                }
                Row(
                    modifier = Modifier.padding(20.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Box(
                        modifier = Modifier
                            .size(height = 50.dp, width = 150.dp)
                            .background(color = Mustard_yellow, shape = CircleShape)
                            .align(Alignment.CenterVertically)
                    ) {
                        Row {
                            IconButton(onClick = {
                                if (count_10 == 0) count_10 = 0 else count_10--
                            }) {
                                Icon(
                                    Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(5.dp))

                            Text(
                                text = "$count_10", modifier = Modifier
                                    .padding(vertical = 15.dp)
                                    .padding(horizontal = 15.dp),
                                fontSize = 20.sp
                            )
                            Spacer(modifier = Modifier.width(1.dp))
                            IconButton(onClick = { count_10++ }) {
                                Icon(
                                    Icons.Default.KeyboardArrowUp,
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp)
                                )
                            }
                        }
                    }

                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier.padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.Start
                ) {

                    Text(
                        text = "Pizza(14'') : Rs $totalprice_14",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 20.dp, horizontal = 0.dp),
                        fontSize = 25.sp
                    )
                }
                Row(
                    modifier = Modifier.padding(20.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Box(
                        modifier = Modifier
                            .size(height = 50.dp, width = 150.dp)
                            .background(color = Mustard_yellow, shape = CircleShape)
                            .align(Alignment.CenterVertically)
                    ) {
                        Row {
                            IconButton(onClick = {
                                if (count_14 == 0) count_14 = 0 else count_14--
                            }) {
                                Icon(
                                    Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "$count_14", modifier = Modifier
                                    .padding(vertical = 15.dp)
                                    .padding(horizontal = 15.dp),
                                fontSize = 20.sp
                            )
                            Spacer(modifier = Modifier.width(1.dp))
                            IconButton(onClick = { count_14++ }) {
                                Icon(
                                    Icons.Default.KeyboardArrowUp,
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp)
                                )
                            }
                        }
                    }

                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier.padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.Start
                ) {

                    Text(
                        text = "Pizza(16'') : Rs $totalprice_16",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 20.dp, horizontal = 0.dp),
                        fontSize = 25.sp
                    )
                }
                Row(
                    modifier = Modifier.padding(20.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Box(
                        modifier = Modifier
                            .size(height = 50.dp, width = 150.dp)
                            .background(color = Mustard_yellow, shape = CircleShape)
                            .align(Alignment.CenterVertically)
                    ) {
                        Row {
                            IconButton(onClick = {
                                if (count_16 == 0) count_16 = 0 else count_16--
                            }) {
                                Icon(
                                    Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "$count_16", modifier = Modifier
                                    .padding(vertical = 15.dp)
                                    .padding(horizontal = 15.dp),
                                fontSize = 20.sp
                            )
                            Spacer(modifier = Modifier.width(1.dp))
                            IconButton(onClick = { count_16++ }) {
                                Icon(
                                    Icons.Default.KeyboardArrowUp,
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp)
                                )
                            }
                        }
                    }

                }
            }



            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextButton(
                    onClick = { if(((count_10!=0)||(count_14!=0))||(count_16!=0)){
                        PizzaCalzone_10=count_10
                        PizzaCalzone_14=count_14
                        PizzaCalzone_16=count_16
                    PizzaCalzone_Cart =1
                    updatePrice() }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Mustard_yellow),
                    border = BorderStroke(width = 0.dp, color = Color.Transparent),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 20.dp)
                        .height(54.dp),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Text(
                        text = " ADD TO CART ",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
                TextButton(
                    onClick = {
                        navController.navigate("Cart")
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Mustard_yellow),
                    border = BorderStroke(width = 0.dp, color = Color.Transparent),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 20.dp)
                        //.size(height = 40.dp, width = 400.dp),
                        //.fillMaxWidth()
                        .height(54.dp),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Text(
                        text = " GO TO CART ",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }

            }
        }
    }
}


@Composable
fun PizzaCalzoneCart(Pizza_10:Int,Pizza_14:Int,Pizza_16:Int) {
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    val unitprice_10: Int by remember {
        mutableStateOf<Int>(199)
    }
    var totalprice_10: Int by remember {
        mutableStateOf<Int>(199)
    }
    var count_10 by remember {
        mutableStateOf<Int>(Pizza_10)
    }

    fun update10Price() {
        if (PizzaCalzone_10 == 0) {
            PizzaCalzone_10Price = 0
        } else {
            totalprice_10 = unitprice_10 * count_10
            PizzaCalzone_10Price = totalprice_10
        }
        updatePrice()
    }

    val unitprice_14: Int by remember {
        mutableStateOf<Int>(239)
    }
    var totalprice_14: Int by remember {
        mutableStateOf<Int>(239)
    }
    var count_14 by remember {
        mutableStateOf<Int>(Pizza_14)
    }

    fun update14Price() {
        if (PizzaCalzone_14 == 0) {
            PizzaCalzone_14Price = 0
        } else {
            totalprice_14 = unitprice_14 * count_14
            PizzaCalzone_14Price = totalprice_14
        }
        updatePrice()
    }

    val unitprice_16: Int by remember {
        mutableStateOf<Int>(259)
    }
    var totalprice_16: Int by remember {
        mutableStateOf<Int>(259)
    }
    var count_16 by remember {
        mutableStateOf<Int>(Pizza_16)
    }

    fun update16Price() {
        if (PizzaCalzone_16 == 0) {
            PizzaCalzone_16Price = 0
        } else {
            totalprice_16 = unitprice_16 * count_16
            PizzaCalzone_16Price = totalprice_16
        }
        updatePrice()
    }

    var totalprice: Int by remember {
        mutableStateOf<Int>(totalprice_10 + totalprice_14 + totalprice_16)
    }
    totalprice = totalprice_10 + totalprice_14 + totalprice_16
    Column {


        if (count_10 > 0) {

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
                        .background(color = Mustard_yellow_light)
                ) {
                    Row {
                        Card(
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier
                                .padding(0.dp)
                                .size(120.dp)
                                .wrapContentHeight(),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.pizza_calzone),
                                contentDescription = "classic_french_fries",
                                modifier = Modifier
                                    //.align(Alignment.Center)
                                    .size(220.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "Pizza Calzone\n" +
                                        "(Size:10'')",
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp
                            )

                            Text(
                                text = "PRICE : Rs $totalprice_10",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(
                                    vertical = 10.dp,
                                    horizontal = 2.dp
                                ),
                                fontSize = 15.sp
                            )
                            Box(
                                modifier = Modifier
                                    .size(height = 30.dp, width = 150.dp)
                                    .background(color = Color.White, shape = CircleShape)

                            ) {
                                Row {
                                    IconButton(onClick = {
                                        if (count_10 == 1) {
                                            count_10 = 0
                                            PizzaCalzone_10 = 0
                                        }
                                        else count_10--;update10Price();update14Price();update16Price()
                                    }) {
                                        Icon(
                                            Icons.Default.KeyboardArrowDown,
                                            contentDescription = null,
                                            modifier = Modifier.size(50.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Text(
                                        text = "$count_10", modifier = Modifier
                                            .padding(vertical = 5.dp)
                                            .padding(horizontal = 15.dp),
                                        fontSize = 20.sp
                                    )
                                    Spacer(modifier = Modifier.width(1.dp))
                                    IconButton(onClick = { count_10++;update10Price();update14Price();update16Price() }) {
                                        Icon(
                                            Icons.Default.KeyboardArrowUp,
                                            contentDescription = null,
                                            modifier = Modifier.size(50.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (count_14 > 0) {
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
                        .background(color = Mustard_yellow_light)
                ) {
                    Row {
                        Card(
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier
                                .padding(0.dp)
                                .size(120.dp)
                                .wrapContentHeight(),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.pizza_calzone),
                                contentDescription = "classic_french_fries",
                                modifier = Modifier
                                    //.align(Alignment.Center)
                                    .size(220.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "Pizza Calzone\n" +
                                        "(Size:14'')",
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp
                            )

                            Text(
                                text = "PRICE : Rs $totalprice_14",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(
                                    vertical = 10.dp,
                                    horizontal = 2.dp
                                ),
                                fontSize = 15.sp
                            )
                            Box(
                                modifier = Modifier
                                    .size(height = 30.dp, width = 150.dp)
                                    .background(color = Color.White, shape = CircleShape)

                            ) {
                                Row {
                                    IconButton(onClick = {
                                        if (count_14 == 1) {
                                            count_14 = 0
                                            PizzaCalzone_14 = 0
                                        }
                                        else count_14--;update10Price();update14Price();update16Price()
                                    }) {
                                        Icon(
                                            Icons.Default.KeyboardArrowDown,
                                            contentDescription = null,
                                            modifier = Modifier.size(50.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Text(
                                        text = "$count_14", modifier = Modifier
                                            .padding(vertical = 5.dp)
                                            .padding(horizontal = 15.dp),
                                        fontSize = 20.sp
                                    )
                                    Spacer(modifier = Modifier.width(1.dp))
                                    IconButton(onClick = { count_14++;update10Price();update14Price();update16Price() }) {
                                        Icon(
                                            Icons.Default.KeyboardArrowUp,
                                            contentDescription = null,
                                            modifier = Modifier.size(50.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (count_16 > 0) {
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
                        .background(color = Mustard_yellow_light)
                ) {
                    Row {
                        Card(
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier
                                .padding(0.dp)
                                .size(120.dp)
                                .wrapContentHeight(),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.pizza_calzone),
                                contentDescription = "classic_french_fries",
                                modifier = Modifier
                                    //.align(Alignment.Center)
                                    .size(220.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "Pizza Calzone\n(Size:16'')",
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp
                            )

                            Text(
                                text = "PRICE : Rs $totalprice_16",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(
                                    vertical = 10.dp,
                                    horizontal = 2.dp
                                ),
                                fontSize = 15.sp
                            )
                            Box(
                                modifier = Modifier
                                    .size(height = 30.dp, width = 150.dp)
                                    .background(color = Color.White, shape = CircleShape)

                            ) {
                                Row {
                                    IconButton(onClick = {
                                        if (count_16 == 1) {
                                            count_16 = 0
                                            PizzaCalzone_16 = 0
                                        }
                                        else count_16--;update10Price();update14Price();update16Price()
                                    }) {
                                        Icon(
                                            Icons.Default.KeyboardArrowDown,
                                            contentDescription = null,
                                            modifier = Modifier.size(50.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Text(
                                        text = "$count_16", modifier = Modifier
                                            .padding(vertical = 5.dp)
                                            .padding(horizontal = 15.dp),
                                        fontSize = 20.sp
                                    )
                                    Spacer(modifier = Modifier.width(1.dp))
                                    IconButton(onClick = { count_16++;update10Price();update14Price();update16Price() }) {
                                        Icon(
                                            Icons.Default.KeyboardArrowUp,
                                            contentDescription = null,
                                            modifier = Modifier.size(50.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PizzaCalzoneWishlist(navController: NavController) {

    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    Column {
        Card(
            shape = RoundedCornerShape(16.dp),
            backgroundColor = Mustard_yellow,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            onClick = { navController.navigate("PizzaCalzone") }
        ) {
            Box(
                modifier = Modifier
                    .padding(6.dp)
                    .wrapContentHeight()
                    .background(color = Mustard_yellow_light)
                    .align(Alignment.CenterHorizontally)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.pizza_calzone),
                            contentDescription = "Pizza",
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(200.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Remove from favorites",
                            tint = Color.White,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .size(40.dp)
                                .background(Color.Gray, shape = CircleShape)
                                .padding(5.dp)
                                .clickable(onClick = {
                                    ClassicFrenchFries_Wishlist = 0
                                })
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Column {
                            Text(
                                text = "Pizza Calzone",
                                fontWeight = FontWeight.Bold,
                                fontSize = 30.sp,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "( Size : 10'' , 14'' , 16'' )",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = Color.White,
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                            Spacer(modifier = Modifier.height(10.dp))

                        }
                    }
                }
            }
        }
    }
}
