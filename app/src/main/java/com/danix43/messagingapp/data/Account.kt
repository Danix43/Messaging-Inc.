package com.danix43.messagingapp.data

data class Account(var id: Long, var name: String, var email: String, var password: String, var friends: Array<Account>)
