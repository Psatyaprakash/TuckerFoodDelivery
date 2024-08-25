package com.example.tuckerfooddelivery.View/*
package com.example.tuckerfooddelivery.View

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tuckerfooddelivery.Model.Data.Cart
import com.example.tuckerfooddelivery.Model.Fetch.db
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.View.Items.getImageUrlFromFirebaseStorage
import com.example.tuckerfooddelivery.ViewModel.storageRef

@Composable
fun CartItem(cart: Cart, onQuantityChange: () -> Unit, imagePath: String  */
/*, onDeleteItem: () -> Unit*//*
) {
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
    Log.w("ImagePath", imagePath)

    if (imageUrl != null) {
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
                    */
/*Image(
                        painter = cart.image,//painterResource(id = R.drawable.bluelagoon),
                        contentDescription = "Blue Lagoon",
                        Modifier
                            .size(90.dp)
                            .align(Alignment.Center)
                    )*/
/*


                    if (imageUrl != null) {
                        AsyncImage(
//                            model = "${storageRef.child(imagePath)}",
                            model = "https://firebasestorage.googleapis.com/v0/b/tuckerfooddelivery.appspot.com/o/Cart%2FBlueLagoon.jpg?alt=media&token=7b3a28ea-6c95-41f8-9b1f-947a6b31c432",
                            contentDescription = "ItemImage",
                            modifier = Modifier
                                .size(90.dp)
                                .align(Alignment.Center)
                        )
                        Log.w("Image Path", "${storageRef.child(imagePath)}")
                    } else if (loadError != null) {
                        Text(text = "Failed to load image: ${loadError!!.message}")
                    } else {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
//                    LoadImageFromFirebase(imageUrl = imageUrl!!)
                }
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(10.dp, 20.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {

                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
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
//                                onDeleteItem()
                                    }
                                    .addOnFailureListener { e ->
                                        Log.w(
                                            TAG,
                                            "Error deleting document",
                                            e
                                        )
                                    };
                            }
                            ) {
                                Icon(
                                    Icons.Default.Delete,
                                    contentDescription = "Delete",
                                    tint = colorResource
                                        (id = R.color.White_Blue)
                                )
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
*/


