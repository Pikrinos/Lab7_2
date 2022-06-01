package com.example.lab7_2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class BatteryReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        if(intent?.action == Intent.ACTION_BATTERY_LOW){
            val builder = NotificationCompat.Builder(context, "mes")
                    .setContentTitle("Battery")
                    .setSmallIcon(com.google.android.material.R.drawable.abc_btn_radio_to_on_mtrl_015)
                    .setContentText("Please charge your battery")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            NotificationManagerCompat.from(context).apply {
                    this.notify(12345, builder.build())
            }
        }
    }
}