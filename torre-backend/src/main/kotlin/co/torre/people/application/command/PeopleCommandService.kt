package co.torre.people.application.command

import co.torre.people.adapter.out.client.PeopleBioClient
import co.torre.people.adapter.out.persistence.IPeopleRepository
import co.torre.people.domain.Interests
import co.torre.people.domain.People
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PeopleCommandService(
        val peopleRepository: IPeopleRepository,
        val peopleClient: PeopleBioClient
): IPeopleCommandService {

    override fun findAndSaveExternalPerson(profileName: String): Flux<Interests> {
        return peopleClient.getBio(profileName)
                .map {
                    peopleRepository.findByProfileName(profileName)
                            .orElseGet { peopleRepository.save(People(
                                        0,
                                        it.person.picture,
                                        it.person.name,
                                        it.person.id,
                                        profileName)
                                )
                            }
                    it.interests
                }
                .flatMapMany { Flux.fromIterable(it) }

    }

    override fun save(people: People) = Mono.just(peopleRepository.save(people))

}