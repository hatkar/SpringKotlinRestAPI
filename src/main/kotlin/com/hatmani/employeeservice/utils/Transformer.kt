package com.hatmani.employeeservice.utils

interface Transformer<A,B> {
    fun transform(source:A):B
}