package co.torre.goal.application.command

import co.torre.goal.domain.Goal
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface IGoalCommandService {

    fun save(goal: Goal): Mono<Goal>

    fun saveAll(goals: List<Goal>): Flux<Goal>

}