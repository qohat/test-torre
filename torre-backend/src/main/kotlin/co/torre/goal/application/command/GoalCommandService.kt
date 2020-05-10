package co.torre.goal.application.command

import co.torre.goal.adapter.out.persistence.IGoalRepository
import co.torre.goal.domain.Goal
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class GoalCommandService(val goalRepository: IGoalRepository): IGoalCommandService {

    override fun save(goal: Goal) = Mono.just(goalRepository.save(goal))

    override fun saveAll(goals: List<Goal>) =
            Flux.fromIterable(
                    goals.map {
                        goalRepository.findByInterestId(it.interestId) ?: goalRepository.save(it)
                    }
            )

}