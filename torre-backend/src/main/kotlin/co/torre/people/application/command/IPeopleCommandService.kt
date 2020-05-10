package co.torre.people.application.command

import co.torre.people.domain.Interests
import co.torre.people.domain.People
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface IPeopleCommandService {

    fun findAndSaveExternalPerson(profileName: String): Flux<Interests>

    fun save(people: People): Mono<People>
}