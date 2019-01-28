package com.nsky.kit.ext



inline fun <Type, R> Type.applySafe(action: Type.() -> R): R? {
    try {
        return action()
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}

