package com.example.posts.ui.postdetails

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.posts.data.post.PostDataSource
import com.example.posts.data.remote.ApiDefaultResponse
import com.example.posts.di.PostRepositoryQualifier
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "PostDetailsViewModel"

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    @PostRepositoryQualifier private val repository: PostDataSource
) : ViewModel() {

    init {
        Log.d(TAG, "init : ")
        getPostById()
    }

    fun test() {
        Log.d(TAG, "test function called")
    }

    fun getPostById(postId: Int = 1) {
        viewModelScope.launch {
            val result = repository.getPostById(postId)
            when (result) {
                is ApiDefaultResponse.Failed -> {
                    Log.d(TAG, "getPostById: Failed ${result.error}")
                }

                is ApiDefaultResponse.Success -> {
                    Log.d(TAG, "getPostById: Success ${result.body}")
                }
            }
        }
    }

}