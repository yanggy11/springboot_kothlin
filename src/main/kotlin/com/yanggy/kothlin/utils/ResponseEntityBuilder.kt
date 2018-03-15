package com.yanggy.kothlin.utils

import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

/**
 * Created by derrick.yang on 3/15/18.
 */
open class ResponseEntityBuilder {
    /**
     * static method
     */
    companion object {
        fun buildNormalResponse(data : Any?) : ResponseEntity<Any> {
            var res : ResponseEntity<Any> = ResponseEntity()

            res.data = data

            return res
        }

        fun buildErrorResponse(msg : String, status : String) : ResponseEntity<Any> {
            var res : ResponseEntity<Any> = ResponseEntity()

            res.msg = msg

            res.status = status

            return res
        }
    }
}