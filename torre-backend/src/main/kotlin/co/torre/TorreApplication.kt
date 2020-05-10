package co.torre

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableWebFlux
class TorreApplication

fun main(args: Array<String>) {
	runApplication<TorreApplication>(*args)
}

