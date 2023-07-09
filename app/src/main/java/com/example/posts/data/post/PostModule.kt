package com.example.posts.data.post

import com.example.posts.data.remote.ApiEndPoints
import com.example.posts.di.PostLocalDataSourceQualifier
import com.example.posts.di.PostRemoteDataSourceQualifier
import com.example.posts.di.PostRepositoryQualifier
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostModule {

    @PostLocalDataSourceQualifier
    @Provides
    @Singleton
    fun providePostLocalDataSource(): PostDataSource {
        return PostLocalDataSource()
    }

    @PostRemoteDataSourceQualifier
    @Provides
    @Singleton
    fun providePostRemoteDataSource(apiEndPoints: ApiEndPoints): PostDataSource {
        return PostRemoteDataSource(apiEndPoints)
    }

    @PostRepositoryQualifier
    @Provides
    @Singleton
    fun providePostRepository(
        @PostLocalDataSourceQualifier localDataSource: PostDataSource,
        @PostRemoteDataSourceQualifier remoteDataSource: PostDataSource
    ): PostDataSource {
        return PostRepository(localDataSource, remoteDataSource)
    }
}