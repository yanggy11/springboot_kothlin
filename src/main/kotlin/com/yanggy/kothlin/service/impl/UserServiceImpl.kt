package com.yanggy.kothlin.service.impl

import com.yanggy.kothlin.model.Users
import com.yanggy.kothlin.repository.UserRepository
import com.yanggy.kothlin.service.UsersService
import com.yanggy.kothlin.utils.ResponseEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by yangguiyun on 2018/3/15.
 */

@Service("userService")
class UserServiceImpl : UsersService{

    @Autowired
    lateinit private var userRepository : UserRepository

    override fun addUser(user : Users) : ResponseEntity<Users>? {
        var res : ResponseEntity<Users> = ResponseEntity()

        res.data = userRepository.save(user)

        return res
    }

    override fun updateUser(user : Users) : ResponseEntity<Users>? {
        userRepository.updateUserById(user.id,  user.name)
        return null
    }

    override fun deleteUser(user : Users)  : ResponseEntity<Any>? {
        return null
    }

    override fun getUsersById(user : Users) : ResponseEntity<Users>? {
        return null
    }

    override fun getUsersList(user : Users) : ResponseEntity<Array<Users>>? {
        return null
    }
}