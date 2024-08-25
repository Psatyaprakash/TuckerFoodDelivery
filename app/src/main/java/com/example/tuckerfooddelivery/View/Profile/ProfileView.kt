package com.example.tuckerfooddelivery.View.Profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CleanHands
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
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
import androidx.navigation.NavHostController
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.ViewModel.userBio
import com.example.tuckerfooddelivery.ViewModel.userName
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@SuppressLint("SuspiciousIndentation")
@Composable
fun ProfileView(navController: NavHostController) {
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
        Column(
            modifier = Modifier
                .padding(15.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Row(Modifier
                .padding(5.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween)
            {
               
                CircularButtonWithSymbol {navController.popBackStack()}
                Spacer(modifier = Modifier.width(1.dp))
                Text(
                    text = "Profile",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
                Spacer(modifier = Modifier.width(180.dp))
                TextButton(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.White_Blue)),
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .size(50.dp)
                        .background(colorResource(id = R.color.White_Blue), CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.three_hor_dots),
                        contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth()
            ) {

                Image(
                    painter = painterResource(R.drawable.person),
                    contentDescription = " ",
                    Modifier
                        .size(70.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = userName,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )
                    Text(
                        text = userBio,
                        fontSize = 14.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )

                }

            }
            Spacer(modifier = Modifier.height(20.dp))
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 5.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                   // .size(width = 200.dp, height = 650.dp),
                colors = CardColors(
                    containerColor = colorResource(id = R.color.White_Blue),
                    contentColor = Color.Black,
                    disabledContentColor = Mustard_yellow,
                    disabledContainerColor = Mustard_yellow)
            ) {
                Row(
                    modifier = Modifier.padding(15.dp)
                ) {
                    TextButton(
                        onClick = {navController.navigate("PersonalInfoDetails")},
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .size(35.dp)
                            .background(Color.Transparent, CircleShape)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.per_info),
                            contentDescription = "",
                            modifier = Modifier
                                .size(20.dp),
                            alignment = Alignment.Center
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Personal Info", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(5.dp))
                    Spacer(modifier = Modifier.width(135.dp))
                    TextButton(
                        onClick = {navController.navigate("PersonalInfoDetails")},
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .size(35.dp)
                            .background(Color.Transparent, CircleShape)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.right_arrow),
                            contentDescription = "",
                            modifier = Modifier
                                .size(15.dp),
                            alignment = Alignment.Center
                        )
                    }

                }
                Row(
                    modifier = Modifier.padding(15.dp)
                ) {
                    TextButton(
                        onClick = {navController.navigate("address_screen")},
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .size(35.dp)
                            .background(Color.Transparent, CircleShape)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.add_icon),
                            contentDescription = "",
                            modifier = Modifier
                                .size(20.dp),
                            alignment = Alignment.Center
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Addresses",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(5.dp)
                            .clickable { navController.navigate("address_screen") })
                    Spacer(modifier = Modifier.width(160.dp))
                    TextButton(
                        onClick = {navController.navigate("address_screen")},
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .size(35.dp)
                            .background(Color.Transparent, CircleShape)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.right_arrow),
                            contentDescription = "",
                            modifier = Modifier
                                .size(15.dp),
                            alignment = Alignment.Center
                        )
                    }

                }
                Row(
                    modifier = Modifier.padding(15.dp)
                ) {
                    TextButton(
                        onClick = {navController.navigate("AddToCart")},
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .size(35.dp)
                            .background(Color.Transparent, CircleShape)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.cart_icon),
                            contentDescription = "",
                            modifier = Modifier
                                .size(20.dp),
                            alignment = Alignment.Center
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Cart",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(5.dp)
                            .clickable { navController.navigate("AddToCart") })
                    Spacer(modifier = Modifier.width(220.dp))
                    TextButton(
                        onClick = {navController.navigate("AddToCart")},
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .size(35.dp)
                            .background(Color.Transparent, CircleShape)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.right_arrow),
                            contentDescription = "",
                            modifier = Modifier
                                .size(15.dp),
                            alignment = Alignment.Center
                        )
                    }

                }
                Row(
                    modifier = Modifier.padding(15.dp)
                ) {
                    TextButton(
                        onClick = {navController.navigate("Wishlist")},
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .size(35.dp)
                            .background(Color.Transparent, CircleShape)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.fav_icon),
                            contentDescription = "",
                            modifier = Modifier
                                .size(20.dp),
                            alignment = Alignment.Center
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Favourite",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(5.dp)
                            .clickable { navController.navigate("Wishlist") })
                    Spacer(modifier = Modifier.width(170.dp))
                    TextButton(
                        onClick = {navController.navigate("Wishlist")},
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .size(35.dp)
                            .background(Color.Transparent, CircleShape)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.right_arrow),
                            contentDescription = "",
                            modifier = Modifier
                                .size(15.dp),
                            alignment = Alignment.Center
                        )
                    }

                }
                Row(
                    modifier = Modifier.padding(15.dp)
                ) {
                    TextButton(
                        onClick = {navController.navigate("FAQScreen")},
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .size(35.dp)
                            .background(Color.Transparent, CircleShape)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.faqs_icon),
                            contentDescription = "",
                            modifier = Modifier
                                .size(35.dp),
                            alignment = Alignment.Center
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "FAQs",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(5.dp)
                            .clickable { navController.navigate("FAQScreen")})
                    Spacer(modifier = Modifier.width(210.dp))
                    TextButton(
                        onClick = {navController.navigate("FAQScreen")},
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .size(35.dp)
                            .background(Color.Transparent, CircleShape)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.right_arrow),
                            contentDescription = "",
                            modifier = Modifier
                                .size(15.dp),
                            alignment = Alignment.Center
                        )
                    }

                }
                Row(
                    modifier = Modifier.padding(15.dp)
                        .clickable { navController.navigate("UserReviews") }
                ) {
                    TextButton(
                        onClick = {navController.navigate("UserReviews")},
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .size(35.dp)
                            .background(Color.Transparent, CircleShape)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.user_review_icon),
                            contentDescription = "",
                            modifier = Modifier
                                .size(30.dp),
                            alignment = Alignment.Center
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "User Reviews",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                    Spacer(modifier = Modifier.width(135.dp))
                    TextButton(
                        onClick = {navController.navigate("UserReviews")},
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .size(35.dp)
                            .background(Color.Transparent, CircleShape)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.right_arrow),
                            contentDescription = "",
                            modifier = Modifier
                                .size(15.dp),
                            alignment = Alignment.Center
                        )
                    }

                }
                Row(
                    modifier = Modifier.padding(15.dp)
                        .clickable { navController.navigate("PledgeScreen") }
                ) {
                    TextButton(
                        onClick = {navController.navigate("PledgeScreen")},
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .size(35.dp)
                            .background(Color.Transparent, CircleShape)
                    ) {
                        Image(
                            Icons.Filled.CleanHands,
                            contentDescription = "Donation",
                            modifier = Modifier
                                .size(30.dp),
                            alignment = Alignment.Center
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Take a Pledge",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                    Spacer(modifier = Modifier.width(130.dp))
                    TextButton(
                        onClick = {navController.navigate("PledgeScreen")},
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .size(35.dp)
                            .background(Color.Transparent, CircleShape)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.right_arrow),
                            contentDescription = "",
                            modifier = Modifier
                                .size(15.dp),
                            alignment = Alignment.Center
                        )
                    }

                }
                Row(
                    modifier = Modifier.padding(15.dp)
                ) {
                    TextButton(
                        onClick = {/* navigate to logout */},
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .size(35.dp)
                            .background(Color.Transparent, CircleShape)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.log_out_icon),
                            contentDescription = "",
                            modifier = Modifier
                                .size(20.dp),
                            alignment = Alignment.Center
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Sign Out", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(5.dp))
                    Spacer(modifier = Modifier.width(180.dp))
                    TextButton(
                        onClick = Firebase.auth::signOut,
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .size(35.dp)
                            .background(Color.Transparent, CircleShape)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.right_arrow),
                            contentDescription = "",
                            modifier = Modifier
                                .size(15.dp)
                                .clickable { navController.navigate("Start") },
                            alignment = Alignment.Center
                        )
                    }

                }
            }
        }
    }
