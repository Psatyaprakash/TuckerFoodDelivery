@file:Suppress("UNUSED_EXPRESSION")

package com.example.tuckerfooddelivery.View.Items

import android.content.ContentValues.TAG
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Cancel
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
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.tuckerfooddelivery.Model.Add.addCart
import com.example.tuckerfooddelivery.Model.Data.Cart
import com.example.tuckerfooddelivery.Model.Fetch.db
import com.example.tuckerfooddelivery.Model.Fetch.fetchCart
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.View.Profile.CircularButtonWithSymbol
import com.example.tuckerfooddelivery.View.createNotification
import com.example.tuckerfooddelivery.ViewModel.platformFee
import com.example.tuckerfooddelivery.ViewModel.totalAmount


var BlueLagoon_Cart=0

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
    val Item_Name = "Blue Lagoon"
    var size by remember { mutableStateOf("Half")    }

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
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .background(White)
                    .fillMaxHeight(.8f)
                    .verticalScroll(rememberScrollState())
            ) {

                Card(
                    shape = RoundedCornerShape(16.dp),
                    backgroundColor = Mustard_yellow,
                    modifier = Modifier
                        .padding(20.dp, 10.dp)
                        .fillMaxWidth()
                        .size(300.dp)
//                    .wrapContentHeight(),
                ) {
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
//                        .wrapContentHeight()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bluelagoon),
                            contentDescription = "Mocktail",
                            modifier = Modifier
//                            .padding(100.dp)
                                .align(Alignment.Center)
                                .size(200.dp)
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
                        )
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = Item_Name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(10.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Freshly made Mocktail that is pulpy, tangy and so refreshing.",
                    fontSize = 16.sp,
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
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "INGRIDENTS",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
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
                            addCart(Item_Name,totalprice ,count,size)
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


@Composable
fun AddToCart(navController: NavController) {
    val cartList = remember { mutableStateOf<List<Cart>>(emptyList()) }
    val isLoading = remember { mutableStateOf(true) }
    val errorMessage = remember { mutableStateOf<String?>(null) }
    var totalCartPrice by remember { mutableStateOf(0) }
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.background(White),
        topBar = {
            TopAppBar(title =
            {
                Row(Modifier.padding(5.dp, 0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CircularButtonWithSymbol(onClick = { navController.popBackStack() })

                    Spacer(modifier = Modifier.width(1.dp))
                    Text(
                        text = "Cart",
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
        }
    ) { innerPadding ->

        LaunchedEffect(Unit) {
            try {
                fetchCart { cart ->
                    cartList.value = cart
                    totalCartPrice = cart.sumOf { it.price * it.count }
                    isLoading.value = false
                }
            } catch (e: Exception) {
                errorMessage.value = "Failed to load Cart"
                isLoading.value = false
            }
        }

        if (isLoading.value) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        } else if (errorMessage.value != null) {
            Text(
                text = errorMessage.value!!,
                color = Color.Red,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Column(
                    Modifier
                        .fillMaxHeight(.80f)
                        .padding(16.dp, 10.dp)
                ) {
                    LazyColumn {
                        items(cartList.value) { cart ->
                            CartItem(cart = cart, onQuantityChange = {
                                totalCartPrice = cartList.value.sumOf { it.price * it.count }
                            })
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .background(colorResource(id = R.color.White_Blue))
                        .fillMaxWidth()
                        .padding(0.dp, 15.dp, 0.dp, 0.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {

                    Text(
                        text = "Item Total : Rs $totalCartPrice",
                        fontWeight = FontWeight.Black,
                        modifier = Modifier.padding(horizontal = 30.dp),
                        fontSize = 25.sp
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        var showDialog by remember { mutableStateOf(false) }
                        TextButton(
                            onClick = {
                                showDialog = true
                              },
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.Mustard_yellow)),
                            border = BorderStroke(width = 0.dp, color = Color.Transparent),
                            elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                            modifier = Modifier
                                .padding(horizontal = 20.dp, vertical = 15.dp)
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
                        if (showDialog) {
                            Dialog(onDismissRequest = { showDialog = false }) {
                                // Dialog content
                                Column(
                                    modifier = Modifier
                                        .background(
                                            colorResource(id = R.color.White_Blue),
                                            shape = RoundedCornerShape(15.dp)
                                        )
                                        .padding(20.dp)
                                        .fillMaxWidth()
                                        .size(300.dp),
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
                                            text = "Total Amount : Rs ${totalAmount + totalCartPrice + platformFee}",
                                            fontWeight = FontWeight.Black,
                                            modifier = Modifier.padding( horizontal = 10.dp),
                                            fontSize = 25.sp
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(30.dp))
                                    Row (
                                        Modifier
                                            .fillMaxWidth()
                                            .padding(20.dp, 0.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ){
                                        Button(onClick = { showDialog = false } ,
                                            colors = ButtonDefaults.buttonColors( colorResource(id = R.color.Mustard_yellow_light) )
                                        ) {
                                            Text(text = "Cancel", fontSize = 20.sp , fontWeight = FontWeight.W700)
                                        }
                                        Button(onClick = {
                                            createNotification(context, "Order Summary" , "Order placed \nTotal Amount : ${totalAmount + totalCartPrice}")
                                        ; navController.navigate("Mainscreen")
                                                         },colors = ButtonDefaults.buttonColors( colorResource(id = R.color.Mustard_yellow) )
                                        ) {
                                            Text(text = "Buy", fontSize = 20.sp , fontWeight = FontWeight.W700)
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
}



@Composable
fun CartItem(cart: Cart, onQuantityChange: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .size(150.dp),
        elevation = 8.dp,
        backgroundColor = colorResource(id = R.color.Mustard_yellow),
        shape = RoundedCornerShape(15.dp)
    ) {
        Row {
            Box(
                modifier = Modifier
                    .padding(15.dp)
                    .size(130.dp)
                    .background(White, shape = RoundedCornerShape(15.dp))
                    .fillMaxWidth(.3f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bluelagoon),
                    contentDescription = "Blue Lagoon",
                    Modifier
                        .size(90.dp)
                        .align(Alignment.Center)
                )
            }
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(10.dp, 20.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {

                Row( Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text = cart.name,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "( ${cart.size} )",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                val price = cart.price
                var count by remember {
                    mutableStateOf(cart.count)
                }
                Text(
                    text = "Rs.${price * count}",
                    fontSize = 20.sp
                )
                Row(Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Row(
                        modifier = Modifier
                            .size(height = 30.dp, width = 150.dp)
                            .background(
                                White,
                                shape = RoundedCornerShape(30.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(onClick = {
                            if (cart.count > 1) cart.count--
                            count = cart.count
                            onQuantityChange()
                        }) {
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

                        IconButton(onClick = {
                            cart.count++
                            count = cart.count
                            onQuantityChange()
                        }) {
                            Icon(
                                Icons.Default.KeyboardArrowUp,
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                    Box(modifier = Modifier.padding(1.dp)){
                        IconButton(onClick = {
                            db.collection("Cart").document(cart.name+"_${cart.size}")
                            .delete()
                            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully deleted!") }
                            .addOnFailureListener { e -> Log.w(TAG, "Error deleting document", e) };

                        }
                        ) {
                            Icon( Icons.Default.Delete ,
                                contentDescription = "Delete",
                                tint = colorResource
                                    (id = R.color.White_Blue))
                        }
                    }

                }
            }
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}


/*


                Spacer(modifier = Modifier.height(20.dp))
**/
