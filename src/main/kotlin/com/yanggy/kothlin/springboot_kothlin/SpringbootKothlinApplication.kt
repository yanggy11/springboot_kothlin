package com.yanggy.kothlin.springboot_kothlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class SpringbootKothlinApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringbootKothlinApplication::class.javaObjectType, *args)
}
