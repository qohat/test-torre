package co.torre.infrastructure.error

import lombok.Getter
import org.springframework.http.HttpStatus

@Getter
class ErrorException(
    override val message: String,
    val code: HttpStatus
): RuntimeException()