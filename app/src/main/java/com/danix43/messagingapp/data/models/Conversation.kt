package com.danix43.messagingapp.data.models

data class Conversation(
    var id: Long,
    var sender: Account,
    var receiver: Account,
    var messages: List<Message>
)
