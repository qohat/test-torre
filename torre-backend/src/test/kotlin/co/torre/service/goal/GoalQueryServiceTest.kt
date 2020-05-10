package co.torre.service.goal

import co.torre.goal.adapter.out.persistence.IGoalRepository
import co.torre.goal.application.query.GoalQueryService
import co.torre.goal.domain.Goal
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.util.*

@SpringBootTest
@ActiveProfiles("mock")
class GoalQueryServiceTest(
        @Autowired val goalQueryService: GoalQueryService,
        @Autowired val goalRepository: IGoalRepository
) {

    @Test
    fun `Given valid peopleId and Exist Goals then Return Goals`() {
        //Given
        saveGoal()
        //When
        goalQueryService.findByPeopleId("peopleId")
                .collectList()
                .subscribe {
                    //Then
                    assertEquals(it[0].interestName, "interestName")
                }
    }

    private fun saveGoal() {
        goalRepository.save(
                Goal(
                        0,
                        "peopleId",
                        "interestId",
                        "interestName",
                        null,
                        Date(),
                        12
                )
        )
    }
}