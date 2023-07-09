package com.example.posts.data.post

import com.example.posts.data.models.Post
import com.example.posts.data.remote.ApiDefaultResponse

interface PostDataSource {

    suspend fun getPosts(): ApiDefaultResponse<List<Post>>

    suspend fun getPostById(postId: Int): ApiDefaultResponse<Post>

}