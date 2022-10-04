package com.hatmani.employeeservice.controllers

import com.hatmani.employeeservice.controllers.PersonController.Companion.BASE_URL
import com.hatmani.employeeservice.controllers.ressources.PersonRessource
import com.hatmani.employeeservice.dto.AddPersonrequest
import com.hatmani.employeeservice.dto.PersonResponse
import com.hatmani.employeeservice.dto.UpdatePersonRequest
import com.hatmani.employeeservice.services.PersonManagmentservice
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = [BASE_URL])
class PersonController(private val personservice: PersonManagmentservice) : PersonRessource {
    @GetMapping("/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<PersonResponse?> {
        return ResponseEntity.status(HttpStatus.OK).body(personservice.findById(id))
    }

    @GetMapping
    override fun findAll(): ResponseEntity<List<PersonResponse>> {
        return ResponseEntity.ok(personservice.findAll())
    }

    @PostMapping
    override fun save(@RequestBody person: AddPersonrequest): ResponseEntity<PersonResponse> {
        val personCreated = personservice.save(person)
        return ResponseEntity.created(URI.create("${BASE_URL}/${personCreated.id}"))
            .body(personCreated)
    }

    @PutMapping("/{id}")
    override fun update(
        @PathVariable id: Long,
        @RequestBody person: UpdatePersonRequest
    ): ResponseEntity<PersonResponse> {
        return ResponseEntity.ok().body(personservice.update(id, person))
    }

    @DeleteMapping("/{id}")
    override fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        personservice.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    companion object {
        const val BASE_URL = "/api/v1/person"
    }
}