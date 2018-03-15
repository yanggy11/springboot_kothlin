package com.yanggy.kothlin.repository

import com.yanggy.kothlin.model.Users
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

/**
 * Created by yangguiyun on 2018/3/14.
 */

@Repository
interface UserRepository : PagingAndSortingRepository<Users , String>{
    fun findByName(name : String) : Users?

    @Transactional
    @Modifying
    @Query("update Users u set u.name = ?1 where u.id = ?2")
    fun updateUserById(id : String?, name : String)
}