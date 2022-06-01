package com.example.lab7_2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.FragmentActivity

class AirplaneModeReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        if(intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED){
            var isAirplaneModeEnabled = intent.getBooleanExtra("state", false).toString()
            when(isAirplaneModeEnabled){
                "false" -> isAirplaneModeEnabled = "off"
                "true" -> isAirplaneModeEnabled = "on"
            }
            val builder = NotificationCompat.Builder(context, "mes")
                .setContentTitle("Airplane mode")
                .setSmallIcon(com.google.android.material.R.drawable.abc_btn_radio_to_on_mtrl_015)
                .setContentText("Airplane mode is $isAirplaneModeEnabled")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            NotificationManagerCompat.from(context).apply {
                this.notify(12345, builder.build())
            }
        }
    }
}