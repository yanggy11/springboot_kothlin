package com.yanggy.kothlin.repository

import com.yanggy.kothlin.model.Users
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

/**
 * Created by yangguiyun on 2018/3/14.
 */

@Repository
interface UserRepository : PagingAndSortingRepository<Users , String>{
    fun findByName(name : String) : List<Users>?
}