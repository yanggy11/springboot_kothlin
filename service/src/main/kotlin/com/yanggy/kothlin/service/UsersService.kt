package com.yanggy.kothlin.service

import com.yanggy.kothlin.model.Users
import com.yanggy.kothlin.common.ResponseEntity

/**
 * Created by yangguiyun on 2018/3/15.
 */
interface UsersService {
    fun addUser(user : Users) : ResponseEntity<Users>?

    fun updateUser(user : Users) : ResponseEntity<Any>?

    fun deleteUser(user : Users)  : ResponseEntity<Any>?

    fun getUsersById(user : Users) : ResponseEntity<Any>?

    fun getUsersList(user : Users) : ResponseEntity<Any>?
}