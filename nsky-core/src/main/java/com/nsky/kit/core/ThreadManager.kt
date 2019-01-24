package com.nsky.kit.core

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Created by zhoubin on 2019/1/22.
 **/
object ThreadManager {
    private var executor: ExecutorService? = null
    fun getInstance():ExecutorService {
        if(executor == null)
        {
            executor = Executors.newFixedThreadPool(10)
        }
        return executor!!
    }

    fun execute(runnable: Runnable) {
        getInstance().execute(runnable)
    }

}
