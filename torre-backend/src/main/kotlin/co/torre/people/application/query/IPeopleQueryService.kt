package co.torre.people.application.query

import co.torre.people.domain.People
import reactor.core.publisher.Mono

interface IPeopleQueryService {

    fun find(id: Int): Mono<People>

    fun getOpp(oppId: String, profileName: String): Mono<People>
}