package com.example.remoteari

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.remoteari.ui.theme.RemoteAriTheme
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.get

class MainActivity : ComponentActivity() {

    private val mRemoteConfig = FirebaseRemoteConfig.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RemoteAriTheme {
                                 Greeting()

                //VER LOS DEFAULTS

                mRemoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
                val welcomeMessage = mRemoteConfig.getString("welcome_message")
                Toast.makeText(this, welcomeMessage, Toast.LENGTH_SHORT).show()
                          }
        }

    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Text(
        text = "Hola Ari",
        modifier = modifier
    )
}
