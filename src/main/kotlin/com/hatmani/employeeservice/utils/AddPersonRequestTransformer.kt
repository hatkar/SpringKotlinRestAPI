package com.hatmani.employeeservice.utils

import com.hatmani.employeeservice.dto.AddPersonrequest
import com.hatmani.employeeservice.entity.Person
import org.springframework.stereotype.Component

@Component
class AddPersonRequestTransformer:Transformer<AddPersonrequest,Person> {
    override fun transform(source: AddPersonrequest): Person {
       return Person(name = source.name,lastname = source.lastname)
    }
}