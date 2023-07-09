package com.example.posts.data.post

import com.example.posts.data.models.Post
import com.example.posts.data.remote.ApiDefaultResponse
import com.example.posts.di.PostLocalDataSourceQualifier
import com.example.posts.di.PostRemoteDataSourceQualifier
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostRepository @Inject constructor(
    @PostLocalDataSourceQualifier private val localDataSource: PostDataSource,
    @PostRemoteDataSourceQualifier private val remoteDataSource: PostDataSource
) : PostDataSource {

    override suspend fun getPosts(): ApiDefaultResponse<List<Post>> {
        return withContext(Dispatchers.IO) {
            remoteDataSource.getPosts()
        }
    }

    override suspend fun getPostById(postId: Int): ApiDefaultResponse<Post> {
        return withContext(Dispatchers.IO) {
            remoteDataSource.getPostById(postId)
        }
    }

}