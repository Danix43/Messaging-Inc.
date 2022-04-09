package com.danix43.messagingapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danix43.messagingapp.data.models.Account
import com.danix43.messagingapp.data.models.Conversation
import com.danix43.messagingapp.data.models.Message
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

class MainActivityViewModel : ViewModel() {

    private val TAG = "MainActivityViewModel"

    private val conversations: MutableLiveData<List<Conversation>> by lazy {
        MutableLiveData<List<Conversation>>().also {
            loadConversations()
        }
    }

    fun retrieveHeaderMessage(): String {
        val time = SimpleDateFormat("HH", Locale.getDefault()).toString()

        var addressing = ""
        if (time == "12") {
            addressing = "Good noon"
        }
        if (time >= "12") {
            addressing = "Good afternoon"
        }
        if (time <= "12") {
            addressing = "Good morning"
        }
        return addressing
    }

    fun getConversations(): LiveData<Map<Boolean, List<Conversation>>> {
        val account1 =
            Account(Random(1233).nextLong(), "User 1", "email1@gmail.com", "1234", emptyArray())
        val account2 =
            Account(Random(1233).nextLong(), "User 1", "email1@gmail.com", "1234", emptyArray())

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

        return MutableLiveData(mapOf(true to listSeenTrue, false to listSeenFalse))
    }

    private fun loadConversations() {
        Log.d(TAG, "loadConversations: loading conversations")
    }

    fun createNewConvo() {
        Log.d(TAG, "createNewConvo: clicked")
    }


    private fun generateConversations() {

    }

}
