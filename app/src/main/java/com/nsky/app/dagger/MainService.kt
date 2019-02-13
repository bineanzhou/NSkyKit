package com.nsky.app.dagger

/**
 * Created by zhoubin on 2019/1/31.
 **/
interface MainService {
    fun getMainInfo():String
}
class MainServiceImpl :MainService {
    override fun getMainInfo(): String {
        return "This is main info"
    }
}
