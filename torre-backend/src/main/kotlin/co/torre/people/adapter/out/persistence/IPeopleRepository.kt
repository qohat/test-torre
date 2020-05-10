package co.torre.people.adapter.out.persistence

import co.torre.people.domain.People
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface IPeopleRepository: JpaRepository<People, Int> {

    fun findByProfileName(profileName: String): Optional<People>

}