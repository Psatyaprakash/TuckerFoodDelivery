package com.example.tuckerfooddelivery.View

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

@Composable
fun Firestore() {
    Column(
        Modifier
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AddRestaurantScreen()
//        Spacer(modifier = Modifier.height(16.dp))
//        Text(
//            text = "Restaurant's List from Firestore",
//            textAlign = TextAlign.Center,
//            fontSize = 30.sp
//        )
//        RestaurantList()
    }
}









/*@Composable
fun Firestore(){
    Column(
        Modifier
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        AddRestaurantScreen()
        Text(text = "Restaurant's List from Firestore", textAlign = TextAlign.Center, fontSize = 30.sp)
        RestaurantList()

    }
}

data class Restaurant(
    val name: String ,
    val id: String ,
    val contact: Contact
)
data class Contact(
    val phone: String,
    val email: String
)


@Composable
fun AddRestaurantScreen() {
    var name by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "ENTER NAME") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text(text = "ENTER PHONE") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "ENTER EMAIL") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = id,
            onValueChange = { id = it },
            label = { Text(text = "ENTER ID") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))


        Button(onClick = {
            addUser(name, id, Contact(phone,email))
        }) {
            Text(text = "Add restaurant")
        }

    }
}

val db = Firebase.firestore


fun fetchUsers(onResult: (List<Restaurant>) -> Unit) {
    db.collection("Restro")
        .get()
        .addOnSuccessListener { result ->
            val restaurantList = result.map { document -> document.toObject(Restaurant::class.java) }
            onResult(restaurantList)
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error getting document", e)
        }
}

fun addUser(name: String, id: String, contact: Contact) {
    val restaurant = Restaurant(
        name,
        id,
        contact
    )  //user is an object of restaurant class which takes the parameters name and id passed in addUser
    db.collection("Restro")//"users" is the collection name
//        .add(restaurant)
        .document(id+"_"+name)
        .set(restaurant)
        .addOnSuccessListener { docRef ->
            Log.d(TAG, "DOCUMENT SNAPSHOT ADDED AT LOC : $id _ $name")
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error Adding Document")

        }
}

@Composable
fun RestaurantList() {

    val restaurantList = remember {
        mutableStateOf<List<Restaurant>>(emptyList())
    }
    LaunchedEffect(Unit) {
        fetchUsers { restaurant ->
            restaurantList.value = restaurant
        }
    }

    LazyColumn{
        items(restaurantList.value) { restaurant ->
            Text(
                text = "NAME: ${restaurant.name}, ID: ${restaurant.id} ," +
                        "PHONE: ${restaurant.contact.phone}, EMAIL: ${restaurant.contact.email}" +
                        " ",
                fontSize = 20.sp,
                fontWeight = FontWeight.W500
            )
        }
    }
}*/


/*
package com.example.tuckerfooddelivery

@Composable
fun Firestore() {
    Column(
        Modifier
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AddUserScreen()
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "User's List from Firestore", textAlign = TextAlign.Center, fontSize = 30.sp)
        restaurantList()
    }
}

data class restaurant(
    val name: String = "",
    val id: Int = 0
)

@Composable
fun AddUserScreen() {
    var name by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Enter Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = id,
            onValueChange = { id = it },
            label = { Text(text = "Enter id") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            coroutineScope.launch {
                addUser(name, id.toInt())
            }
        }) {
            Text(text = "Add restaurant")
        }
    }
}

private val db = FirebaseFirestore.getInstance()

suspend fun addUser(name: String, id: Int) {
    val restaurant = restaurant(name, id)
    try {
        val docRef = db.collection("users").add(user).await()
        Log.d("Firestore", "Document added with ID: ${docRef.id}")
    } catch (e: Exception) {
        Log.e("Firestore", "Error adding document", e)
    }
}

@Composable
fun restaurantList() {
    val restaurantList = remember { mutableStateOf<List<User>>(emptyList()) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            fetchUsers { restaurants ->
                restaurantList.value = restaurants
            }
        }
    }

    LazyColumn {
        items(userList.value) { restaurant ->
            Text(
                text = "Name: ${user.name}, id: ${user.age}",
                fontSize = 20.sp,
                fontWeight = FontWeight.W500
            )
        }
    }
}

private suspend fun fetchUsers(onResult: (List<User>) -> Unit) {
    try {
        val result = db.collection("users").get().await()
        val restaurantList = result.map { document -> document.toObject(User::class.java) }
        onResult(userList)
    } catch (e: Exception) {
        Log.e("Firestore", "Error fetching documents", e)
    }
}
*/




