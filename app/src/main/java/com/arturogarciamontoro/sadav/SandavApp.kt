package com.arturogarciamontoro.sadav

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SandavApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}