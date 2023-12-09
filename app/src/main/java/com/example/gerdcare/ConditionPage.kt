package com.example.gerdcare

import android.app.Dialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.drawable.ColorDrawable
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout


class ConditionPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_condition)

        val submitButton: Button = findViewById(R.id.button)
        val okButton: Button = findViewById(R.id.okeButton)

        ferguso()

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

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.conditionpopup)

        val okeButton: Button = dialog.findViewById(R.id.okeButton)

        okeButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun ferguso() {
        val tabLayout: TabLayout = findViewById(R.id.menu_bawah_actdua)
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.document), 0)
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.home), 1)
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.profile), 2)

        tabLayout.getTabAt(0)?.icon?.setColorFilter(
            ContextCompat.getColor(this, R.color.gray),
            PorterDuff.Mode.SRC_IN
        )
        tabLayout.getTabAt(1)?.icon?.setColorFilter(
            ContextCompat.getColor(this, R.color.pink),
            PorterDuff.Mode.SRC_IN
        )
        tabLayout.getTabAt(2)?.icon?.setColorFilter(
            ContextCompat.getColor(this, R.color.gray),
            PorterDuff.Mode.SRC_IN
        )

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
//                    0 -> {
//                        startActivity(Intent(this@MainActivity, DocumentActivity::class.java))
//                    }
                    2 -> {
                        //startActivity(Intent(this@MainActivity, Registration::class.java))
                    }
                }
                for (i in 0 until tabLayout.tabCount) {
                    val currentTab = tabLayout.getTabAt(i)
                    if (currentTab == tab) {
                        currentTab?.icon?.setColorFilter(
                            ContextCompat.getColor(this@ConditionPage, R.color.pink),
                            PorterDuff.Mode.SRC_IN
                        )
                    } else {
                        currentTab?.icon?.setColorFilter(
                            ContextCompat.getColor(this@ConditionPage, R.color.gray),
                            PorterDuff.Mode.SRC_IN
                        )
                    }
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.icon?.setColorFilter(
                    ContextCompat.getColor(this@ConditionPage, R.color.gray),
                    PorterDuff.Mode.SRC_IN
                )
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Handle the reselection as needed
            }
        })
    }
}

