package com.helmyandrianto.tutorialnotification

import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var notificationManager: NotificationManagerCompat

    companion object {
        const val EXTRA_MESSAGE = "extra_message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = NotificationManagerCompat.from(this)

        btnSend1.setOnClickListener {
            val title = etTitle.text.toString()
            val message = etMessage.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

//            val broadcastIntent = Intent(this, NotificationReceiver::class.java)
//            broadcastIntent.putExtra(EXTRA_MESSAGE, message )
//            val actionIntent = PendingIntent.getBroadcast(this, 0,broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT)

            val builder = NotificationCompat.Builder(this, BaseApplication.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_favorite)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                    intent to open apps
                .setContentIntent(pendingIntent)
                .setStyle(
                    NotificationCompat.InboxStyle().addLine("Ini pesan 1").addLine("Ini pesan 2")
                        .addLine("Ini pesan 3").addLine("Ini pesan 4").addLine("Ini pesan 5")
                        .addLine("Ini pesan 6").addLine("Ini pesan 7").setBigContentTitle("Ini Big Content Title").setSummaryText("Ini Summary Text")
                )
//                    notification gone
                .setAutoCancel(true)
//                .setSubText("Ini sub text")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
//                .addAction(R.mipmap.ic_launcher,"Tampilkan pesan", actionIntent)
                .setOnlyAlertOnce(true)
                .setColor(Color.GREEN)

            val notification = builder.build()
            notificationManager.notify(1, notification)
        }

        btnSend2.setOnClickListener {
            val title = etTitle.text.toString()
            val message = etMessage.text.toString()
            val builder = NotificationCompat.Builder(this, BaseApplication.CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_favorite)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)

            val notification = builder.build()
            notificationManager.notify(2, notification)

        }

    }
}