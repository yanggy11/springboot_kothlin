package com.yanggy.kothlin.model

import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import java.util.*
import javax.persistence.*

/**
 * Created by yangguiyun on 2018/3/14.
 */

@Entity
@Table(name = "k_users")
open class Users :  Serializable{
    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    @Column(name = "id", insertable = true, updatable = true, nullable = false)
    var id: String?
    @Column(name="name", columnDefinition="varchar(100) default ''")
    var name: String

    @Column(name="age", columnDefinition = "int")
    var age : Int

    @Column(name = "create_date",  columnDefinition = "timestamp default current_timestamp", nullable = false)
    var createDate : Date

    @Column(name = "update_date",  columnDefinition = "timestamp  default current_timestamp",  nullable = false)
    var updateDate : Date
    /**
     * 0 未删除
     * 1 已删除
     */
    @Column(name = "delete_flag", columnDefinition = "varchar(2) default '0'", nullable = false)
    var deleteFlag : String

    init {
        this.name = ""
        this.age = 0
        this.id = ""
        this.createDate = Date()
        this.updateDate = Date()
        this.deleteFlag = "0"
    }
}