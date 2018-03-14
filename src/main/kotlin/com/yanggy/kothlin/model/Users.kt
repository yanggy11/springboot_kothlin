package com.yanggy.kothlin.model

import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import javax.persistence.*

/**
 * Created by yangguiyun on 2018/3/14.
 */

@Entity
@Table(name = "k_users")
open class Users : Serializable{
    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid2")
    @GeneratedValue(generator="systemUUID")
    @Column(name = "id", insertable = true, updatable = true, nullable = false)
    open var id: String = ""

    @Column(name="name")
    open var name: String = ""

    @Column(name="age")
    var age : Int = 0
}