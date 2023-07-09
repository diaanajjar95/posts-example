package com.example.posts.ui.postslist

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val TAG = "PostsListViewModel"

@HiltViewModel
class PostsListViewModel @Inject constructor(

) : ViewModel() {

    init {
        Log.d(TAG, "init : ")
    }

    fun test() {
        Log.d(TAG, "test function called")
    }

}