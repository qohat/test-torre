package co.torre.people.application.query

import co.torre.people.adapter.out.client.PeopleBioClient
import co.torre.people.adapter.out.persistence.IPeopleRepository
import co.torre.people.domain.People
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class PeopleQueryService(
        val peopleRepository: IPeopleRepository,
        val peopleClient: PeopleBioClient
): IPeopleQueryService {

    override fun find(id: Int) =
            Mono.just(peopleRepository.findById(id)
                    .orElse(
                            People(
                                    0,
                                    "",
                                    "",
                                    "",
                                    ""
                            )
                    )
            )

    override fun getOpp(oppId: String, profileName: String): Mono<People> {
        return Mono.just(People(1, "", "", "", ""))
    }
}