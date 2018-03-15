package com.yanggy.kothlin.utils

/**
 * Created by yangguiyun on 2018/3/14.
 */

open class ResponseEntity<T> {
    var status : String
    var msg : String
    var data : T?

    init {
        this.status = "1"
        msg = "请求成功！"
        this.data = null
    }

    fun printMessage() {
        println("hello")
    }
}