package com.example.tuckerfooddelivery.View.Profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun FAQScreen(navController: NavHostController) {
    val faqs = listOf(
        "What is the Pledge feature?" to "The Pledge feature is a community-driven initiative in our food delivery app that allows users to donate funds to help provide unsold food from local restaurants to underprivileged individuals and families.",
        "How does the Pledge feature work?" to "Local restaurants partner with us to donate their unsold food at the end of each day. These food items are then checked for safety and quality before being distributed to those in need through local NGOs and shelters.",
        "How can I make a pledge?" to "When you place an order through our app, you will see an option to make a pledge. You can choose the amount you wish to donate, and it will be added to your total order amount.",
        "Is my donation tax-deductible?" to "Depending on your local regulations and the specifics of our partnership with NGOs, your donation may be tax-deductible. Please check with a tax professional or refer to local guidelines.",
        "How do I know my donation is making a difference?" to "We provide regular updates on how the donations are being used, including stories and feedback from the beneficiaries. You will receive these updates through the app.",
        "Can I make a pledge without ordering food?" to "Currently, the Pledge feature is integrated with the food ordering process. However, we are working on adding an option for standalone donations in the future.",
        "How do you ensure the safety and quality of the donated food?" to "All donated food items are carefully checked to meet safety and quality standards before being distributed to those in need.",
        "How do I get involved further with the Pledge initiative?" to "If you are interested in getting more involved, please contact us through the app or our website. We are always looking for more partners and volunteers to help us in this mission."
    )

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        item {
            Row(
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                CircularButtonWithSymbol(onClick = { navController.navigate("ProfileView") })
                Spacer(modifier = Modifier.width(120.dp))

                Text(
                    text = "FAQs",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(top = 12.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        items(faqs) { (question, answer) ->
            FAQItem(question, answer)
        }
    }
}


@Composable
fun FAQItem(question: String, answer: String) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Button(
            onClick = { expanded = !expanded },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD4AF37)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Text(
                text = question,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
            )
        }

        if (expanded) {
            Text(
                text = answer,
                color = Color.Black,
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}
