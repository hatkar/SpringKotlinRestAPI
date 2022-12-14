package com.hatmani.employeeservice.controllers.ressources

import com.hatmani.employeeservice.dto.AddPersonrequest
import com.hatmani.employeeservice.dto.PersonResponse
import com.hatmani.employeeservice.dto.UpdatePersonRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

interface PersonRessource  {
    fun findById(id:Long):ResponseEntity<PersonResponse?>
    fun findAll(pageable: Pageable):ResponseEntity<Page<PersonResponse>>
    fun save(person: AddPersonrequest): ResponseEntity<PersonResponse>
    fun update(id:Long,person: UpdatePersonRequest): ResponseEntity<PersonResponse>
    fun deleteById(id:Long):ResponseEntity<Unit>

}