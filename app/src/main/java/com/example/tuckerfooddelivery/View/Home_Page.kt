package com.example.tuckerfooddelivery.View

//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.ViewModel.userPrimaryAddress
import com.example.tuckerfooddelivery.ui.theme.PurpleGrey80
import java.time.LocalTime
import java.time.format.DateTimeFormatter


//Home Page UI
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavController ) {

    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)

    var time by remember { mutableStateOf("") }
    val currentTime = LocalTime.now()
// Format the date to a readable string
    val formatter = DateTimeFormatter.ofPattern("HH")
    val formattedTime = currentTime.format(formatter)

    time = if( formattedTime.toInt() < 12) "Good Morning"
    else if (formattedTime.toInt() < 17 ) "Good Afternoon"
    else if ( formattedTime.toInt() < 24 ) "Good Evening"
    else ""

    Column(modifier = Modifier
        .fillMaxSize()
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp, 10.dp, 20.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape)
                    .background(color = colorResource(id = R.color.White_Blue))
            ) {
                Image(
                    Icons.Default.Person,
                    contentDescription = "Profile ",
                    Modifier
                        .size(30.dp)
                        .align(Alignment.Center)
                        .clickable { navController.navigate("ProfileView") }
                )
            }
            Column(Modifier.padding(0.dp,2.dp)) {
                Text(
                    text = "DELIVER TO",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )
                Text(
                    text = userPrimaryAddress,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    softWrap = true
                )
            }

            Box(
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape)
                    .background(color = colorResource(id = R.color.White_Blue))


            ) {
                Image(
                    Icons.Default.Favorite,
                    contentDescription = "Fire",
                    Modifier
                        .size(27.dp)
                        .align(Alignment.Center)
                        .clickable { navController.navigate("Wishlist") }
                )
            }
        }

        Box(
            modifier = Modifier
                .background(White)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp, 0.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                //Row
                Spacer(modifier = Modifier.height(15.dp))
                Row {
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(text = "Hello , ", fontSize = 15.sp, color = Color.Black)
                    Text(
                        text = "$time !",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                var searchQuery by remember { mutableStateOf("") }

                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    placeholder = { Text("Search dishes, restaurants", color = Color.Black) },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = { /* TODO: Add action for microphone */ }) {
                            Icon(Icons.Default.Settings, contentDescription = null, tint = Color.Black)
                        }
                    },
                    colors = TextFieldDefaults.textFieldColors(containerColor = colorResource(id = R.color.White_Blue)),
                    shape = RoundedCornerShape(20.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(2.dp, 0.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "All Categories ",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.W500,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )

                    Text(
                        text = "See all >",
                        fontSize = 18.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                ) {
                    //Button1
                    Button(
                        onClick = { /* TODO: Insert action here */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Mustard_yellow),
                        border = BorderStroke(width = 0.dp, color = Color.Transparent),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(White)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.fire),
                                contentDescription = "Fire",
                                Modifier
                                    .size(30.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "All",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 18.sp
                            )
                        }
                    }

                    //Button2
                    Button(
                        onClick = { navController.navigate("Mocktails_Category") },
                        colors = ButtonDefaults.buttonColors(containerColor = White),
                        border = BorderStroke(width = 0.dp, color = Color.Transparent),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.orange_mimosa),
                                contentDescription = "Mocktail Icon",
                                Modifier
                                    .size(27.dp)
                                    .align(Alignment.Center)

                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "Mocktail",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 18.sp
                            )
                        }
                    }

                    //Button 3
                    Button(
                        onClick = { navController.navigate("Burger_Category") },
                        colors = ButtonDefaults.buttonColors(containerColor = White),
                        border = BorderStroke(width = 0.dp, color = Color.Transparent),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.burger_icon),
                                contentDescription = "Burger Icon",
                                Modifier
                                    .size(27.dp)
                                    .align(Alignment.Center)

                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "Burger",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 18.sp
                            )
                        }
                    }

                    //Button 4
                    Button(
                        onClick = { navController.navigate("Pizza_Category") },
                        colors = ButtonDefaults.buttonColors(containerColor = White),
                        border = BorderStroke(width = 0.dp, color = Color.Transparent),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.pizza),
                                contentDescription = "Pizza Icon",
                                Modifier
                                    .size(27.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "Pizza",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 18.sp
                            )
                        }
                    }


                    Button(
                        onClick = { navController.navigate("Momos_Category") },
                        colors = ButtonDefaults.buttonColors(containerColor = White),
                        border = BorderStroke(width = 0.dp, color = Color.Transparent),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.tibetianmomos),
                                contentDescription = "Momos Icon",
                                Modifier
                                    .size(27.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "Momos",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 18.sp
                            )
                        }
                    }

                    Button(
                        onClick = { navController.navigate("Roll_Category") },
                        colors = ButtonDefaults.buttonColors(containerColor = White),
                        border = BorderStroke(width = 0.dp, color = Color.Transparent),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.paneer_roll),
                                contentDescription = "Roll Icon",
                                Modifier
                                    .size(27.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "Roll",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 18.sp
                            )
                        }
                    }
                    Button(
                        onClick = { navController.navigate("Wings_Category") },
                        colors = ButtonDefaults.buttonColors(containerColor = White),
                        border = BorderStroke(width = 0.dp, color = Color.Transparent),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.buffalo_wings),
                                contentDescription = "Wings Icon",
                                Modifier
                                    .size(27.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "Wings",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 18.sp
                            )
                        }
                    }
                    Button(
                        onClick = { navController.navigate("Fries_Category") },
                        colors = ButtonDefaults.buttonColors(containerColor = White),
                        border = BorderStroke(width = 0.dp, color = Color.Transparent),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.peri_peri_fries),
                                contentDescription = "Fries Icon",
                                Modifier
                                    .size(27.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "Fries",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 18.sp
                            )
                        }
                    }
                    Button(
                        onClick = { navController.navigate("Starters_Category") },
                        colors = ButtonDefaults.buttonColors(containerColor = White),
                        border = BorderStroke(width = 0.dp, color = Color.Transparent),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.american_corn),
                                contentDescription = "Starter Icon",
                                Modifier
                                    .size(27.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "Starters",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 18.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()
                    ,verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                    Text(
                        text = "Open Restaurants ",
                        fontSize = 15.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.W500,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )

                    Text(
                        text = "See all >",
                        fontSize = 15.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))

                //Card for Restaurant 1
                Card(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth()
                        .size(width = 400.dp, height = 225.dp)
                        .wrapContentHeight(),
                    colors = CardColors(
                        containerColor = Mustard_yellow_light,
                        contentColor = Color.Black,
                        disabledContentColor = Mustard_yellow,
                        disabledContainerColor = Mustard_yellow
                    ),
                    onClick = { navController.navigate("Rosegardenrestaurant_landingpage") }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.restaurant_img_1),
                        contentDescription = "Restaurant image 1",
                        modifier = Modifier
                            .align(Alignment.Start)
                            .size(359.dp)
                    )
                }
                Spacer(
                    modifier = Modifier
                        .height(25.dp)
                        .width(10.dp)
                )
                Text(
                    text = "Rose Garden Restaurant",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
                Text(
                    text = "Burger - Chicken - Rice - Wings ",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.star__),
                        contentDescription = "Pizza",
                        modifier = Modifier
                            //.align(Alignment.Top)
                            .size(20.dp)
                            .padding(0.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))

                    androidx.compose.material.Text(
                        text = "4.7",
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    Image(
                        painter = painterResource(id = R.drawable.truck__),
                        contentDescription = "Pizza",
                        modifier = Modifier
                            .size(25.dp)
                            .padding(0.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    androidx.compose.material.Text(
                        text = "Free",
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )

                    Spacer(modifier = Modifier.width(40.dp))
                    Image(
                        painter = painterResource(id = R.drawable.clock__),
                        contentDescription = "Pizza",
                        modifier = Modifier
                            .size(25.dp)
                            .padding(0.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    androidx.compose.material.Text(
                        text = "20 min",
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))

                //Restaurant2 card
                Card(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth()
                        .size(width = 400.dp, height = 225.dp)
                        .wrapContentHeight(),
                    colors = CardColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black,
                        disabledContentColor = Mustard_yellow,
                        disabledContainerColor = Mustard_yellow
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .wrapContentHeight()
                            .size(height = 400.dp, width = 600.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.Transparent)
                            .clickable { navController.navigate("Fionah_landingpage") },
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.group_598),
                            contentDescription = "Restaurant 2 image",
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .size(4009.dp),
                            )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(25.dp)
                        .width(10.dp)
                )
                Text(
                    text = "Fionah Restrauant",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                Text(
                    text = "Pasta - Fish - Rice - Crabs ",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.star__),
                        contentDescription = "Pizza",
                        modifier = Modifier
                            .size(20.dp)
                            .padding(0.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = "4.2",
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    Image(
                        painter = painterResource(id = R.drawable.truck__),
                        contentDescription = "Pizza",
                        modifier = Modifier
                            .size(25.dp)
                            .padding(0.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Free",
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )

                    Spacer(modifier = Modifier.width(40.dp))
                    Image(
                        painter = painterResource(id = R.drawable.clock__),
                        contentDescription = "Pizza",
                        modifier = Modifier
                            .size(25.dp)
                            .padding(0.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    androidx.compose.material.Text(
                        text = "40 min",
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

                //Card for Restaurant 3
                Card(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth()
                        .size(width = 400.dp, height = 200.dp)
                        .wrapContentHeight(),
                    colors = CardColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black,
                        disabledContentColor = Mustard_yellow,
                        disabledContainerColor = Mustard_yellow
                    ),
                    onClick = { navController.navigate("SkyHighW_landingpage") }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.restaurant_img_3),
                        contentDescription = "Pizza",
                        modifier = Modifier
                            .align(Alignment.Start)
                            .size(470.dp)
                    )
                }
                Spacer(
                    modifier = Modifier
                        .height(25.dp)
                        .width(10.dp)
                )
                Text(
                    text = "SkyHigh Way",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Text(
                    text = "Burger - Fries - Chicken - Wings ",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.star__),
                        contentDescription = "Pizza",
                        modifier = Modifier
                            //.align(Alignment.Top)
                            .size(20.dp)
                            .padding(0.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))

                    androidx.compose.material.Text(
                        text = "4.7",
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    Image(
                        painter = painterResource(id = R.drawable.truck__),
                        contentDescription = "Pizza",
                        modifier = Modifier
                            .size(25.dp)
                            .padding(0.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    androidx.compose.material.Text(
                        text = "Free",
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )

                    Spacer(modifier = Modifier.width(40.dp))
                    Image(
                        painter = painterResource(id = R.drawable.clock__),
                        contentDescription = "Pizza",
                        modifier = Modifier
                            .size(25.dp)
                            .padding(0.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    androidx.compose.material.Text(
                        text = "20 min",
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}
