package co.torre.goal.adapter.out.persistence

import co.torre.goal.domain.Goal
import org.springframework.data.jpa.repository.JpaRepository

interface IGoalRepository: JpaRepository<Goal, Int> {

    fun findByPeopleId(peopleId: String): List<Goal>

    fun findByInterestId(iId: String): Goal?
}