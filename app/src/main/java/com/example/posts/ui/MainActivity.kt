package com.example.posts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.posts.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * beneficial links :
 *
 * Navigation Component Guide : https://developer.android.com/guide/navigation/get-started
 * GitHub add Your Android Project Guide : https://medium.com/@alessandro.lombardi.089/how-to-push-an-android-studio-project-to-github-via-command-line-20fca1262beb
 * Dagger Hilt Guide : https://developer.android.com/training/dependency-injection/hilt-android
 *
 * */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

/**
 * NOTES :
 *
 * Dagger Hilt : you must annotate Hilt modules with @InstallIn to tell Hilt which Android class each module will be used or installed in.
 * Dagger Hilt : Dependencies that you provide in Hilt modules are available in all generated components that are associated with the Android class where you install the Hilt module.
 *
 *
 * */