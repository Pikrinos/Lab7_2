package com.example.lab7_2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.FragmentActivity

class CameraReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        if(intent?.action == Intent.ACTION_CAMERA_BUTTON){
            val builder = NotificationCompat.Builder(context, "mes")
                .setContentTitle("Camera")
                .setSmallIcon(com.google.android.material.R.drawable.abc_btn_radio_to_on_mtrl_015)
                .setContentText("You have clicked on the camera button")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            NotificationManagerCompat.from(context).apply {
                this.notify(12345, builder.build())
            }
        }
    }
}