package com.hatmani.employeeservice.services

import com.hatmani.employeeservice.dto.AddPersonrequest
import com.hatmani.employeeservice.dto.PersonResponse
import com.hatmani.employeeservice.dto.UpdatePersonRequest

interface PersonManagmentservice {
    fun findById(id:Long):PersonResponse?
    fun findAll():List<PersonResponse>
    fun save(person:AddPersonrequest):PersonResponse
    fun update(id:Long,person: UpdatePersonRequest):PersonResponse
    fun deleteById(id:Long):Unit
}