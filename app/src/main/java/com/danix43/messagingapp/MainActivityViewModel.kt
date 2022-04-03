package com.danix43.messagingapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danix43.messagingapp.data.models.Conversation

class MainActivityViewModel : ViewModel() {

    private val TAG = "MainActivityViewModel"

    private val conversations: MutableLiveData<List<Conversation>> by lazy {
        MutableLiveData<List<Conversation>>().also {
            loadConversations()
        }
    }

    fun getConversations(): LiveData<List<Conversation>> {
        return conversations
    }

    private fun loadConversations() {
        Log.d(TAG, "loadConversations: loading conversations")
    }

    fun createNewConvo() {
        Log.d(TAG, "createNewConvo: clicked")
    }

}
