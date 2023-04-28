package com.seanutf.learn.toyandroid.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialog
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

open class BaseLifecycleDialog @JvmOverloads constructor(
    context: Context,
    theme: Int = 0,
) : AppCompatDialog(context, theme), LifecycleOwner, ViewModelStoreOwner,
    HasDefaultViewModelProviderFactory {

    private val dialogLifecycleRegistry = LifecycleRegistry(this)

    override val viewModelStore: ViewModelStore
        get() {
            return ViewModelStore()
        }
    override val lifecycle: Lifecycle
        get() {
            return dialogLifecycleRegistry
        }

    override val defaultViewModelProviderFactory: ViewModelProvider.Factory
        get() {
            return ViewModelProvider.AndroidViewModelFactory.getInstance(AppInstanceStore.app)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialogLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
    }

    override fun dismiss() {
        super.dismiss()
        viewModelStore.clear()
    }

    override fun onStart() {
        super.onStart()
        dialogLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
    }

    override fun onStop() {
        super.onStop()
        dialogLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (lifecycle.currentState == Lifecycle.State.STARTED) {
            dialogLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        if (lifecycle.currentState == Lifecycle.State.RESUMED) {
            dialogLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        }
    }
}