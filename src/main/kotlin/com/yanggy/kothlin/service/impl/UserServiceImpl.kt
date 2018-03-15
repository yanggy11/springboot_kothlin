package com.yanggy.kothlin.service.impl

import com.yanggy.kothlin.model.Users
import com.yanggy.kothlin.repository.UserRepository
import com.yanggy.kothlin.service.UsersService
import com.yanggy.kothlin.utils.ResponseEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

/**
 * Created by yangguiyun on 2018/3/15.
 */

@Service("userService")
@Transactional
class UserServiceImpl : UsersService{

    @Autowired
    lateinit private var userRepository : UserRepository

    override fun addUser(user : Users) : ResponseEntity<Users>? {
        var res : ResponseEntity<Users> = ResponseEntity()

        res.data = userRepository.save(user)

        return res
    }

    override fun updateUser(user : Users) : ResponseEntity<Users>? {
        var res : ResponseEntity<Users> = ResponseEntity()

        var users : Optional<Users> = userRepository.findById(user.id)
        if(users.isPresent) {
            users.get().name = user.name
        }else {
            res.msg = "用户不存在"
            res.status = "0"
        }

        return res
    }

    override fun deleteUser(user : Users)  : ResponseEntity<Any>? {
        //TODO business logic

        userRepository.deleteById(user.id)

        return ResponseEntity()
    }

    override fun getUsersById(user : Users) : ResponseEntity<Users>? {
        var res : ResponseEntity<Users> = ResponseEntity()

        res.data = userRepository.findById(user.id).orElse(Users("default id"))

        return res
    }

    override fun getUsersList(user : Users) : ResponseEntity<Array<Users>>? {
        return null
    }
}