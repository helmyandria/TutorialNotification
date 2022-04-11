package com.helmyandrianto.tutorialnotification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class NotificationReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val message = intent?.getStringExtra(MainActivity.EXTRA_MESSAGE)
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}