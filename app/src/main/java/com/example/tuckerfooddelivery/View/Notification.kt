package com.example.tuckerfooddelivery.View

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.tuckerfooddelivery.CartActivity
import com.example.tuckerfooddelivery.MainActivity
import com.example.tuckerfooddelivery.R

/*
@SuppressLint("InlinedApi")
@Composable
fun NotificationScreen(NotificationTitle: String, NotificationContent: String) {
    val context = LocalContext.current
    val notificationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // Permission granted, we can show notifications
        } else {
            // Permission denied, handle as needed
        }
    }

    LaunchedEffect(key1 = true) {
        notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
    }

    Column(modifier = androidx.compose.ui.Modifier
        .fillMaxSize()
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        
    ){
        Button(onClick = { createNotification(context, NotificationTitle , NotificationContent ) }) {
            Text(text = "Show Notification", fontSize = 30.sp)
        }
    }

}
*/

fun createNotification(context: Context, NotificationTitle : String , NotificationContent: String) {
    // Create a notification channel if needed (API 26+)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channelId = "default_channel_id"
        val channelName = "Default Channel"
        val channelDescription = "Channel for default notifications"
        val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
        channel.description = channelDescription

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    val intent = Intent(context, CartActivity::class.java).apply {
        putExtra("data", "This is notification") // Add this extra to indicate navigation
    }

    val pendingIntent = PendingIntent.getActivity(
        context, 100, intent,
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) PendingIntent.FLAG_IMMUTABLE
        else PendingIntent.FLAG_UPDATE_CURRENT
    )

    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    val notification = NotificationCompat.Builder(context, "default_channel_id")
        .setContentTitle(NotificationTitle)
        .setContentText(NotificationContent)
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setAutoCancel(true)
        .addAction(0, "Start", pendingIntent)
        .setContentIntent(pendingIntent)
        .build()

    notificationManager.notify(100, notification)
}
/*
fun createPendingIntent(context: Context): PendingIntent {
    val intent = Intent(context, MainActivity::class.java).apply {
        putExtra("data", "Hey this is notification")
    }

    val flag = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        PendingIntent.FLAG_IMMUTABLE
    } else {
        PendingIntent.FLAG_UPDATE_CURRENT
    }

    return PendingIntent.getActivity(context, 100, intent, flag)
}
*/