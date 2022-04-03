package com.danix43.messagingapp.data.models

data class Message(var id: Long, var sender: Account, var receiver: Account, var content: String, var date: Long)
