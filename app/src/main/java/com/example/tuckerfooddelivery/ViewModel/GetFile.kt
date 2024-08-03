package com.example.tuckerfooddelivery.ViewModel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.google.firebase.Firebase
import com.google.firebase.storage.storage

@Composable
fun getImage(){
    val storage = Firebase.storage
    val storageRef = storage.reference
    val fileName = "profile/Avi.jpg"
    var fileUri by remember { mutableStateOf<String?>(null) }

//    fun fetchFile() {
        val fileRef = storageRef.child(fileName)
        fileRef.downloadUrl.addOnSuccessListener { uri ->
            fileUri = uri.toString()
        }.addOnFailureListener { e ->
            fileUri = null
//                    Toast.makeText(context, "Image failed: ${e.message}", Toast.LENGTH_SHORT).show()
            // Handle any errors
        }
//    }

    fileUri?.let { uri ->
        Image(
            painter = rememberAsyncImagePainter(uri),
            contentDescription = null,
            modifier = Modifier
                .size(400.dp)
                .fillMaxWidth()
        )
    }
}