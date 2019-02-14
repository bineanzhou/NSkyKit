/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.nsky.kit.utils

import android.util.LruCache
import com.nsky.kit.utils.ThrottleUtils.sThreadLocal
import com.orhanobut.logger.Logger
import java.lang.Thread.currentThread


/**
 * 重复点击等操作仅响应一次
 */
object ThrottleUtils {
    @JvmStatic
    val sThreadLocal by lazy { ThreadLocal<LruCache<Int, Long>>() }
}

/**
 * 注意：
 * 此函数存在的目的是用于对页面跳转等因用户手动操作(如快速点击)容易出现多次重复行为的规避。
 * - tag 用户对行为的标识，默认为调用方
 * - off 表示关闭限制，默认为false
 * - offset 单位毫秒，表示两次行为之间的时间间隙，默认为1000
 * */

fun <T, R> T.throttleFirst(tag: Any? = null, offset: Int = 1000, off: Boolean = false, block: T.() -> R): R? {
    val map = sThreadLocal.get() ?: LruCache<Int, Long>(1.shl(8)).apply {
        sThreadLocal.set(this)
    }
    //
    val key = tag?.hashCode() ?: this?.hashCode() ?: currentThread().hashCode()
    val current = System.currentTimeMillis()
    val last = map[key] ?: 0L
    map.put(key, current)
    //
    if (AppManager.isAppDebug()) {
        Logger.d("singleAction valid = ${(current - last) >= offset}, off=$off, offset=$offset, offset = ${current - last} ${this} ")
    }
    if (off || (current - last) >= offset) {
        return block()
    }
    return null
}