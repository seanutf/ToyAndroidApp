package com.seanutf.learn.toyandroid.common.extention

import androidx.annotation.MainThread

/**
 * 本延迟函数要确保
 * 所初始化的数据仅仅在单一线程中使用，无线程竞争的情况下
 * 才可调用
 * 在单一线程中无需考虑数据安全，因此不需要使用
 * lazy{}默认的 SynchronizedLazyImpl 实现
 * 因此适合且不限于主线程使用
 * */
@MainThread
fun <T> lazyInit(initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)

