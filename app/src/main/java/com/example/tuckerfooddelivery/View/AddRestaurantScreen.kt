package com.example.tuckerfooddelivery.View

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.tuckerfooddelivery.Model.Data.Contact
import com.example.tuckerfooddelivery.Model.Data.MenuCategory
import com.example.tuckerfooddelivery.Model.Data.MenuItem
import com.example.tuckerfooddelivery.Model.Add.addRestaurant

@Composable
fun AddRestaurantScreen() {
    var name by remember { mutableStateOf("Restro1") }
    var id by remember { mutableStateOf("1") }
    var phone by remember { mutableStateOf("1234567890") }
    var email by remember { mutableStateOf("restro1@mail") }
    var mName by remember { mutableStateOf("") }
    var mPrice by remember { mutableStateOf("") }
    var mImage by remember { mutableStateOf("") }//gs://tuckerfooddelivery.appspot.com/Restro/Menu/Category/Item/Mocktail.jpg
    var cName by remember { mutableStateOf("") }
    var menuItems by remember { mutableStateOf<List<MenuItem>>(emptyList()) }
    var menuCategory by remember { mutableStateOf<List<MenuCategory>>(emptyList()) }
    val context = LocalContext.current



    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Enter Restaurant Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text(text = "Enter Phone Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Enter Email Address") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = id,
            onValueChange = { id = it },
            label = { Text(text = "Enter Restaurant ID") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = cName,
            onValueChange = { cName = it },
            label = { Text(text = "Enter Category") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = mName,
            onValueChange = { mName = it },
            label = { Text(text = "Enter Menu Item Name") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = mPrice,
            onValueChange = { mPrice = it },
            label = { Text(text = "Enter Price of Menu") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = mImage,
            onValueChange = { mImage = it },
            label = { Text(text = "Enter Menu Image") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        //Adding Item
        Button(
            onClick = {
            if (mName.isNotEmpty() && mPrice.isNotEmpty() && mImage.isNotEmpty()) {
                val itemPrice = mPrice.toDoubleOrNull()
                if (itemPrice != null) {
                    val item = MenuItem(mName, itemPrice, listOf(mImage))
                    menuItems = menuItems + item
                    mName = ""
                    mPrice = ""
                    mImage = ""
                } else {
                    Toast.makeText(context, "Invalid price format", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Please fill all menu item fields", Toast.LENGTH_SHORT).show()
            }
            })
        {
            Text(text = "Add Menu Item")
        }
        Spacer(modifier = Modifier.height(16.dp))
        //Adding Menu Category
        Button(
            onClick = {
                val category = MenuCategory(cName, menuItems)
                menuCategory = menuCategory + category
                cName = ""
                mName = ""
                mPrice = ""
                mImage = ""
            })
        {
            Text(text = "Add Menu Category")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (name.isNotEmpty() && id.isNotEmpty() && phone.isNotEmpty() && email.isNotEmpty()
                && cName.isNotEmpty()) {

                val menu = MenuCategory(cName, menuItems)
                addRestaurant(name, id, Contact(phone, email), menu)
            } else {
                Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Add Restaurant")
        }
    }
}




/*
@Composable
fun AddRestaurantScreen() {
    var name by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var mName by remember { mutableStateOf("") }
    var mPrice by remember { mutableStateOf("") }
    var mImage by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Enter Restaurant Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text(text = "Enter Phone Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Enter Email Address") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = id,
            onValueChange = { id = it },
            label = { Text(text = "Enter Restaurant ID") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = category,
            onValueChange = { category = it },
            label = { Text(text = "Enter Category") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = mName,
            onValueChange = { mName = it },
            label = { Text(text = "Enter Menu Name") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = mPrice,
            onValueChange = { mPrice = it },
            label = { Text(text = "Enter Price of Menu") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = mImage,
            onValueChange = { mImage = it },
            label = { Text(text = "Enter Menu Image") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            if (name.isNotEmpty() && id.isNotEmpty() && phone.isNotEmpty() && email.isNotEmpty()
                && category.isNotEmpty() && mName.isNotEmpty() && mPrice.isNotEmpty()) {

                val itemPrice = mPrice.toDoubleOrNull()
                if (itemPrice != null) {
                    val item = Item(mName, itemPrice, mImage)
                    val menu = Menu(category, item)// listOf(item)
                    addRestaurant(name, id, Contact(phone, email), menu)
                } else {
                    Toast.makeText(context, "Invalid price format", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Add Restaurant")
        }
    }
}*/
