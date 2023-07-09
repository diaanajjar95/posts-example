package com.example.posts.data.post

import com.example.posts.data.models.Post
import com.example.posts.data.remote.ApiDefaultResponse
import com.example.posts.data.remote.ApiEndPoints
import javax.inject.Inject

class PostRemoteDataSource @Inject constructor(
    private val apiEndPoints: ApiEndPoints
) : PostDataSource {

    override suspend fun getPosts(): ApiDefaultResponse<List<Post>> {
        return try {
            ApiDefaultResponse.create(apiEndPoints.getPosts())
        } catch (e: Exception) {
            ApiDefaultResponse.create(e)
        }
    }

    override suspend fun getPostById(postId: Int): ApiDefaultResponse<Post> {
        return try {
            ApiDefaultResponse.create(apiEndPoints.getPostById(postId))
        } catch (e: Exception) {
            ApiDefaultResponse.create(e)
        }
    }

}