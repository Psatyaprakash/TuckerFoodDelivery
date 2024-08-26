package com.example.tuckerfooddelivery.View.Restaurant_Pages

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.navigation.NavController
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.View.Profile.CircularButtonWithSymbol
import com.example.tuckerfooddelivery.ViewModel.ScreenHeight
import com.example.tuckerfooddelivery.ViewModel.ScreenWidth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Timing(navController: NavController) {

    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    var cardwidth = 1 * ScreenWidth
    var boxwidth = 0.3 * ScreenWidth
    var cardheight = 0.18 * ScreenHeight

    Column {
        Column(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularButtonWithSymbol {
                    navController.popBackStack()
                }
                Spacer(modifier = Modifier.width(1.dp))
                Text(
                    text = "Restaurant Timings",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

//            Text(text = "Schedule :", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = Color.Blue, modifier = Modifier
//                .align(Alignment.Start)
//                .padding(horizontal = 10.dp))

            Card (
                    shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxSize()
                    .wrapContentHeight(),
                colors = CardColors(
                    containerColor = Mustard_yellow_light,
                    contentColor = Color.Black,
                    disabledContentColor = Mustard_yellow,
                    disabledContainerColor = Mustard_yellow
                ),
                //onClick = {navController.navigate("")}
            ){
                Column(
                    modifier = Modifier
                        .padding(25.dp)
                        .fillMaxSize()
                        .wrapContentHeight()
                ) {
                    Row (
                        modifier = Modifier
                            .align(Alignment.End),
                        horizontalArrangement = Arrangement.End
                    ){
                        Spacer(modifier = Modifier.width(1.dp))
                        Text(text = "Opens",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif,
                            fontStyle = FontStyle.Italic,
                            color = Color.Black)
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(text = "Closes",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif,
                            fontStyle = FontStyle.Italic,
                            color = Color.Black)
                        Spacer(modifier = Modifier.width(20.dp))

                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    //Monday
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Row {
                            Text(text = " Mon", fontSize = 25.sp, fontWeight = FontWeight.Normal)
                        }
                        Row {
                            var MonOpen by remember { mutableStateOf("9:00am") }
                            TextField(
                                value = MonOpen,
                                onValueChange = { MonOpen = it },
                                //label = { androidx.compose.material3.Text("9:00am") },
                                modifier = Modifier
                                    .size(width = 90.dp, height = 60.dp)
                                    .height(56.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            var MonClose by remember { mutableStateOf("8:00pm") }
                            TextField(
                                value = MonClose,
                                onValueChange = { MonClose = it },
                                //label = { androidx.compose.material3.Text("8:00pm") },
                                modifier = Modifier
                                    .size(width = 90.dp, height = 60.dp)
                                    .height(56.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(25.dp))

                    //Tuesday
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Row {
                            Text(text = " Tue", fontSize = 25.sp, fontWeight = FontWeight.Normal)
                        }
                        Row {
                            var TueOpen by remember { mutableStateOf("9:00am") }
                            TextField(
                                value = TueOpen,
                                onValueChange = { TueOpen = it },
                                modifier = Modifier
                                    .size(width = 90.dp, height = 60.dp)
                                    .height(56.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            var TueClose by remember { mutableStateOf("8:00pm") }
                            TextField(
                                value = TueClose,
                                onValueChange = { TueClose = it },
                                modifier = Modifier
                                    .size(width = 90.dp, height = 60.dp)
                                    .height(56.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(25.dp))

                    //Wednesday
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ){
                        Row {
                            Text(text = " Wed", fontSize = 25.sp, fontWeight = FontWeight.Normal)
                        }

                        Row {
                            var WedOpen by remember { mutableStateOf("9:00am") }
                            TextField(
                                value = WedOpen,
                                onValueChange = { WedOpen = it },
                                modifier = Modifier
                                    .size(width = 90.dp, height = 60.dp)
                                    .height(56.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            var MondayClose by remember { mutableStateOf("8:00pm") }
                            TextField(
                                value = MondayClose,
                                onValueChange = { MondayClose = it },
                                modifier = Modifier
                                    .size(width = 90.dp, height = 60.dp)
                                    .height(56.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(25.dp))

                    //Thursday
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ){
                        Row {
                            Text(text = " Thur", fontSize = 25.sp, fontWeight = FontWeight.Normal)
                        }

                        Row {
                            var ThurOpen by remember { mutableStateOf("9:00am") }
                            TextField(
                                value = ThurOpen,
                                onValueChange = { ThurOpen = it },
                                modifier = Modifier
                                    .size(width = 90.dp, height = 60.dp)
                                    .height(56.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            var ThurClose by remember { mutableStateOf("8:00pm") }
                            TextField(
                                value = ThurClose,
                                onValueChange = { ThurClose = it },
                                modifier = Modifier
                                    .size(width = 90.dp, height = 60.dp)
                                    .height(56.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(25.dp))

                    //Friday
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Row {
                            Text(text = " Fri", fontSize = 25.sp, fontWeight = FontWeight.Normal)
                        }

                        Row {
                            var FriOpen by remember { mutableStateOf("9:00am") }
                            TextField(
                                value = FriOpen,
                                onValueChange = { FriOpen = it },
                                modifier = Modifier
                                    .size(width = 90.dp, height = 60.dp)
                                    .height(56.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            var FriClose by remember { mutableStateOf("8:00pm") }
                            TextField(
                                value = FriClose,
                                onValueChange = { FriClose = it },
                                modifier = Modifier
                                    .size(width = 90.dp, height = 60.dp)
                                    .height(56.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(25.dp))

                    //Saturday
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Row {
                            Text(text = " Sat", fontSize = 25.sp, fontWeight = FontWeight.Normal)
                        }

                        Row {
                            var SatOpen by remember { mutableStateOf("9:00am") }
                            TextField(
                                value = SatOpen,
                                onValueChange = { SatOpen = it },
                                modifier = Modifier
                                    .size(width = 90.dp, height = 60.dp)
                                    .height(56.dp)
                            )
                        Spacer(modifier = Modifier.width(10.dp))
                            var SatClose by remember { mutableStateOf("8:00pm") }
                            TextField(
                                value = SatClose,
                                onValueChange = { SatClose = it },
                                modifier = Modifier
                                    .size(width = 90.dp, height = 60.dp)
                                    .height(56.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(25.dp))

                    //Sunday
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row {
                            Text(text = " Sun", fontSize = 25.sp, fontWeight = FontWeight.Normal)
                        }
                        Row {
                            var SunOpen by remember { mutableStateOf("9:00am") }
                            TextField(
                                value = SunOpen,
                                onValueChange = { SunOpen = it },
                                modifier = Modifier
                                    .size(width = 90.dp, height = 60.dp)
                                    .height(56.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            var SunClose by remember { mutableStateOf("8:00pm") }
                            TextField(
                                value = SunClose,
                                onValueChange = { SunClose = it },
                                modifier = Modifier
                                    .size(width = 90.dp, height = 60.dp)
                                    .height(56.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))

//                    Text(text = "Tuesday",fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
//                    Spacer(modifier = Modifier.height(20.dp))
//                    Text(text = "Wednesday",fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
//                    Spacer(modifier = Modifier.height(20.dp))
//                    Text(text = "Thursday",fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
//                    Spacer(modifier = Modifier.height(20.dp))
//                    Text(text = "Friday",fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
//                    Spacer(modifier = Modifier.height(20.dp))
//                    Text(text = "Saturday",fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
//                    Spacer(modifier = Modifier.height(20.dp))
//                    Text(text = "Sunday",fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
//                    Spacer(modifier = Modifier.height(20.dp))

                }

            }
            Spacer(modifier = Modifier.height(25.dp))
            Box(modifier = Modifier
                .fillMaxWidth()) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(width = 100.dp, height = 45.dp),
                    border = BorderStroke(width = 0.dp, color = Color.Transparent),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Mustard_yellow))
                ) {
                    Text(text = "SAVE", fontSize = 17.sp)
                }
            }
            Spacer(modifier = Modifier.height(25.dp))


        }
    }
}