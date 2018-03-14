package com.yanggy.kothlin

import lombok.Data

/**
 * Created by yangguiyun on 2018/3/14.
 */

open class ResponseEntity<T> {
    var status : String
    var msg : String

    init {
        this.status = ""
        msg = "请求成功！"
    }

    fun printMessage() {
        println("hello")
    }
}