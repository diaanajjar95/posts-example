package com.example.posts.ui.postdetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.posts.data.models.Post
import com.example.posts.data.post.PostDataSource
import com.example.posts.data.remote.ApiDefaultResponse
import com.example.posts.di.PostRepositoryQualifier
import com.example.posts.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "PostDetailsViewModel"

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    @PostRepositoryQualifier private val repository: PostDataSource
) : BaseViewModel() {

    private val _post: MutableLiveData<Post> =
        MutableLiveData() // will be changed with koltin flows
    val post: LiveData<Post> = _post

    fun getPostById(postId: Int = 1) {
        onStartLoading()
        viewModelScope.launch {
            when (val result = repository.getPostById(postId)) {
                is ApiDefaultResponse.Failed -> {
                    Log.d(TAG, "getPostById: Failed ${result.error}")
                    result.error.localizedMessage?.let { onLoadFailure(it) }
                }

                is ApiDefaultResponse.Success -> {
                    result.body?.let {
                        _post.value = it
                    }
                    Log.d(TAG, "getPostById: Success ${result.body}")
                    onLoadSuccess()
                }
            }
        }
    }

}