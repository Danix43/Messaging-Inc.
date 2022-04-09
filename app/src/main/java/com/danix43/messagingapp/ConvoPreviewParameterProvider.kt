package com.danix43.messagingapp

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.danix43.messagingapp.data.models.Account
import com.danix43.messagingapp.data.models.Conversation
import com.danix43.messagingapp.data.models.Message
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

class ConvoPreviewParameterProvider : PreviewParameterProvider<Conversation> {

    private val account1 =
        Account(Random(1233).nextLong(), "User 1", "email1@gmail.com", "1234", emptyArray())
    private val account2 =
        Account(Random(1233).nextLong(), "User 1", "email1@gmail.com", "1234", emptyArray())


    override val values: Sequence<Conversation> = sequenceOf(
        Conversation(
            Random(123).nextLong(),
            account1,
            account2,
            arrayListOf(
                Message(
                    Random.nextLong(),
                    account1,
                    account2,
                    "test1",
                    SimpleDateFormat("MMMMddyyyyHHmm", Locale.getDefault())
                ),
                Message(
                    Random.nextLong(),
                    account1,
                    account2,
                    "test2",
                    SimpleDateFormat("MMMMddyyyyHHmm", Locale.getDefault())
                ),
                Message(
                    Random.nextLong(),
                    account1,
                    account2,
                    "test3jkdsfhgkjshdnognbdsofgbsdp;gfb",
                    SimpleDateFormat("MMMMddyyyyHHmm", Locale.getDefault())
                )
            )
        ),
        Conversation(
            Random(123).nextLong(),
            account1,
            account2,
            arrayListOf(
                Message(
                    Random.nextLong(),
                    account1,
                    account2,
                    "test1",
                    SimpleDateFormat("MMMMddyyyyHHmm", Locale.getDefault())
                ),
                Message(
                    Random.nextLong(),
                    account1,
                    account2,
                    "test2",
                    SimpleDateFormat("MMMMddyyyyHHmm", Locale.getDefault())
                ),
                Message(
                    Random.nextLong(),
                    account1,
                    account2,
                    "test3",
                    SimpleDateFormat("MMMMddyyyyHHmm", Locale.getDefault())
                )
            )
        )
    )
}