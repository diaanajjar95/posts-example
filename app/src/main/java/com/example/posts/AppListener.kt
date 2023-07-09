package com.example.posts

interface AppListener {

    fun showProgress()
    fun hideProgress()
    fun showMessage(message: String?)

}