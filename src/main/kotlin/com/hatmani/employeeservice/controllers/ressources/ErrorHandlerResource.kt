package com.hatmani.employeeservice.controllers.ressources

import com.hatmani.employeeservice.dto.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.function.EntityResponse

@ControllerAdvice
class ErrorHandlerResource {
    @ExceptionHandler(IllegalStateException::class)
    fun handleIllegalState(ex:IllegalStateException): ResponseEntity<ErrorResponse> {
     return   ResponseEntity.badRequest()
            .body(ErrorResponse(message=ex.localizedMessage ))
    }
}