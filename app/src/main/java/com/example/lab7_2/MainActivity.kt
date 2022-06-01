package com.example.lab7_2

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.lab7_2.databinding.ActivityMainBinding


private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val batteryReceiver: BroadcastReceiver = BatteryReceiver()
    private val cameraReceiver: BroadcastReceiver = CameraReceiver()
    private val airplaneModeReceiver: BroadcastReceiver = AirplaneModeReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val mChannel = NotificationChannel(
                "mes",
                "Messages",
                NotificationManager.IMPORTANCE_HIGH
            )
            mChannel.description = "Incoming messages from users"

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }
    }
    override fun onStart() {
        super.onStart()
        val batteryFilter = IntentFilter(Intent.ACTION_BATTERY_LOW)
        val cameraFilter = IntentFilter(Intent.ACTION_CAMERA_BUTTON)
        val airplaneMode = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(batteryReceiver, batteryFilter)
        registerReceiver(cameraReceiver, cameraFilter)
        registerReceiver(airplaneModeReceiver, airplaneMode)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(batteryReceiver)
        unregisterReceiver(cameraReceiver)
        unregisterReceiver(airplaneModeReceiver)
    }

}