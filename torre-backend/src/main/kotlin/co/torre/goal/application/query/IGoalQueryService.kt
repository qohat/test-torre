package co.torre.goal.application.query

import co.torre.goal.domain.Goal
import reactor.core.publisher.Flux

interface IGoalQueryService {

    fun findByPeopleId(peopleId: String): Flux<Goal>
}