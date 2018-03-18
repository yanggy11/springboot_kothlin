package com.yanggy.kothlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.transaction.annotation.EnableTransactionManagement

/**
 * @author derrick.yang
 */
@SpringBootApplication
@EnableTransactionManagement
class SpringbootKothlinApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringbootKothlinApplication::class.javaObjectType, *args)
}
