package com.example.gerdcare

import android.app.Dialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitButton: Button = findViewById(R.id.button)
        val okButton: Button = findViewById(R.id.okeButton)

        okButton.setOnClickListener { // Tambahkan logika notifikasi di sini
            showNotification()
        }
        submitButton.setOnClickListener {
            showPopup()
        }
 }

    private fun showNotification() {
        val channelId = "Gerdcare"
        val notificationId = 1

        val notificationManager = NotificationManagerCompat.from(this)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(channelId, notificationManager)
        }

        val notification: NotificationCompat.Builder = NotificationCompat.Builder(this, channelId)
            //.setSmallIcon(R.drawable.ic_notification)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("Title")
            .setContentText("Your notification content here.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

       // notificationManager.notify(notificationId, notification.build())
    }

    private fun createNotificationChannel(channelId: String, notificationManager: NotificationManagerCompat) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "My Channel"
            val descriptionText = "Channel description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
                enableLights(true)
                lightColor = Color.RED
                enableVibration(true)
            }
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun showPopup() {
        val dialog = Dialog(this)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.conditionpopup)

        val okeButton: Button = dialog.findViewById(R.id.okeButton)

        okeButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}

