package com.deggan.remoteconfig

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val remoteConfig = FirebaseRemoteConfig.getInstance()
        val remoteConfigSettings = FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(true)
                .build()

        remoteConfig.setConfigSettings(remoteConfigSettings)
        remoteConfig.fetch(0)
                .addOnCompleteListener(this, { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@MainActivity, "Fetch Succeeded", Toast.LENGTH_SHORT).show()
                        remoteConfig.activateFetched()
                        textViewEnd.text = remoteConfig.getString("deggan_end_point")
                        textViewMessage.text = remoteConfig.getString("deggan_app_message")
                        textViewVersion.text = remoteConfig.getLong("deggan_app_version").toString()
                    } else {
                        Log.d("HASIL", task.exception!!.toString())
                        Toast.makeText(this@MainActivity, "Fetch Failed", Toast.LENGTH_SHORT).show()
                    }
                })

        buttonRecreate.setOnClickListener {
            recreate()
        }
    }
}
