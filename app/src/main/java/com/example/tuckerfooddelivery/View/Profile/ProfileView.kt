package com.example.tuckerfooddelivery.View.Profile

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Button
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

@SuppressLint("SuspiciousIndentation")
@Composable
fun ProfileView(navController: NavHostController) {
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
        Column(
            modifier = Modifier
                .padding(15.dp)
                //.size(width = 500.dp, height = 655.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                TextButton(
                    onClick = {navController.navigate("HomePage")},
                    colors = ButtonDefaults.buttonColors(Color.LightGray),
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Gray, CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.leftarrow_icon),
                        contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(1.dp))
                Text(
                    text = "Profile",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
                Spacer(modifier = Modifier.width(180.dp))
                TextButton(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(Color.LightGray),
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .size(55.dp)
                        .background(Color.Gray, CircleShape)
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
                        .size(100.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Column(
                    modifier = Modifier.padding(10.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = "Vishal Khadok",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )
                    Text(
                        text = "I love fast food",
                        fontSize = 18.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )

                }

            }
            Spacer(modifier = Modifier.height(25.dp))
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth()
                    .size(width = 200.dp, height = 465.dp),
                colors = CardColors(containerColor = Color.LightGray,
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
                                .size(22.dp),
                            alignment = Alignment.Center
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Personal Info", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(5.dp))
                    Spacer(modifier = Modifier.width(132.dp))
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
                        onClick = {/* navigate to addresses */},
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
                                .size(25.dp),
                            alignment = Alignment.Center
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Addresses", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(5.dp))
                    Spacer(modifier = Modifier.width(160.dp))
                    TextButton(
                        onClick = {/* navigate to addresses */},
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
                        onClick = {navController.navigate("Cart")},
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
                                .size(25.dp),
                            alignment = Alignment.Center
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Cart", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier
                        .clickable { navController.navigate("Cart") }
                        .padding(5.dp))
                    Spacer(modifier = Modifier.width(220.dp))
                    TextButton(
                        onClick = {navController.navigate("Cart")},
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
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth()
                        .align(Alignment.End),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                )
                {
                        TextButton(
                            onClick = { navController.navigate("Favorites") },
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
                                    .size(25.dp),
                                alignment = Alignment.Center
                            )
                        }
                        //
                        TextButton(
                            onClick = { navController.navigate("Favorites") },
                            colors = ButtonDefaults.buttonColors(Color.Transparent),
                            shape = CircleShape,
                            contentPadding = PaddingValues(0.dp),
                            modifier = Modifier
                                .size(width = 105.dp, height = 30.dp)
                                .background(Color.Transparent, CircleShape)

                        ) {
                            Text(
                                text = "Favorites",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                modifier = Modifier.padding(5.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(168.dp))
                        TextButton(
                            onClick = { navController.navigate("Favorites") },
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
                                //alignment = Alignment.CenterEnd
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
                                .size(35.dp)
                                .clickable {navController.navigate("FAQScreen") },
                            alignment = Alignment.Center
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "FAQs", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier
                        .clickable { navController.navigate("FAQScreen") }
                        .padding(5.dp))
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
                                .size(27.dp),
                            alignment = Alignment.Center
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "User Reviews", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(5.dp))
                    Spacer(modifier = Modifier.width(132.dp))
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
                                .size(25.dp),
                            alignment = Alignment.Center
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Log Out", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(5.dp))
                    Spacer(modifier = Modifier.width(187.dp))
                    TextButton(
                        onClick = {/* navigate to logout */},
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
            }
        }
    }
