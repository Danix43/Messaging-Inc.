package com.danix43.messagingapp

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.danix43.messagingapp.data.models.Account
import com.danix43.messagingapp.data.models.Conversation
import com.danix43.messagingapp.data.models.Message
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class NewConvosListPreviewParameter : PreviewParameterProvider<Map<Boolean, List<Conversation>>> {

    private val account1 =
        Account(Random(1233).nextLong(), "User 1", "email1@gmail.com", "1234", emptyArray())
    private val account2 =
        Account(Random(1233).nextLong(), "User 1", "email1@gmail.com", "1234", emptyArray())

    private fun generateConvoList(): Map<Boolean, List<Conversation>> {
        val listSeenTrue: ArrayList<Conversation> = ArrayList()
        val listSeenFalse: ArrayList<Conversation> = ArrayList()

        for (i in 1..10) {
            val message = Message(
                Random.nextLong(),
                account1,
                account2,
                "message number $i",
                SimpleDateFormat("HH:mm", Locale.getDefault())
            )
            val convo =
                Conversation(Random.nextLong(), account1, account2, arrayListOf(message), true)

            listSeenTrue.add(convo)
        }

        for (i in 11..21) {
            val message = Message(
                Random.nextLong(),
                account1,
                account2,
                "message number $i",
                SimpleDateFormat("HH:mm", Locale.getDefault())
            )
            val convo =
                Conversation(Random.nextLong(), account1, account2, arrayListOf(message), false)

            listSeenFalse.add(convo)
        }

        return mapOf(true to listSeenTrue, false to listSeenFalse)
    }

    override val values: Sequence<Map<Boolean, List<Conversation>>> = sequenceOf(
        generateConvoList()
    )
}