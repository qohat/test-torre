package co.torre.people.adapter.out.client

import co.torre.infrastructure.error.ErrorException
import co.torre.people.domain.Bio
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class PeopleBioClient {

    @Value("\${rest.torre}")
    val baseUrl: String = ""

    val bioBase = "/bios"

    val oppBase = "/opportunities"

    fun getBio(profileName: String) =
            WebClient.create(baseUrl)
                    .get()
                    .uri("$baseUrl$bioBase/{profileName}", profileName)
                    .retrieve()
                    .bodyToMono(Bio::class.java)
                    .doOnError { throw ErrorException("Failed geting data from Torre bio service", HttpStatus.INTERNAL_SERVER_ERROR) }

    fun getOpp(id: String) =
            WebClient.create(baseUrl)
                    .get()
                    .uri("$baseUrl$oppBase/{id}", id)
                    .retrieve()
                    .bodyToMono(Bio::class.java)
                    .doOnError { throw ErrorException("Failed geting data from Torre opp service", HttpStatus.INTERNAL_SERVER_ERROR) }
}
