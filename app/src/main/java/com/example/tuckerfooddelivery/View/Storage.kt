package com.example.tuckerfooddelivery.View

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.tuckerfooddelivery.R
import com.google.firebase.Firebase
import com.google.firebase.storage.storage
import kotlinx.coroutines.tasks.await


@Composable
fun Storage() {

    var userName by remember { mutableStateOf("") }
    var itemName by remember { mutableStateOf("itemName") }
    val storage = Firebase.storage
    val storageRef = storage.reference
    fun uploadImage(uri: Uri, context: Context) {
//        val fileName = "profile/${userName}.jpg"
//        val fileName = "Restro/Menu/Category/Item/${itemName}.jpg"
        val fileName = "Cart/$itemName.jpg"
        val imageRef = storageRef.child(fileName)
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

    val context = LocalContext.current
    val imageUri = remember {
        mutableStateOf<Uri?>(null)
    }
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            imageUri.value = uri
            uri?.let { uploadImage(uri, context) }
        }
    Column(
        modifier = Modifier
//                .padding(20.dp)
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = itemName ,
            onValueChange = { itemName = it },
            label = { Text(text = "UserName", fontSize = 20.sp , color = Color.Black ) }
        )
        Button(onClick = { launcher.launch("image/*") }) {
            Text(text = "Select Image")
        }
        Spacer(modifier = Modifier.height(20.dp))
        imageUri.value?.let { uri ->
            Image(
                painter = rememberAsyncImagePainter(uri),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
        }
/*
        suspend fun getImageUrlFromFirebase(storagePath: String): String? {
//            val storageRef = FirebaseStorage.getInstance().reference.child(storagePath)
            return try {
                val downloadUrl = storageRef.downloadUrl.await()
                downloadUrl.toString()
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
        val imageUrl = remember { mutableStateOf<String?>(null) }

        LaunchedEffect(Unit) {
            imageUrl.value = getImageUrlFromFirebase("Restro/Menu/Category/Item/Mocktail.jpg")
        }

        imageUrl.value?.let { url ->
            Text(text = "Storage Image")
            Image(
                painter = rememberImagePainter(
                    data = url,
                    builder = {
                        transformations(CircleCropTransformation())
                    }
                ),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
        }*/
    }
}
