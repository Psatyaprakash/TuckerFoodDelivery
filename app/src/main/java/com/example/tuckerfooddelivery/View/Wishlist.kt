package com.example.tuckerfooddelivery.View

//noinspection UsingMaterialAndMaterial3Libraries
import android.content.ContentValues.TAG
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.tuckerfooddelivery.Model.Add.addCart
import com.example.tuckerfooddelivery.Model.Data.Wishlist
import com.example.tuckerfooddelivery.Model.Fetch.db
import com.example.tuckerfooddelivery.Model.Fetch.fetchWishlist
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.View.Profile.CircularButtonWithSymbol
import com.example.tuckerfooddelivery.ViewModel.ScreenHeight
import com.example.tuckerfooddelivery.ViewModel.ScreenWidth
import com.example.tuckerfooddelivery.ViewModel.storageRef

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Wishlist(navController: NavController){
    val wishlist = remember { mutableStateOf<List<Wishlist>>(emptyList()) }
    val isLoading = remember { mutableStateOf(true) }
    val errorMessage = remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Row(
                    Modifier.padding(5.dp, 0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CircularButtonWithSymbol(onClick = { navController.popBackStack() })

                    Spacer(modifier = Modifier.width(1.dp))
                    Text(
                        text = "Wishlist",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            })
        },
        bottomBar = {
            BottomAppBar(
                containerColor = White,
                modifier = Modifier.height(0.08* ScreenHeight)
            ) {
                Row(Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center){
                    Button(
                        onClick =
                        {
                            navController.navigate("AddToCart")
                        },
                        Modifier
                            .fillMaxWidth(.6f),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Mustard_yellow))
                    ) {
                        Text(
                            text = " Go To Cart ",
                            fontWeight = FontWeight.Bold,
                            color = White,
                            fontSize = 22.sp
                        )
                    }
                }
            }
        }
    ) {innerPadding ->

        LaunchedEffect(Unit) {
            try {
                fetchWishlist { wish ->
                    wishlist.value = wish
//                    totalCartPrice = cart.sumOf { it.price * it.count }
                    isLoading.value = false
                }
            } catch (e: Exception) {
                errorMessage.value = "Failed to load Wishlist"
                isLoading.value = false
            }
        }

        Column (
            Modifier.padding(innerPadding)
        ){
            Column(
                Modifier
                    .fillMaxHeight(1f)
                    .padding(16.dp, 10.dp)
            ) {
                LazyColumn {
                    items(wishlist.value) { wish ->
//                        Log.w("Wishlist","$wish")
                        val imagePath = "Cart/${wish.name}.png"
                        WishlistItem(
                            navController = navController,
                            wishlist = wish,
                            onQuantityChange = {   },
                            imagePath = imagePath
                        )
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WishlistItem(navController: NavController, wishlist: Wishlist, onQuantityChange: () -> Unit, imagePath: String ){
    var imageUrl by remember { mutableStateOf<String?>(null) }
    var loadError by remember { mutableStateOf<Exception?>(null) }

    // Fetch the image URL
    LaunchedEffect(imagePath) {
        getImageUrlFromFirebaseStorage(
            imagePath = imagePath,
            onSuccess = { url -> imageUrl = url },
            onFailure = { exception -> loadError = exception },
        )
    }
    val cardwidth = 1 * ScreenWidth
    val boxwidth = 0.3 * ScreenWidth
    val cardheight = 0.18 * ScreenHeight

    if (imageUrl != null) {
//        Log.w("ImagePath", "${storageRef.child(imagePath)} \n$imageUrl")

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .size(height = cardheight, width = cardwidth)
                .wrapContentHeight(),
            elevation = 8.dp,
            backgroundColor = colorResource(id = R.color.Mustard_yellow),
            shape = RoundedCornerShape(15.dp)
        ) {
            Row (verticalAlignment = Alignment.CenterVertically){
                Box(
                    modifier = Modifier
                        .padding(15.dp)
                        .size(boxwidth)
                        .background(White, shape = RoundedCornerShape(15.dp))
                        .fillMaxWidth(.3f)
                ) {
                    if (imageUrl != null) {
                        AsyncImage(
                            model = imageUrl,
                            contentDescription = wishlist.name,
                            Modifier
                                .align(Alignment.Center)
                                .size(100.dp)
                        )
                    } else if (loadError != null) {
                        Text(text = "Failed to load image: ${loadError!!.message}")
                    } else {
                        Row(Modifier.fillMaxWidth() , verticalAlignment = Alignment.CenterVertically){
                            CircularProgressIndicator(modifier = Modifier.padding(2.dp))
                        }
                    }
                }
                Column(
                    Modifier
//                        .fillMaxHeight()
                        .height(140.dp)
                        .padding(10.dp, 5.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {

                    /*Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {*/
                        Text(
                            text = wishlist.name,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "( ${wishlist.size} )",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    //}
                    val price = wishlist.price
                    var count by remember { mutableIntStateOf(wishlist.count) }

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
                                .size(height = 30.dp, width = boxwidth)
                                .background(
                                    White,
                                    shape = RoundedCornerShape(30.dp)
                                ),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            IconButton(onClick = {
                                if (wishlist.count > 1) wishlist.count--
                                count = wishlist.count
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
                                wishlist.count++
                                count = wishlist.count
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
                            Row {
                                val context = LocalContext.current
                            IconButton(onClick = {
//                                if(totalprice == unitPriceHalf)size = "Half" else size = "Full"
                                addCart(wishlist.name,wishlist.price ,wishlist.count,wishlist.size);
                                Toast.makeText(context , "Item added successfully" , Toast.LENGTH_SHORT).show()
                            }) {
                                Icon(
                                    Icons.Default.AddCircleOutline,
                                    contentDescription = "Add",
                                    tint = colorResource(id = R.color.White_Blue)
                                )
                            }
                            IconButton(onClick = {
                                db.collection("Wishlist").document(wishlist.name + "_${wishlist.size}")
                                    .delete()
                                    .addOnSuccessListener {
                                        Log.d(TAG, "DocumentSnapshot successfully deleted!")
                                        Toast.makeText(context , "Item deleted successfully" , Toast.LENGTH_SHORT).show()
                                    }
                                    .addOnFailureListener { e ->
                                        Log.w(TAG, "Error deleting document", e)
                                    };
                                navController.popBackStack();
                                navController.navigate("Wishlist")

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

