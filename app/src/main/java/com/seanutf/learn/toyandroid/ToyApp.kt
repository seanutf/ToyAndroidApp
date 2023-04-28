package com.seanutf.learn.toyandroid

import android.app.Application
import com.seanutf.learn.toyandroid.base.AppInstanceStore

class ToyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        AppInstanceStore.app = this
    }
}