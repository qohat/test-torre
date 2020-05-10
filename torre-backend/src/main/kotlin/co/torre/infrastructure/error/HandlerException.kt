package co.torre.infrastructure.error

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class HandlerException {

    @ExceptionHandler
    fun hadlerException(e: ErrorException): ResponseEntity<String> {
        return return ResponseEntity(e.message!!, e.code)
    }
}