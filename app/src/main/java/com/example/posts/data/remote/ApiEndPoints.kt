package com.example.posts.data.remote

import com.example.posts.data.models.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoints {

    @GET("posts/")
    suspend fun getPosts(): Response<List<Post>>

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") postId: Int): Response<Post>

}