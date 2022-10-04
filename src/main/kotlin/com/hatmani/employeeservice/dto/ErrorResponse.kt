package com.hatmani.employeeservice.dto

import java.time.LocalDateTime

class ErrorResponse(var title:String="Bad Request",var message:String="",val dateTime:LocalDateTime= LocalDateTime.now())