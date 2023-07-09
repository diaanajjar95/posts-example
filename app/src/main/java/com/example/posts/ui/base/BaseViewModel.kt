package com.example.posts.ui.base

import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent

open class BaseViewModel : ViewModel() {

    val loading = LiveEvent<Boolean>()
    val message = LiveEvent<String>()

    open fun onStartLoading() {
        loading.value = true
    }

    open fun onLoadFailure(errorMessage: String) {
        loading.value = false
        message.value = errorMessage
    }

    open fun onLoadSuccess() {
        loading.value = false
    }

}