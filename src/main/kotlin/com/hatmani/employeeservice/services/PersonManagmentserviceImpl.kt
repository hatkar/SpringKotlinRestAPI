package com.hatmani.employeeservice.services

import com.hatmani.employeeservice.dto.AddPersonrequest
import com.hatmani.employeeservice.dto.PersonResponse
import com.hatmani.employeeservice.dto.UpdatePersonRequest
import com.hatmani.employeeservice.entity.Person
import com.hatmani.employeeservice.repository.PersonRepository
import com.hatmani.employeeservice.utils.AddPersonRequestTransformer
import com.hatmani.employeeservice.utils.toPersonResponse
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonManagmentserviceImpl(
    private val personrepository: PersonRepository,
    private val addPersonRequestTransformer: AddPersonRequestTransformer
) : PersonManagmentservice {

    override fun findById(id: Long): PersonResponse? =
        this.findPersonById(id).toPersonResponse()
            ?: throw IllegalStateException("Person with Id ${id} does't exist")


    override fun findAll(): List<PersonResponse> = this.personrepository.findAll().map { p -> p.toPersonResponse() }

    override fun save(person: AddPersonrequest): PersonResponse {
        return this.saveorupdate(addPersonRequestTransformer.transform(person)).toPersonResponse()
    }

    override fun update(id: Long, person: UpdatePersonRequest): PersonResponse {
        val personInDb = this.findPersonById(id) ?: throw IllegalStateException("Person with Id ${id} does't exist")
        return this.saveorupdate(personInDb
            .apply {
                this.name = person.name
                this.lastname = person.lastname
            })
            .toPersonResponse()
    }

    override fun deleteById(id: Long) = this.personrepository.deleteById(id)

    private fun findPersonById(id: Long): Person {
        return personrepository.findById(id).get()

    }

    private fun saveorupdate(person: Person): Person {
        return personrepository.save(person)
    }
}