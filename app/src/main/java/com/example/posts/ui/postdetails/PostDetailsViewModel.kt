package com.example.posts.ui.postdetails

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val TAG = "PostDetailsViewModel"

@HiltViewModel
class PostDetailsViewModel @Inject constructor(

): ViewModel() {

    init {
        Log.d(TAG, "init : ")
    }

    fun test(){
        Log.d(TAG, "test function called")
    }

}