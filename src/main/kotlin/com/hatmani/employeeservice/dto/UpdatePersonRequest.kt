package com.hatmani.employeeservice.dto

data class UpdatePersonRequest(var id:Long,var name:String ,var lastname:String?=null)