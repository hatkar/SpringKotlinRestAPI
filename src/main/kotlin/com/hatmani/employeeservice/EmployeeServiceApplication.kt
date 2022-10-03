package com.hatmani.employeeservice

import com.hatmani.employeeservice.entity.Person
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class EmployeeServiceApplication
{
    @GetMapping("/")
    fun ping(): Person
    {
        println("receiveing get ...")
        var Empl:Person= Person(1,"Karim","Hatmani")
        println("returning get ...")
        return Empl
    }
}


fun main(args: Array<String>) {
    runApplication<EmployeeServiceApplication>(*args)
}
