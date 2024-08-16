package com.example.tuckerfooddelivery

import android.annotation.SuppressLint
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context

class BaseApplication: Application() {

    companion object{
        lateinit var notificationManager: NotificationManager
    }

    @SuppressLint("NewApi")
    override fun onCreate(){
        super.onCreate()

        val notificationChannel = NotificationChannel(
            "Channel_id",
            "channel_name",
            NotificationManager.IMPORTANCE_HIGH
        )
        notificationChannel.description = "Notification Desc.."
        notificationChannel.enableLights(true)
        notificationChannel.enableVibration(true)
        notificationChannel.vibrationPattern = longArrayOf(100,200,300,200,100)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)

    }
}