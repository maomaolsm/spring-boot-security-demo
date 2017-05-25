package com.example.kotlin

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by maomao on 17/5/18.
 */
@RestController
@RequestMapping("/kotlin")
open class HelloApi {

    @RequestMapping("/{id}")
    open fun get(@PathVariable id: Long) = "User(id=$id,name=admin,password=123)"

}