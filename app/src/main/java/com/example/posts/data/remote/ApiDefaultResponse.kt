package com.example.posts.data.remote

import retrofit2.Response

sealed class ApiDefaultResponse<T> {

    data class Failed<T>(val error: Throwable) : ApiDefaultResponse<T>()
    data class Success<T>(val body: T?) : ApiDefaultResponse<T>()

    companion object {

        fun <T> create(response: Response<T>): ApiDefaultResponse<T> {
            return if (response.isSuccessful) {
                val body = response.body()
                Success(body)
            } else
                Failed(Exception())
        }

        fun <T> create(error: Throwable): Failed<T> {
            return Failed(error)
        }

    }

}