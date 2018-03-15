package com.yanggy.kothlin.model

import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import javax.persistence.*

/**
 * Created by yangguiyun on 2018/3/14.
 */

@Entity
@Table(name = "k_users")
data class Users(  @Id
                   @GenericGenerator(name="systemUUID",strategy="uuid")
                   @GeneratedValue(generator="systemUUID")
                   @Column(name = "id", insertable = true, updatable = true, nullable = false)
                   var id: String?) : Serializable{

    @Column(name="name")
    var name: String

    @Column(name="age")
    var age : Int

    init {
        this.name = ""
        this.age = 0
    }
    //default constructor
    constructor() : this("") {

    }
}