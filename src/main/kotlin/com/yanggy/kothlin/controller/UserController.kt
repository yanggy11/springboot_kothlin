package com.yanggy.kothlin.controller

import com.yanggy.kothlin.ResponseEntity
import com.yanggy.kothlin.model.Users
import com.yanggy.kothlin.repository.UserRepository
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
open class UserController {
    @Autowired
    lateinit  var userRepository : UserRepository

    @PostMapping(value = "/addUser")
    fun save(@RequestBody user : Users) : ResponseEntity<Users> {

        var users : Users =  userRepository.save(user)

        var res : ResponseEntity<Users> = ResponseEntity()

        res.status = "1"

        res.printMessage();

        return res
    }
}