package com.example.tuckerfooddelivery.View

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
//import androidx.compose.material.R
import com.example.tuckerfooddelivery.R
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.tuckerfooddelivery.View.Profile.CircularButtonWithSymbol
import com.example.tuckerfooddelivery.ui.theme.TuckerFoodDeliveryTheme



@Composable
fun SaveLocationScreen(navController: NavController) {
    var address by remember { mutableStateOf("3235 Royal Ln. Meso, New Jersey 34567") }
    var street by remember { mutableStateOf("Hasan Nagar") }
    var postCode by remember { mutableStateOf("34567") }
    var apartment by remember { mutableStateOf("345") }
    var label by remember { mutableStateOf("Home") }
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val White_Blue = colorResource(id = R.color.White_Blue)
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            Modifier
                .padding(20.dp, 15.dp, 20.dp, 0.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically)
        {
            CircularButtonWithSymbol {navController.popBackStack()}
            Spacer(modifier = Modifier.width(1.dp))
            androidx.compose.material3.Text(
                text = "Your Address",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp,0.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                Image(painter = painterResource(id = R.drawable.loc_icon),
                    contentDescription = "",
                    Modifier
                        .fillMaxWidth()
                        .size(200.dp)
                        .aspectRatio(1f )
                )

                Text(
                    text = "You’re here",
                    color = Color.Black,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .background(Color.Transparent)
                        .padding(70.dp, 70.dp, 0.dp, 0.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(1.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "ADDRESS",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    TextField(
                        value = address,
                        onValueChange = { address = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(White_Blue, shape = RoundedCornerShape(10.dp)),
                        placeholder = { Text(text = "Address") },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = White_Blue,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            textColor = Color.Black
                        ),
                        leadingIcon = { Icon(Icons.Default.LocationOn, contentDescription = "Location" )}
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "STREET",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    value = street,
                    onValueChange = { street = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(White_Blue, shape = RoundedCornerShape(8.dp)),
                    placeholder = { Text(text = "Street") },
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = White_Blue,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        textColor = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "POST CODE",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    value = postCode,
                    onValueChange = { postCode = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(White_Blue, shape = RoundedCornerShape(8.dp)),
                    placeholder = { Text(text = "Post Code") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = White_Blue,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        textColor = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "APPARTMENT",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = apartment,
                    onValueChange = { apartment = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(White_Blue, shape = RoundedCornerShape(8.dp)),
                    placeholder = { Text(text = "Apartment") },
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = White_Blue,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        textColor = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Label as",
                    color = Color.Black,
                    fontSize = 16.sp
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    RadioButton(
                        selected = label == "Home",
                        onClick = { label = "Home" },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Mustard_yellow,
                            unselectedColor = Color.Gray
                        )
                    )
                    Text(text = "Home", modifier = Modifier.align(Alignment.CenterVertically))

                    RadioButton(
                        selected = label == "Work",
                        onClick = { label = "Work" },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Mustard_yellow,
                            unselectedColor = Color.Gray
                        )
                    )
                    Text(text = "Work", modifier = Modifier.align(Alignment.CenterVertically))

                    RadioButton(
                        selected = label == "Other",
                        onClick = { label = "Other" },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Mustard_yellow,
                            unselectedColor = Color.Gray
                        )
                    )
                    Text(text = "Other", modifier = Modifier.align(Alignment.CenterVertically))
                }
            }

            Button(
                onClick = { /* Handle save action */ },
                colors = ButtonDefaults.buttonColors( Mustard_yellow),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(16.dp, 0.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "Save Location",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
    }
}


// Extension function to convert dp to px
private fun Int.dpToPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()
