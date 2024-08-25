package com.example.tuckerfooddelivery.View.Restaurant_Pages


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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.ViewModel.userName


//Home Page UI

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun RestaurantHomePage(navController: NavController) {
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val White_Blue = colorResource(id = R.color.White_Blue)


    Column{
        Row(Modifier.padding(20.dp,10.dp,10.dp,0.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = { navController.navigate("ProfileView") },
                colors = ButtonDefaults.buttonColors(containerColor = White_Blue),
                border = BorderStroke(width = 0.dp, color = Color.Transparent),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.menu),
                    contentDescription = "3 bars",
                    Modifier
                        .size(22.dp)
                )
            }

            Spacer(modifier = Modifier.width(20.dp))
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = userName,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )
                Text(
                    text = "Rose Garden Restaurant ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxHeight(0.99f)
                .verticalScroll(rememberScrollState())
        ) {

            Row {
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = "Hey , ", fontSize = 15.sp, color = Color.Black)
                Text(
                    text = "Good Afternoon!",
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
                placeholder = { Text("Search Order Id, Items ...  ", color = Color.Black) },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = null,
                        tint = Color.Black
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { /* TODO: Add action for settings */ }) {
                        Icon(Icons.Default.Settings, contentDescription = null, tint = Color.Black)
                    }
                },
//            colors = TextFieldDefaults.textFieldColors(
//                focusedIndicatorColor = colorResource(id = R.color.Blue_Slight),
//                unfocusedIndicatorColor = colorResource(id = R.color.Blue_Slight)
//            )
                colors = TextFieldDefaults.textFieldColors(containerColor = White_Blue),
                shape = RoundedCornerShape(20.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = " Status ",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Text(
                    text = "Change Timings >",
                    fontSize = 18.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .clickable { /*Navigate to Page containing Timings*/
                            navController.navigate("Timing")
                        }
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                var selectedButtonIndex by remember { mutableStateOf(1) }
                fun getButtonColor(index: Int): Color {
                    return if (index == selectedButtonIndex) Mustard_yellow else White_Blue
                }
                fun onButtonClick(index: Int) {
                    selectedButtonIndex = index
                }

                //Button for Open
                Button(
                    onClick = { onButtonClick(1) },
                    colors = ButtonDefaults.textButtonColors(getButtonColor(1)),
                    border = BorderStroke(width = 0.dp, color = Color.Transparent),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(Color.White)
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
                            text = " Open ",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 18.sp
                        )
                    }
                }

                //Button for closed
                Button(
                    onClick = { onButtonClick(2) },
                    colors = ButtonDefaults.textButtonColors(getButtonColor(2)),
                    border = BorderStroke(width = 0.dp, color = Color.Transparent),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    ) {
                        Image(
                            Icons.Default.Settings,
                            contentDescription = "Closed Icon",

                            Modifier
                                .size(27.dp)
                                .align(Alignment.Center)
                                .clickable { }

                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = " Closed ",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 18.sp
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.height(5.dp))
            Row(Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = " Active Orders ",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )

                TextButton(onClick = { navController.navigate("PreparedOrderScreen") }) {
                    Text(
                        text = "See all >",
                        fontSize = 18.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.elevatedCardElevation(4.dp),
                colors = CardDefaults.cardColors(White_Blue)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Order of Classic french fries placed by xyz myu",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Address: 12-J, Sector 5, Kanpur Nagar, Uttar Pradesh, India"
                    )
                    Text(
                        text = "Date: 2024-08-25 05:35:42"
                    )
                    Text(
                        text = "Order ID: 74734787345"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color(0xFFD4AF37)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "ACCEPT")
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color(0xFFD4AF37)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "DECLINE")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.elevatedCardElevation(4.dp),
                colors = CardDefaults.cardColors(White_Blue)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Order of Spicy Chicken Wings placed by abc xyz",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Address: 45-B, Sector 3, Lucknow, Uttar Pradesh, India"
                    )
                    Text(
                        text = "Date: 2024-08-26 09:12:23"
                    )
                    Text(
                        text = "Order ID: 84723987234"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color(0xFFD4AF37)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "ACCEPT")
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color(0xFFD4AF37)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "DECLINE")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.elevatedCardElevation(4.dp),
                colors = CardDefaults.cardColors(White_Blue)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Order of Grilled Paneer Sandwich placed by pqr jkl",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Address: 78-C, Sector 12, Delhi, India"
                    )
                    Text(
                        text = "Date: 2024-08-27 11:45:00"
                    )
                    Text(
                        text = "Order ID: 94723892348"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color(0xFFD4AF37)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "ACCEPT")
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color(0xFFD4AF37)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "DECLINE")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.elevatedCardElevation(4.dp),
                colors = CardDefaults.cardColors(White_Blue)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Order of Veggie Delight Pizza placed by uvw mno",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Address: 22-A, Sector 9, Ghaziabad, Uttar Pradesh, India"
                    )
                    Text(
                        text = "Date: 2024-08-28 14:30:15"
                    )
                    Text(
                        text = "Order ID: 74832974832"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color(0xFFD4AF37)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "ACCEPT")
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color(0xFFD4AF37)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "DECLINE")
                        }
                    }
                }
            }


        }
    }
}

