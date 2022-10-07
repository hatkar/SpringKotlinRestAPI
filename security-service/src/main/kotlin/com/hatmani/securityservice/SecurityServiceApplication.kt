package com.hatmani.securityservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude =[SecurityAutoConfiguration::class])
class SecurityServiceApplication

fun main(args: Array<String>) {
    runApplication<SecurityServiceApplication>(*args)
}