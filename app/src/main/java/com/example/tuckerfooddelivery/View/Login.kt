package com.example.tuckerfooddelivery.View

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.ViewModel.loggedInAs
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
var errorCount = 0

var storedVerificationId: String? = null
lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

    override fun onVerificationCompleted(credential: PhoneAuthCredential) {
        Log.d(TAG, "onVerificationCompleted:$credential")
    }

    override fun onVerificationFailed(e: FirebaseException) {
        Log.w(TAG, "onVerificationFailed", e)
        errorCount ++
        when (e) {
            is FirebaseAuthInvalidCredentialsException -> {
                Log.w("Login","Firebase Auth Invalid Credentials" )
            }

            is FirebaseTooManyRequestsException -> {
                Log.w("Login","Firebase Too Many Exception" )
            }

            is FirebaseAuthMissingActivityForRecaptchaException -> {
                Log.w("Login", "FirebaseAuthMissingActivityForRecaptchaException")
            }
        }

    }

    override fun onCodeSent(
        verificationId: String,
        token: PhoneAuthProvider.ForceResendingToken,
    ) {
        Log.d(TAG, "onCodeSent:$verificationId")
        storedVerificationId = verificationId
        resendToken = token
    }
}

fun startPhoneNumberVerification(context: Context , phoneNumber: String) {
    Log.w( "phoneNumber",phoneNumber)
    val options = PhoneAuthOptions.newBuilder(auth)
        .setPhoneNumber(phoneNumber)
        .setTimeout(60L, TimeUnit.SECONDS)
        .setActivity(context as Activity)
        .setCallbacks(callbacks)
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
                Log.d(TAG, "signInWithCredential:success")
                val user = task.result?.user
                check = 1
            } else {
                Log.w(TAG, "signInWithCredential:failure", task.exception)
                if (task.exception is FirebaseAuthInvalidCredentialsException) {
                    Log.w(TAG,"The verification code entered was invalid")
                }
                check = 0
            }
        }
}

//AuthEnd

@Composable
fun LoginScreen(navController: NavHostController) {
    var phoneNumber by remember { mutableStateOf("+91" ) }
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
                        text = "A code will be send to your phone number",
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
                        value = phoneNumber,
                        onValueChange = { phoneNumber = it },
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

                    Button(onClick = { startPhoneNumberVerification(context,phoneNumber) },
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Mustard_yellow)),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .width(200.dp)
                            .padding(10.dp)
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
                }

                Button(
                    onClick = {
                        verifyOTP(context,otp.value)
                        if(check == 1 ){
                            if (loggedInAs == "Customer") navController.navigate("MainScreen")
                            else navController.navigate("RestaurantHomePage")
                        }
                    },
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Mustard_yellow)),
                    modifier = Modifier
                        .width(250.dp)
                        .padding(10.dp)
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
                if(errorCount > 1){
                    Toast.makeText(context,"Too many Exception",Toast.LENGTH_SHORT).show()
                }

                Button(onClick =  { userPhone =  "1023456789" ;
                    navController.navigate("MainScreen")
                    },
                    colors = ButtonDefaults.buttonColors(Color.LightGray),
                    modifier = Modifier.fillMaxWidth() ) {
                    Text(text = "CONTINUE WITHOUT REGISTRATION")
                }
            }
        }
    }
}
