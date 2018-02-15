package com.deggan.remoteconfig

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val remoteConfig = FirebaseRemoteConfig.getInstance()
        val remoteConfigSettings = FirebaseRemoteConfigSettings.Builder().build()

        remoteConfig.setConfigSettings(remoteConfigSettings)

        var configMap = HashMap<String,String>()
        configMap["deggan_end_point"] = "https://deggan.com"
        configMap["deggan_app_version"] = "1"
        configMap["deggan_app_message"] = "Hai Dunia!"
    }
}
