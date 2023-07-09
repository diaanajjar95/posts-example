package com.example.posts.data.post

import com.example.posts.data.models.Post
import com.example.posts.data.remote.ApiDefaultResponse
import javax.inject.Inject

class PostLocalDataSource @Inject constructor(
    /** Room instance will be added here soon.*/
) : PostDataSource {

    override suspend fun getPosts(): ApiDefaultResponse<List<Post>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPostById(postId: Int): ApiDefaultResponse<Post> {
        TODO("Not yet implemented")
    }

}