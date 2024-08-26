package com.example.tuckerfooddelivery.View

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.tuckerfooddelivery.Model.Data.Cart
import com.example.tuckerfooddelivery.Model.Fetch.db
import com.example.tuckerfooddelivery.Model.Fetch.fetchCart
import com.example.tuckerfooddelivery.R
//import com.example.tuckerfooddelivery.View.Items.ClassicFrenchFriesCart
//import com.example.tuckerfooddelivery.View.Items.PizzaCalzoneCart
import com.example.tuckerfooddelivery.View.Profile.CircularButtonWithSymbol
import com.example.tuckerfooddelivery.ViewModel.ScreenHeight
import com.example.tuckerfooddelivery.ViewModel.ScreenWidth
import com.example.tuckerfooddelivery.ViewModel.platformFee
import com.example.tuckerfooddelivery.ViewModel.storageRef
import com.example.tuckerfooddelivery.ViewModel.totalAmount
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


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
            TopAppBar(
                title =
                {
                    Row(
                        Modifier.padding(5.dp, 0.dp),
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
                        .fillMaxHeight(.85f)
                        .padding(16.dp, 10.dp)
                ) {
                    LazyColumn {
                        items(cartList.value) { cart ->
//                            val fileName = "Restro/Menu/Category/Item/${itemName}.jpg"
//                            val imagRef = storageRef.child(fileName)

                            val imagePath = "Cart/${cart.name}.png"
                            CartItem(
                                navController = navController,
                                cart = cart,
                                onQuantityChange = { totalCartPrice = cartList.value.sumOf { it.price * it.count } },
                                imagePath = imagePath
                            )
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

                    totalAmount = totalCartPrice
                    Text(
                        text = "Item Total : Rs $totalAmount",
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
                                if(totalCartPrice != 0 ) showDialog = true else {
                                    showDialog = false
                                    Toast.makeText(context,"Add Items",Toast.LENGTH_LONG).show()
                                }
                                //showDialog = totalCartPrice != 0  //Same as above code just in short. Isn't it amazing guys ??
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
                                color = White,
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
                                            modifier = Modifier.padding(horizontal = 10.dp),
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
                                            text = "Total Amount : Rs ${totalAmount + platformFee}",
                                            fontWeight = FontWeight.Black,
                                            modifier = Modifier.padding(horizontal = 10.dp),
                                            fontSize = 25.sp
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(30.dp))
                                    Row(
                                        Modifier
                                            .fillMaxWidth()
                                            .padding(20.dp, 0.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Button(onClick = { showDialog = false },
                                            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Mustard_yellow_light))
                                        ) {
                                            Text(
                                                text = "Cancel",
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.W700
                                            )
                                        }
                                        Button(
                                            onClick = {
                                                createNotification(
                                                    context,
                                                    "Order Summary",
                                                    "Order placed \nTotal Amount : ${totalAmount + platformFee}"
                                                )
                                                ; navController.navigate("Congrats")
                                            },
                                            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Mustard_yellow))
                                        ) {
                                            Text(
                                                text = "Buy",
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.W700
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
}

//Retrieve
fun getImageUrlFromFirebaseStorage(imagePath: String, onSuccess: (String) -> Unit, onFailure: (Exception) -> Unit) {
    val storageReference: StorageReference = FirebaseStorage.getInstance().reference.child(imagePath)

    storageReference.downloadUrl
        .addOnSuccessListener { uri ->
            onSuccess(uri.toString()) // Pass the URL to the callback
        }
        .addOnFailureListener { exception ->
            onFailure(exception) // Handle the error
        }
}

@Composable
fun CartItem(navController: NavController, cart: Cart, onQuantityChange: () -> Unit, imagePath: String  /*, onDeleteItem: () -> Unit*/) {
    var imageUrl by remember { mutableStateOf<String?>(null) }
    var loadError by remember { mutableStateOf<Exception?>(null) }
    val context = LocalContext.current
    val price = cart.price
    var count by remember {
        mutableStateOf(cart.count)
    }

    var cardwidth = 1 * ScreenWidth
    var boxwidth = 0.3 * ScreenWidth
    var cardheight = 0.18 * ScreenHeight

    // Fetch the image URL
    LaunchedEffect(imagePath) {
        getImageUrlFromFirebaseStorage(
            imagePath = imagePath,
            onSuccess = { url -> imageUrl = url },
            onFailure = { exception -> loadError = exception },
        )
    }

    if (imageUrl != null) {
        Log.w("ImagePath", "${storageRef.child(imagePath)} \n$imageUrl")

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .size(height = cardheight, width = cardwidth),

            elevation = 8.dp,
            backgroundColor = colorResource(id = R.color.Mustard_yellow),
            shape = RoundedCornerShape(15.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .padding(15.dp)
                        .size(boxwidth)
                        .background(White, shape = RoundedCornerShape(15.dp))
                        .fillMaxWidth(.3f)
//                        .align(Alignment.CenterVertically)
                ) {
                    if (imageUrl != null) {
                        AsyncImage(
                            model = imageUrl,
                            contentDescription = cart.name,
                            Modifier
                                .align(Alignment.Center)
                                .size(100.dp)
                        )
                    } else if (loadError != null) {
                        Text(text = "Failed to load image: ${loadError!!.message}")
                    } else {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
                }
                Column {


                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(0.dp, 15.dp, 10.dp, 10.dp),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.Start
                    ) {
//                    Row(
//                        Modifier.fillMaxWidth(),
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {}
                        Text(
                            text = cart.name,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "( ${cart.size} )",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = "Rs.${price * count}",
                            fontSize = 20.sp
                        )

                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
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
                            Box(modifier = Modifier.padding(1.dp)) {
                                IconButton(onClick = {
                                    db.collection("Cart").document(cart.name + "_${cart.size}")
                                        .delete()
                                        .addOnSuccessListener {
                                            Log.d(TAG, "DocumentSnapshot successfully deleted!")
                                            Toast.makeText(
                                                context,
                                                "Item deleted successfully",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                        .addOnFailureListener { e ->
                                            Log.w(TAG, "Error deleting document", e)
                                        };
                                    navController.popBackStack();
                                    navController.navigate("AddToCart")

                                }) {
                                    Icon(
                                        Icons.Default.Delete,
                                        contentDescription = "Delete",
                                        tint = colorResource(id = R.color.White_Blue)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }



    else if (loadError != null) {
        Text(text = "Failed to load image: ${loadError!!.message}")
    } else {
        CircularProgressIndicator()
    }
    Spacer(modifier = Modifier.height(16.dp))

}




/*@Composable
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
*/