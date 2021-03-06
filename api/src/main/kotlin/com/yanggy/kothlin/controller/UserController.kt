package com.yanggy.kothlin.controller

import com.yanggy.kothlin.model.Users
import com.yanggy.kothlin.service.UsersService
import com.yanggy.kothlin.common.ResponseEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by yangguiyun on 2018/3/14.
 */

@RestController
@RequestMapping("/user")
class UserController {
    @Autowired
    lateinit var userService : UsersService

    @PostMapping(value = "/addUser")
    fun save(@RequestBody user : Users) : ResponseEntity<Users>? {
        return userService.addUser(user)
    }

    @PostMapping(value = "/updateUser")
    fun updateUser(@RequestBody user : Users) : ResponseEntity<Any>? {
        return userService.updateUser(user)
    }

    @PostMapping(value = "/deleteUser")
    fun deleteUser(@RequestBody user : Users)  : ResponseEntity<Any>? {
        return userService.deleteUser(user)
    }

    @PostMapping(value = "/getUsersById")
    fun getUsersById(@RequestBody user : Users) : ResponseEntity<Any>? {
        return userService.getUsersById(user)
    }

    @PostMapping(value = "/getUsersList")
    fun getUsersList(@RequestBody user : Users) : ResponseEntity<Any>? {
        return userService.getUsersList(user)
    }
}