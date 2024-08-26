package com.example.tuckerfooddelivery.View.Profile

import android.annotation.SuppressLint
import android.media.Image
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
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CleanHands
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.outlined.CleanHands
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.House
import androidx.compose.material.icons.outlined.QuestionMark
import androidx.compose.material.icons.outlined.Reviews
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
            Row(
                Modifier
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
                    onClick = {navController.navigate("MainScreen")},
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.White_Blue)),
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .size(50.dp)
                        .background(colorResource(id = R.color.White_Blue), CircleShape)
                ) {
                    Image(
                        Icons.Default.Home,
                        contentDescription = "Home",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
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
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 5.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                colors = CardColors(
                    containerColor = colorResource(id = R.color.White_Blue),
                    contentColor = Color.Black,
                    disabledContentColor = Mustard_yellow,
                    disabledContainerColor = Mustard_yellow)
            ) {
                ProfileItems(navController = navController, icon = Icons.Default.AccountCircle , label = "Personal Info" , route = "PersonalInfoDetails" )
                ProfileItems(navController = navController, icon = Icons.Outlined.House , label = "Address" , route = "AddressScreen" )
                ProfileItems(navController = navController, icon = Icons.Outlined.ShoppingBag , label = "Cart" , route = "AddToCart" )
                ProfileItems(navController = navController, icon = Icons.Outlined.FavoriteBorder , label = "Wishlist" , route = "Wishlist" )
                ProfileItems(navController = navController, icon = Icons.Outlined.QuestionMark , label = "FAQs" , route = "FAQScreen" )
                ProfileItems(navController = navController, icon = Icons.Outlined.Reviews , label = "User Reviews" , route = "UserReviews" )
                ProfileItems(navController = navController, icon = Icons.Outlined.CleanHands , label = "Take a Pledge" , route = "PledgeScreen" )

                Row(
                    modifier = Modifier.padding(15.dp)
                ) {
                    TextButton(
                        onClick = {Firebase.auth::signOut},
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


                }
            }
        }
    }

@Composable
fun ProfileItems(navController: NavHostController , icon : ImageVector , label : String , route : String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row{
            TextButton(
                onClick = { navController.navigate(route) },
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Transparent, CircleShape)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    modifier = Modifier
                        .size(27.dp)
                        .clickable { navController.navigate(route) },
                    tint = Color.Black
                )
            }
            Text(
                text = label ,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(5.dp)
                    .clickable { navController.navigate(route) }
            )
        }
        TextButton(
            onClick = {navController.navigate(route)},
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