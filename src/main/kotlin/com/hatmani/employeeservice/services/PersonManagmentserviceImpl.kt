package com.hatmani.employeeservice.services

import com.hatmani.employeeservice.dto.AddPersonrequest
import com.hatmani.employeeservice.dto.PersonResponse
import com.hatmani.employeeservice.dto.UpdatePersonRequest
import com.hatmani.employeeservice.repository.PersonRepository
import com.hatmani.employeeservice.utils.AddPersonRequestTransformer
import org.springframework.stereotype.Service

@Service
class PersonManagmentserviceImpl(private  val personrepository:PersonRepository,
                                 private val addPersonRequestTransformer:AddPersonRequestTransformer): PersonManagmentservice {
    override fun findById(id: Long): PersonResponse? {

        TODO("Not yet implemented")
    }

    override fun findAll(): List<PersonResponse> {
        TODO("Not yet implemented")
    }

    override fun save(person: AddPersonrequest): PersonResponse {
        TODO("Not yet implemented")
    }

    override fun update(id: Long, person: UpdatePersonRequest): PersonResponse {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }
}