package com.danix43.messagingapp.data.repositories

import com.danix43.messagingapp.data.datasources.LocalAccountsDS
import com.danix43.messagingapp.data.datasources.RemoteAccountsDS
import com.danix43.messagingapp.data.models.Account

class AccountsRepository(
    private val localAccountsData: LocalAccountsDS,
    private val remoteAccountsData: RemoteAccountsDS
) {

    fun fetchAccountsLocal(): List<Account> {
        return localAccountsData.retrieveLocalData()
    }

}