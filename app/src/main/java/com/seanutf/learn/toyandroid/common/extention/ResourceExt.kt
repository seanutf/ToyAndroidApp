package com.seanutf.learn.toyandroid.common.extention

import android.content.Context
import android.util.TypedValue

/**
 * @Desc 针对Resource级别的各种扩展函数或内连函数库，工具类
 */
context(Context)
val Float.dp: Float
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        resources.displayMetrics
    )

val Number.dp: Int
    get() = this.toFloat().dp.toInt()

context(Context)
val Number.sp: Float
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        this.toFloat(),
        resources.displayMetrics
    )