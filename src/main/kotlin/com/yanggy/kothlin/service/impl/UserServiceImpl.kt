package com.yanggy.kothlin.service.impl

import com.yanggy.kothlin.model.Users
import com.yanggy.kothlin.repository.UserRepository
import com.yanggy.kothlin.service.UsersService
import com.yanggy.kothlin.utils.Constants
import com.yanggy.kothlin.utils.ResponseEntity
import com.yanggy.kothlin.utils.ResponseEntityBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

/**
 * Created by yangguiyun on 2018/3/15.
 */

@Service("userService")
@Transactional
open class UserServiceImpl : UsersService{

    @Autowired
    lateinit private var userRepository : UserRepository

    override fun addUser(user : Users) : ResponseEntity<Any>? {
        var res : ResponseEntity<Any> = ResponseEntity()

        res.data = userRepository.save(user)

        return ResponseEntityBuilder.buildNormalResponse(userRepository.save(user))
    }

    override fun updateUser(user : Users) : ResponseEntity<Any>? {
        var res : ResponseEntity<Any>? = null

        var users : Optional<Users> = userRepository.findById(user.id)
        if(users.isPresent) {
            users.get().name = user.name

            res = ResponseEntityBuilder.buildNormalResponse(users.get())
        }else {
            res = ResponseEntityBuilder.buildErrorResponse("0", "")
        }

        return res
    }

    override fun deleteUser(user : Users)  : ResponseEntity<Any>? {
        //TODO business logic

        userRepository.deleteById(user.id)

        return ResponseEntityBuilder.buildNormalResponse(null)
    }

    override fun getUsersById(user : Users) : ResponseEntity<Any>? {

        return ResponseEntityBuilder.buildNormalResponse(userRepository.findById(user.id).orElse(Users(Constants.DEFAULT_USER_ID)))
    }

    override fun getUsersList(user : Users) : ResponseEntity<Any>? {
        return ResponseEntityBuilder.buildNormalResponse(userRepository.findAll())
    }
}