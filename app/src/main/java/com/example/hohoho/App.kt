package com.example.hohoho

import android.app.Application

class App: Application() {

    companion object{
        lateinit var instence: App
            private set
    }


    override fun onCreate() {
        super.onCreate()

        instence = this
    }

    override fun onTerminate() {
        super.onTerminate()
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }
}