package com.hatmani.securityservice.v2.payload.dto

import com.hatmani.securityservice.Entity.User
import com.hatmani.securityservice.v2.payload.SignupRequest

fun SignupRequest?.toUser():User{
    return User(firstname= this?.firstname ?: "",
        lastname=this?.lastname?:"",
        username=this?.username?:"",
        email=this?.email?:"",
        password=this?.password?:"" )
}