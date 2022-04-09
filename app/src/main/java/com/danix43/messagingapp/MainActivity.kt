package com.danix43.messagingapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danix43.messagingapp.data.models.Conversation
import com.danix43.messagingapp.ui.theme.MessagingAppTheme

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getConversations().observe(this) { convos ->
            Log.d(TAG, "onCreate: observing $convos")
        }

        setContent {
            MessagingAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primary
                ) {
                    RootElement()
                }
            }
        }
    }


    @Composable
    fun Header() {
//        val salute = "Good afternoon, Dani!"
        Text(
            viewModel.retrieveHeaderMessage(),
            style = MaterialTheme.typography.h1,
            fontSize = 32.sp,
//            modifier = Modifier.padding(5.dp, 5.dp)
        )
    }

    @Preview
    @Composable
    fun ConvoListElement(@PreviewParameter(ConvoPreviewParameterProvider::class) convo: Conversation) {
        val userName = convo.sender.name
        val lastMessage = convo.messages.last().content
        val lastMessageSendDate = convo.messages.last().date

        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.clip(RoundedCornerShape(40.dp))
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 5.dp)
            ) {
                // user avatar
                Image(
                    painterResource(R.drawable.avatarplaceholder),
                    contentDescription = "An image representing the user",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .clip(CircleShape)
                        .width(50.dp)
                        .height(50.dp)
                )
                Column(
                    modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)
                ) {
                    // user name
                    Text(userName, style = MaterialTheme.typography.h6)
                    Row {
                        // user message
                        Text(
                            lastMessage,
                            style = MaterialTheme.typography.body1,
                            maxLines = 1,
                            overflow = TextOverflow.Clip,
                            softWrap = true
                        )
                        // send date
                        Text(
                            "| 20:30",
                            style = MaterialTheme.typography.body1,
                            textAlign = TextAlign.End
                        )
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Preview
    @Composable
    fun ConversationsList(@PreviewParameter(NewConvosListPreviewParameter::class) groupedConvos: Map<Boolean, List<Conversation>>) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            groupedConvos.forEach { (seen, convos) ->
                stickyHeader {
                    Text(
                        if (seen) "Here is what you missed out" else "Recap old conversations",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier.padding(0.dp, 5.dp)
                    )
                }
                items(convos) { convo ->
                    ConvoListElement(convo)
                }
            }
        }
    }


    @Composable
    fun Content() {
        Column(modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp)) {
            Header()

            viewModel.getConversations().value?.let { ConversationsList(groupedConvos = it) }
        }
    }

    @Preview
    @Composable
    fun RootElement() {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    backgroundColor = MaterialTheme.colors.primary,
                    onClick = { viewModel.createNewConvo() }) {
                    Icon(
                        Icons.Rounded.Add,
                        contentDescription = "plus",
                        modifier = Modifier.scale(2F)
                    )
                }
            },
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true,
            backgroundColor = MaterialTheme.colors.primary,
            content = { Content() },
            bottomBar = {
                BottomBar()
            })
    }

    @Composable
    fun BottomBar() {
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
                        Text(
                            "Your Profile", style = MaterialTheme.typography.body1,
                            fontSize = 15.sp
                        )
                    }
                }
                Spacer(Modifier.weight(1f, true))
                IconButton(onClick = { /*TODO*/ }) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                        Text(
                            "Settings", style = MaterialTheme.typography.body1,
                            fontSize = 15.sp
                        )
                    }
                }
            }
        }
    }
}
