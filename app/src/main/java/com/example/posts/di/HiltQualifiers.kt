package com.example.posts.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PostLocalDataSourceQualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PostRemoteDataSourceQualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PostRepositoryQualifier