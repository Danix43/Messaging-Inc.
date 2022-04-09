package com.danix43.messagingapp.data.models

data class Account(
    var id: Long,
    var name: String,
    var email: String,
    var password: String,
    var friends: Array<Account>
)
