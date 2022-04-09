package com.danix43.messagingapp

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.danix43.messagingapp.data.models.Account
import com.danix43.messagingapp.data.models.Conversation
import com.danix43.messagingapp.data.models.Message
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class ConvosPreviewParameterProvider : PreviewParameterProvider<List<Conversation>> {

    private val account1 =
        Account(Random(1233).nextLong(), "User 1", "email1@gmail.com", "1234", emptyArray())
    private val account2 =
        Account(Random(1233).nextLong(), "User 1", "email1@gmail.com", "1234", emptyArray())

    private fun generateConvoList(): List<Conversation> {
        val list: ArrayList<Conversation> = ArrayList()

        for (i in 1..5) {
            val message = Message(
                Random.nextLong(),
                account1,
                account2,
                "message number $i",
                SimpleDateFormat("HH:mm", Locale.getDefault())
            )
            val convo =
                Conversation(Random.nextLong(), account1, account2, arrayListOf(message))

            list.add(convo)
        }

        return list

    }

    override val values: Sequence<List<Conversation>> = sequenceOf(
        generateConvoList()
    )

}