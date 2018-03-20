package com.yanggy.kothlin.common

/**
 * Created by derrick.yang on 3/15/18.
 */
open class ResponseEntityBuilder {
    /**
     * static method
     */
    companion object {
        fun<T> buildNormalResponse(data : T?) : ResponseEntity<T> {
            var res : ResponseEntity<T> = ResponseEntity()

            res.data = data

            return res
        }

        fun<T> buildErrorResponse(msg : String, status : String) : ResponseEntity<T> {
            var res : ResponseEntity<T> = ResponseEntity()

            res.msg = msg

            res.status = status

            return res
        }
    }
}