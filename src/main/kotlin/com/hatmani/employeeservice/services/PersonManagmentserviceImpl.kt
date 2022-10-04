package com.hatmani.employeeservice.services

import com.hatmani.employeeservice.dto.AddPersonrequest
import com.hatmani.employeeservice.dto.PersonResponse
import com.hatmani.employeeservice.dto.UpdatePersonRequest
import com.hatmani.employeeservice.entity.Person
import com.hatmani.employeeservice.repository.PersonRepository
import com.hatmani.employeeservice.utils.AddPersonRequestTransformer
import com.hatmani.employeeservice.utils.toPersonResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service



@Service
class PersonManagmentserviceImpl(
    private val personrepository: PersonRepository,
    private val addPersonRequestTransformer: AddPersonRequestTransformer
) : PersonManagmentservice {

    override fun findById(id: Long): PersonResponse? {
        val person = this.findPersonById(id)
            ?: throw IllegalStateException("Person with Id $id does't exist")

        return person.toPersonResponse()

    }


    override fun findAll(pageable: Pageable): Page<PersonResponse> =
        this.personrepository.findAll(pageable).map { p -> p.toPersonResponse() }

    override fun save(person: AddPersonrequest): PersonResponse {
        return this.saveorupdate(addPersonRequestTransformer.transform(person)).toPersonResponse()
    }

    override fun update(id: Long, person: UpdatePersonRequest): PersonResponse {
        val personInDb = this.findPersonById(id)
            ?: throw IllegalStateException("Person with Id $id does't exist")
        return this.saveorupdate(personInDb
            .apply {
                this.name = person.name
                this.lastname = person.lastname
            })
            .toPersonResponse()
    }

    override fun deleteById(id: Long) = this.personrepository.deleteById(id)

    private fun findPersonById(id: Long): Person? = personrepository.findByIdOrNull(id)


    private fun saveorupdate(person: Person): Person {
        return personrepository.save(person)
    }
}