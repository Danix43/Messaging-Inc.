package com.danix43.messagingapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danix43.messagingapp.ui.theme.BackgroundGradientTopColor
import com.danix43.messagingapp.ui.theme.MessagingAppTheme

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"
    val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getConversations().observe(this) { convos ->
            Log.d(TAG, "onCreate: observing $convos")
        }

        setContent {
            MessagingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {


                }
            }
        }
    }

    @Preview
    @Composable
    fun BottomBar() {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(backgroundColor = BackgroundGradientTopColor, onClick = { viewModel.createNewConvo() }) {
                    Icon(Icons.Rounded.Add, contentDescription = "plus", modifier = Modifier.scale(2F))
                }
            },
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true,
            bottomBar = {
                BottomAppBar(
                    cutoutShape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50)),
                    contentPadding = PaddingValues(25.dp, 0.dp, 25.dp, 0.dp),
                    modifier = Modifier.clip(RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp)),
                    backgroundColor = MaterialTheme.colors.surface,
                    elevation = 8.dp
                ) {
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    Icons.Default.AccountCircle,
                                    contentDescription = "Your Profile"
                                )
                                Text("Your Profile", textAlign = TextAlign.Center)
                            }
                        }
                        Spacer(Modifier.weight(1f, true))
                        IconButton(onClick = { /*TODO*/ }) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(Icons.Default.Settings, contentDescription = "Settings")
                                Text("Settings", textAlign = TextAlign.Center)
                            }
                        }
                    }
                }
            })
        {
        }
    }
}
