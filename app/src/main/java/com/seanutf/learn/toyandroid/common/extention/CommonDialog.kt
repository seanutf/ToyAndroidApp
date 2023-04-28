package com.seanutf.learn.toyandroid.common.extention

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.seanutf.learn.toyandroid.base.BaseLifecycleDialog
import kotlinx.coroutines.launch

class CommonDialog(context: Context): BaseLifecycleDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {

        }
        val vm = ViewModelProvider(this)[CommonDialogViewModel::class.java]
    }
}