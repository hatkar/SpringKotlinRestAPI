package com.hatmani.employeeservice.utils

import com.hatmani.employeeservice.dto.PersonResponse
import com.hatmani.employeeservice.entity.Person

fun Person?.toPersonResponse(): PersonResponse {
    return PersonResponse(
        id = this?.id ?: 1L,fullname = "${this?.name } ${this?.lastname}")
}