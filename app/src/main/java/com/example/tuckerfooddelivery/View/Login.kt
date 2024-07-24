package com.example.tuckerfooddelivery.View

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.tuckerfooddelivery.ui.theme.TuckerFoodDeliveryTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TuckerFoodDeliveryTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen() {
    var phoneNumber by remember { mutableStateOf("+91 9876543210") }
    var otp by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            //.padding(60.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Log In ",
                color = Color.White,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(0.dp, 60.dp, 0.dp, 5.dp)
                    .fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(1.dp))
            Text(
                text = "Please sign in to your existing account",
                color = Color.Gray,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(0.dp, 5.dp, 0.dp, 40.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(50.dp))

//        }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White, shape = RoundedCornerShape(28.dp))
                    .padding(20.dp),

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .padding(16.dp)
                ) {
                    Text(
                        text = "We will send a code to your phone number",
                        color = Color.Black,
                        fontSize = 16.sp,
                       fontWeight = FontWeight.W500
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Enter Phone Number",
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    TextField(
                        value = phoneNumber,
                        onValueChange = { phoneNumber = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFF0E68C), shape = RoundedCornerShape(70.dp)),
                        placeholder = { Text(text = "+91 987654321" ) },

                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color(0xFFF0E68C),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            textColor = Color.Black
                        )

                    )
//                }

                    Spacer(modifier = Modifier.height(46.dp))
                    Text(
                        text = "Enter OTP",
                        color = Color.Black,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        repeat(4) {
                            TextField(
                                value = otp.getOrNull(it)?.toString() ?: "",
                                onValueChange = { newValue ->
                                    if (newValue.length <= 1) {
                                        otp =
                                            otp.substring(0, it) + newValue + otp.substring(it + 1)
                                    }
                                },
                                modifier = Modifier
                                    .width(70.dp)
                                    .background(Color(0xFFF0E68C), shape = RoundedCornerShape(20.dp))
                                    .padding(4.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                singleLine = true,
                                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                                colors = TextFieldDefaults.textFieldColors(
                                    backgroundColor = Color(0xFFF0E68C),
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    textColor = Color.Black
                                )
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(76.dp))

                Button(
                    onClick = { /* Handle verify action */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFD700)),
                    modifier = Modifier
                        .fillMaxWidth()
                        //.width(100.dp)
                        .padding(20.dp)
                        .align(Alignment.CenterHorizontally)

                ) {
                    Text(
                        text = "Verify",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    TuckerFoodDeliveryTheme{
        LoginScreen()
    }
}