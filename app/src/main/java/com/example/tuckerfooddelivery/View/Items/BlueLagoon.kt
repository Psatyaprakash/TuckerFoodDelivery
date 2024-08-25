package com.example.tuckerfooddelivery.View.Items

import android.content.ContentValues.TAG
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.tuckerfooddelivery.Model.Add.addCart
import com.example.tuckerfooddelivery.Model.Add.addWishlist
import com.example.tuckerfooddelivery.Model.Data.Cart
import com.example.tuckerfooddelivery.Model.Fetch.db
import com.example.tuckerfooddelivery.Model.Fetch.fetchCart
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.View.Profile.CircularButtonWithSymbol
import com.example.tuckerfooddelivery.View.createNotification
import com.example.tuckerfooddelivery.ViewModel.platformFee
import com.example.tuckerfooddelivery.ViewModel.storageRef
import com.example.tuckerfooddelivery.ViewModel.totalAmount
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BlueLagoon(navController: NavController){
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    val White_Blue = colorResource(id = R.color.White_Blue)

    var totalprice: Int by remember { mutableStateOf(59) }
    var unitPriceHalf: Int by remember { mutableStateOf(59) }
    var unitPriceFull: Int by remember { mutableStateOf(109) }
    var count by remember { mutableStateOf(1) }
    val Name = "Blue Lagoon"
    val Item_Name = "BlueLagoon"
    var size by remember { mutableStateOf("Half")    }
    val context = LocalContext.current

    var selectedButtonIndex by remember { mutableStateOf(1) }

    fun getButtonColor(index: Int): Color {
        return if (index == selectedButtonIndex) Mustard_yellow else White_Blue
    }

    fun onButtonClick(index: Int) {
        selectedButtonIndex = index
    }

    Scaffold(
        modifier = Modifier.background(White),
        topBar = {
            TopAppBar(title =
            {
                Row(Modifier.padding(5.dp,0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CircularButtonWithSymbol(onClick = { navController.popBackStack() })

                    Spacer(modifier = Modifier.width(1.dp))
                    Text(
                        text = "Details",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            },
                backgroundColor = White,
                modifier = Modifier
                    .height(80.dp)
            )
        },

    ) { innerPadding ->
        var iP = innerPadding
        Column(
            Modifier
                .fillMaxSize()
                .padding(0.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .background(White)
                    .fillMaxHeight(.9f)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(70.dp))
                Card(
                    shape = RoundedCornerShape(16.dp),
                    backgroundColor = Mustard_yellow,
                    modifier = Modifier
                        .padding(20.dp, 10.dp)
                        .fillMaxWidth()
                        //.size(300.dp)
                        .wrapContentHeight()
                ) {
                    Box(
                        modifier = Modifier
                            .padding(30.dp)
                            .fillMaxWidth()
//                        .wrapContentHeight()
                    ) {
                       Image(
                            painter = painterResource(id = R.drawable.bluelagoon),
                            contentDescription = "Mocktail",
                            modifier = Modifier
//                            .padding(100.dp)
                                .align(Alignment.Center)
                                .size(270.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Add",
                            tint = White,
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .size(40.dp)
                                .background(Color.Red, shape = CircleShape)
                                .padding(8.dp)
                                .clickable {
                                    if(totalprice == unitPriceHalf)size = "Half" else size = "Full"
                                    addWishlist(Item_Name,totalprice ,count,size)
                                }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = Item_Name,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Freshly made Mocktail that is pulpy, tangy and so refreshing.",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.star__),
                        contentDescription = "Pizza",
                        modifier = Modifier
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
                    Text(
                        text = "SIZE:",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                    TextButton(
                        onClick = {
                            onButtonClick(1); totalprice = unitPriceHalf
                        }, //unitprice of half mocktail is Rs 112
                        colors = ButtonDefaults.textButtonColors(
                            getButtonColor(1)
                        ),
                        modifier = Modifier
                            .size(height = 50.dp, width = 100.dp),
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Text(text = "Half", fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.width(30.dp))
                    TextButton(
                        onClick = {
                            onButtonClick(2); totalprice = unitPriceFull
                        }, //unit price of full is Rs 173
                        colors = ButtonDefaults.textButtonColors(
                            getButtonColor(2)
                        ),
                        modifier = Modifier
                            .size(height = 50.dp, width = 100.dp),
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Text(text = "Full", fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                }
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "INGRIDENTS",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
                Spacer(modifier = Modifier.height(25.dp))
                Row(
                    modifier = Modifier
                        .padding(horizontal = 0.dp)
                        .fillMaxWidth(),
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
                            painter = painterResource(id = R.drawable.lemon_icon),
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
                }

            }
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
                            if(totalprice == unitPriceHalf)size = "Half" else size = "Full"
                            addCart(Item_Name,totalprice ,count,size);
                            Toast.makeText(context , "Item added successfully" , Toast.LENGTH_SHORT).show()
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
}



