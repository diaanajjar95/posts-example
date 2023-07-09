package com.example.posts.ui.postslist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.posts.data.models.Post
import com.example.posts.data.post.PostDataSource
import com.example.posts.data.remote.ApiDefaultResponse
import com.example.posts.di.PostRepositoryQualifier
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "PostsListViewModel"

@HiltViewModel
class PostsListViewModel @Inject constructor(
    @PostRepositoryQualifier private val repository: PostDataSource
) : ViewModel() {

    private val _posts: MutableLiveData<List<Post>> = MutableLiveData() // will be changed with koltin flows
    val posts: LiveData<List<Post>> = _posts

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            val result = repository.getPosts()
            when (result) {
                is ApiDefaultResponse.Failed -> {
                    Log.d(TAG, "Failed: ${result.error}")
                }

                is ApiDefaultResponse.Success -> {
                    result.body?.let {
                        _posts.value = it
                    }
                    Log.d(TAG, "Success: ${result.body}")
                }
            }
        }
    }

}