package com.picochat.pictoshare

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.picochat.pictoshare.ui.theme.PictoShareTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PictoShareTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Greeting(msg = Message("Patrick C" , "Hi There!"))
                }
            }
        }
    }
}

data class Message(val author: String , val body: String)

@RequiresApi(Build.VERSION_CODES.KITKAT)
@Composable
fun Greeting(msg: com.picochat.pictoshare.Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.cat),
            contentDescription = msg.author + "'s" + " profile picture",
        modifier = Modifier.size(40.dp).clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(msg.author)
            Text(msg.body)
        }
    }
    }

@RequiresApi(Build.VERSION_CODES.KITKAT)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PictoShareTheme {
        Greeting(msg = Message("Patrick" , "Hello!"))
    }
}