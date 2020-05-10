package co.torre.service.goal

import co.torre.goal.application.command.GoalCommandService
import co.torre.goal.domain.Goal
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.util.*

@SpringBootTest
@ActiveProfiles("mock")
class GoalCommandServiceTest(
        @Autowired val goalCommandService: GoalCommandService
) {

    @Test
    fun `Given a list of goals When saveAll then Save All goals`() {
        val goals = listOf(
                Goal(
                0,
                    "peopleId",
                    "interestId",
                    "interestName",
                    null,
                    Date(),
                    12
                ),
                Goal(
                        0,
                        "peopleId",
                        "interestId1",
                        "interestName1",
                        null,
                        Date(),
                        23
                )
        )

        goalCommandService.saveAll(goals)
                .collectList()
                .subscribe {
                    assertTrue(it.size > 0)
                }
    }
}