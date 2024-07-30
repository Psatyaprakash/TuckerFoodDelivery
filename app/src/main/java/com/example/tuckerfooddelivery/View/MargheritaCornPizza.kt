package com.example.tuckerfooddelivery.View

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
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardColors
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

var MargheritaCornPizza_Cart=0
@Composable
fun MargheritaCornPizza(navController: NavController) {

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


    Column {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .size(width = 500.dp, height = 655.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                TextButton(
                    onClick = {navController.navigate("Pizza_Category")},
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
                        painter = painterResource(id = R.drawable.margherita_corn_pizza),
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
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Margherita Corn Pizza",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(10.dp)
            )
            Spacer(modifier = Modifier.height(13.dp))
            Text(
                text = "Pizza topped with herb-infused signature pan sauce and 100% mozzarella cheese.",
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
                    onClick = { onButtonClick(1) ; price = 199 },
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
                    onClick = { onButtonClick(2); price = 239  },
                    colors = ButtonDefaults.textButtonColors(getButtonColor(2)),
                    modifier = Modifier
                        .size(60.dp),
                    shape = CircleShape
                ) {
                    Text(text = "14''", fontSize = 25.sp)
                }

                Spacer(modifier = Modifier.width(30.dp))
                TextButton(
                    onClick = { onButtonClick(3) ; price = 259 },
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
                //Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cheese),
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
                        painter = painterResource(id = R.drawable.tomato_),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                //Spacer(modifier = Modifier.width(20.dp))
            }
            Spacer(modifier = Modifier.height(75.dp))
            Card(
                //for scrolling purpose
                shape = RoundedCornerShape(16.dp),
                backgroundColor = Mustard_yellow,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
//            colors = CardColors(
//                containerColor = Mustard_yellow_light, contentColor = Color.Black,
//                disabledContentColor = Mustard_yellow,
//                disabledContainerColor = Mustard_yellow
//            )
            ) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.margherita_corn_pizza),
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
                    )
                }
            }

        }
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .size(height = 350.dp, width = 700.dp)
        ) {
            Row(
                modifier = Modifier.padding(10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Rs. ${price * count}",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(20.dp),
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.width(150.dp))
                Box(
                    modifier = Modifier
                        .size(height = 50.dp, width = 150.dp)
                        .background(color = Mustard_yellow, shape = CircleShape)
                        .align(Alignment.CenterVertically)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        IconButton(onClick = { /* TODO: Add action for microphone */ }) {
                            Icon(
                                Icons.Default.KeyboardArrowDown,
                                contentDescription = null,
                                modifier = Modifier.size(50.dp)
                                    .clickable { if (count == 1) count = 1 else count-- }
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
//                        var count = 0
                        Text(
                            text = "$count", modifier = Modifier
                                .padding(vertical = 15.dp)
                                .padding(horizontal = 15.dp),
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.width(1.dp))
                        IconButton(onClick = { /* TODO: Add action for microphone */ }) {
                            Icon(
                                Icons.Default.KeyboardArrowUp,
                                contentDescription = null,
                                modifier = Modifier.size(50.dp)
                                    .clickable { count++ }
                            )
                        }
                    }
                }

            }
            TextButton(
                onClick = { /*TODO*/ },
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
                    text = "ADD TO CART",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}

@Composable
fun MargheritaCornPizza_Cart()
{
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    var unitprice: Int by remember {
        mutableStateOf<Int>(35)
    }
    var totalprice: Int by remember {
        mutableStateOf<Int>(35)
    }
    var count by remember {
        mutableStateOf<Int>(1)
    }

    fun Increment() {
        if (count < 100) {
            count = count + 1
            totalprice = unitprice * count
        }
    }

    fun Decrement() {
        if (count > 1) {
            count = count - 1
            totalprice = unitprice * count
        }
    }

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
                        .size(100.dp)
                        .wrapContentHeight(),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.margherita_corn_pizza),
                        contentDescription = "margherita_corn_pizza",
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
                        text = "Margherita Corn Pizza",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )

                    Text(
                        text = "PRICE : Rs $totalprice",
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
                            IconButton(onClick = { Decrement() }) {
                                Icon(
                                    Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "$count", modifier = Modifier
                                    .padding(vertical = 5.dp)
                                    .padding(horizontal = 15.dp),
                                fontSize = 20.sp
                            )
                            Spacer(modifier = Modifier.width(1.dp))
                            IconButton(onClick = { Increment() }) {
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
