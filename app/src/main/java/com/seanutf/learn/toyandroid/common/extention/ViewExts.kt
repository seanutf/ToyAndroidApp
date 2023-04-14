package com.seanutf.learn.toyandroid.common.extention

import android.view.View
import androidx.constraintlayout.widget.Group
import androidx.viewbinding.ViewBinding
import com.seanutf.learn.toyandroid.common.NoDoubleClickListener

/**
 * @Desc 针对View级别的各种扩展函数或内连函数库，工具类
 */

fun ViewBinding.visible() {
    root.visibility = View.VISIBLE
}

fun ViewBinding.invisible() {
    root.visibility = View.INVISIBLE
}

fun ViewBinding.gone() {
    root.visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

/**
 * 防止View连续点击
 * */
inline fun View.setNoDoubleClickListener(crossinline click: () -> Unit) {
    setOnClickListener(object : NoDoubleClickListener() {
        override fun onNoDoubleClick(v: View?) {
            click.invoke()
        }
    })
}

/**
 * 为ConstraintLayout中的Group组件
 * 所关联的View添加点击事件
 * */
inline fun Group.setAllOnClickListener(crossinline click: () -> Unit) {
    referencedIds.forEach { id ->
        rootView.findViewById<View>(id)?.setNoDoubleClickListener(click)
    }
}
