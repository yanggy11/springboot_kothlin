package com.yanggy.kothlin.utils

import java.io.Serializable

/**
 * Created by yangguiyun on 2018/3/14.
 */

open class ResponseEntity<T> : Serializable{

    var status : String
    var msg : String
    var data : T?

    /**
     * initialize member properties
     */
    init {
        this.status = Constants.SUCCESS_STATUS
        msg = Constants.SUCCESS_MSG
        this.data = null
    }
}