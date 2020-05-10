package co.torre.goal.application.query

import co.torre.goal.adapter.out.persistence.IGoalRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class GoalQueryService(val goalRepository: IGoalRepository): IGoalQueryService {

    override fun findByPeopleId(peopleId: String) = Flux.fromIterable(goalRepository.findByPeopleId(peopleId))

}