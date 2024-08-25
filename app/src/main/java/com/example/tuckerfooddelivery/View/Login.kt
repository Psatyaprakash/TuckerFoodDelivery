package com.example.tuckerfooddelivery.View

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.ViewModel.userPhone
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

//Auth

val auth = FirebaseAuth.getInstance()

var storedVerificationId: String? = null
lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

    override fun onVerificationCompleted(credential: PhoneAuthCredential) {
        Log.d(TAG, "onVerificationCompleted:$credential")
    }

    override fun onVerificationFailed(e: FirebaseException) {
        Log.w(TAG, "onVerificationFailed", e)

        if (e is FirebaseAuthInvalidCredentialsException) {
            // Invalid request
        } else if (e is FirebaseTooManyRequestsException) {
            // The SMS quota for the project has been exceeded
        } else if (e is FirebaseAuthMissingActivityForRecaptchaException) {
            // reCAPTCHA verification attempted with null Activity
        }

    }

    override fun onCodeSent(
        verificationId: String,
        token: PhoneAuthProvider.ForceResendingToken,
    ) {
        Log.d(TAG, "onCodeSent:$verificationId")

        // Save verification ID and resending token so we can use them later
        storedVerificationId = verificationId
        resendToken = token
    }
}

fun startPhoneNumberVerification(context: Context , phoneNumber: String) {
    val options = PhoneAuthOptions.newBuilder(auth)
        .setPhoneNumber(phoneNumber) // Phone number to verify
        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
        .setActivity(context as Activity) // Activity (for callback binding)
        .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
        .build()
    PhoneAuthProvider.verifyPhoneNumber(options)
}

fun verifyOTP(context: Context , otp: String) {
    val credential = PhoneAuthProvider.getCredential(storedVerificationId!!, otp)
    signInWithPhoneAuthCredential(context,credential)
}
var check : Int = 0

fun signInWithPhoneAuthCredential(context: Context , credential: PhoneAuthCredential) {

    auth.signInWithCredential(credential)
        .addOnCompleteListener(context as Activity) { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "signInWithCredential:success")
                val user = task.result?.user
                check = 1
            } else {
                // Sign in failed, display a message and update the UI
                Log.w(TAG, "signInWithCredential:failure", task.exception)
                if (task.exception is FirebaseAuthInvalidCredentialsException) {
                    Log.w(TAG,"The verification code entered was invalid")
                }
                // Update UI
                check = 0
            }
        }
}

//AuthEnd

@Composable
fun LoginScreen(navController: NavHostController) {
    val phoneNumber = remember { mutableStateOf("" ) }
    val otp = remember { mutableStateOf("") }

    val context = LocalContext.current

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

                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Enter Phone Number",
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    OutlinedTextField(
                        value = phoneNumber.value,
                        onValueChange = { phoneNumber.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
//                            .background(Color(0xFFF0E68C))
                        ,
                        shape = RoundedCornerShape(14.dp),
                        placeholder = { Text(text = "+91 9876-543-211" , fontSize = 20.sp) },

                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color(0xFFF0E68C),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            textColor = Color.Black
                        )
                    )
                    userPhone = phoneNumber.toString()

                    Spacer(modifier = Modifier.height(30.dp))
                    Button(onClick = { startPhoneNumberVerification(context,phoneNumber.value) },
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Mustard_yellow)),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .width(200.dp)
                            .align(Alignment.CenterHorizontally)
                        ) {
                        Text(text = "Send OTP", fontSize = 20.sp , color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(46.dp))
                    Text(
                        text = "Enter OTP",
                        color = Color.Black,
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    OutlinedTextField(
                        value = otp.value,
                        onValueChange = { otp.value = it },
                        label = { Text(text = "Enter Otp") },
                        modifier = Modifier
                            .fillMaxWidth() ,
                        shape = RoundedCornerShape(10.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color(0xFFF0E68C),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            textColor = Color.Black
                        )
                    )
                    /*
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        repeat(6) {
                            TextField(
                                value = otp.getOrNull(it)?.toString() ?: "",
                                onValueChange = { newValue ->
                                    if (newValue.length <= 1) {
                                        otp =
                                            otp.substring(0, it) + newValue + otp.substring(it + 1)
                                    }
                                },
                                modifier = Modifier
                                    .width(60.dp)
                                    .height(60.dp)
                                    .background(
                                        Color(0xFFF0E68C),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .padding(1.dp)
                                ,
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
                    */
                }

                Spacer(modifier = Modifier.height(50.dp))

                Button(
                    onClick = {
                        verifyOTP(context,otp.value)
                        if(check == 1 ){
                            navController.navigate("HomePage")
                        }
                    },
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Mustard_yellow)),
                    modifier = Modifier
                        .width(250.dp)
                        .padding(20.dp)
                        .height(50.dp)
                        .align(Alignment.CenterHorizontally),
                    shape = RoundedCornerShape(16.dp),


                ) {
                    Text(
                        text = "Verify",
                        color = Color.White,
                        fontSize = 20.sp,
                        lineHeight = 10.sp
                    )
                }
            }
        }
    }
}
