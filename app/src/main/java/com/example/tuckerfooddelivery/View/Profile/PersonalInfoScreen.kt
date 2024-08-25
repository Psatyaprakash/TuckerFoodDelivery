package com.example.tuckerfooddelivery.View.Profile

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.tuckerfooddelivery.Model.Add.addUser
import com.example.tuckerfooddelivery.Model.Data.User
import com.example.tuckerfooddelivery.Model.Fetch.db
import com.example.tuckerfooddelivery.Model.Fetch.fetchUser
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.View.Storage
import com.example.tuckerfooddelivery.View.getImageUrlFromFirebaseStorage
import com.example.tuckerfooddelivery.ViewModel.storageRef
import com.example.tuckerfooddelivery.ViewModel.userBio
import com.example.tuckerfooddelivery.ViewModel.userEmail
import com.example.tuckerfooddelivery.ViewModel.userName
import com.example.tuckerfooddelivery.ViewModel.userPhone

@Composable
fun CircularButtonWithSymbol(onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.White_Blue)),
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier
            .size(50.dp)
            .background(Color.Transparent, CircleShape)
    ) {
        Image(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Back", Modifier.size(35.dp) )
    }
}

@Composable
fun PersonalInfoDetails(navController: NavHostController) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var bio by remember { mutableStateOf("") }

    val context = LocalContext.current
    val imageUri = remember { mutableStateOf<Uri?>(null) }

    val userList = remember { mutableStateOf<List<User>>(emptyList()) }

    LaunchedEffect(Unit) {
        try {
            fetchUser { user ->
                userList.value = user
                fullName = user[0].name
                phoneNumber = user[0].phone
                email = user[0].email
                bio = user.get(0).bio

                //Log.w("fetch", "${user.get(0)}")
            }
        } catch (e: Exception) {
            Log.w("Error" ,"Failed to load User")
        }
    }
    userName = fullName
    userEmail = email
    userPhone = phoneNumber
    userBio = bio

    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            imageUri.value = uri
            uri?.let { uploadImage(uri, phoneNumber , context) }
        }
    var imageUrl by remember { mutableStateOf<String?>(null) }
    var loadError by remember { mutableStateOf<Exception?>(null) }
    var imagePath by remember { mutableStateOf("") }
    imagePath = "User/$phoneNumber.jpg"

    Log.w("ImagePath", "$imagePath \n $phoneNumber")
    // Fetch the image URL
    LaunchedEffect(imagePath) {
        getImageUrlFromFirebaseStorage(
            imagePath = imagePath,
            onSuccess = { url -> imageUrl = url },
            onFailure = { exception -> loadError = exception },
        )
    }
    Log.w("ImageUrl", "$imageUrl")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(17.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (navController.previousBackStackEntry?.destination?.route != "LoginScreen") {
                CircularButtonWithSymbol(onClick = { navController.popBackStack() })
            } else {
                Button( onClick = { navController.navigate("MainScreen") },
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.White_Blue)),
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Transparent, CircleShape)
                ) {
                    Image(Icons.Default.Home,
                        contentDescription = "Home" ,
                        Modifier.size(30.dp))
                }
            }


            Text(
                text = "Personal Info",
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(20.dp,0.dp) // Adjust spacing if needed
            )
        }
        // Profile Image and Edit Button
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model =  imageUrl ,
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape),
                contentScale = ContentScale.Fit,

            )
            Spacer(modifier = Modifier.height(5.dp))
            TextButton(
                onClick = { launcher.launch("image/*") },
            ) {
                Text("Edit Image", color = Color.Blue)
            }
            Spacer(modifier = Modifier.height(5.dp))
        }

        // Form Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp, 10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = "FULL NAME", color = Color.Black, fontSize = 14.sp  )
            Spacer(modifier = Modifier.height(10.dp))
            // Name
            OutlinedTextField(
                value = fullName,
                onValueChange = { fullName = it },
                label = { Text("Enter your name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    , shape = RoundedCornerShape(16.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            // Email
            Text(text = "E-MAIL", color = Color.Black, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Enter your Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            // Phone Number
            Text(text = "PHONE NUMBER", color = Color.Black, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = "+91 $phoneNumber",
                onValueChange = { phoneNumber = it },
                label = { Text("Enter your Phone Number") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            // Bio
            Text(text = "BIO", color = Color.Black, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = bio,
                onValueChange = { bio = it },
                label = { Text("Enter your bio") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp),
                shape = RoundedCornerShape(16.dp)
            )
            Spacer(modifier = Modifier.height(45.dp))
            Button(
                onClick = {
                    addUser(fullName ,email, phoneNumber ,bio);
                    navController.navigate("MainScreen")
                },
                colors = ButtonDefaults.buttonColors(Color(0xFFD4AF37)), // Mustard color
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
            ) {
                Text("SAVE", fontSize = 18.sp, color = Color.White)
            }
        }
    }
}

fun uploadImage(uri: Uri, phone : String, context: Context) {
    val fileName = "User/$phone.jpg"
    val imageRef = storageRef.child(fileName)
    Log.w("Image Upload", "$imageRef")
    imageRef.putFile(uri)
        .addOnSuccessListener { taskSnapshot ->
            imageRef.downloadUrl.addOnSuccessListener { uri ->
                Toast.makeText(
                    context,
                    "Image Uploaded successfully: $uri",
                    Toast.LENGTH_LONG
                )
                    .show()
            }
            Log.w("ImageUri" , "$uri")
        }
        .addOnFailureListener { e ->
            Toast.makeText(context, "Image failed: ${e.message}", Toast.LENGTH_SHORT).show()
        }
}
