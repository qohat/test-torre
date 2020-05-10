package co.torre.goal.adapter.`in`.http

import co.torre.goal.application.command.GoalCommandService
import co.torre.goal.application.query.GoalQueryService
import co.torre.goal.domain.Goal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/goals")
class GoalRouting(
        val goalCommandService: GoalCommandService,
        val goalQueryService: GoalQueryService
) {
    @GetMapping("/{peopleId}")
    fun getByPeopleId(@PathVariable("peopleId") peopleId: String) =
            goalQueryService.findByPeopleId(peopleId)

    @PostMapping("/all")
    fun saveAll(@RequestBody goals: List<Goal>) =
            goalCommandService.saveAll(goals)
}