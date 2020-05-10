package co.torre.service.people

import co.torre.people.adapter.out.persistence.IPeopleRepository
import co.torre.people.application.query.PeopleQueryService
import co.torre.people.domain.People
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("mock")
class PeopleQueryServiceTest(
        @Autowired val peopleQueryService: PeopleQueryService,
        @Autowired val peopleRepository: IPeopleRepository
) {

    @Test
    fun `Given people in DB and valid id When find then return People Entity`() {
        // given
        insertDataForTest()
        //When
        peopleQueryService.find(1)
                .subscribe {
                    //Then
                    assertEquals(it.name,"TestPlain")
                }
    }

    private fun insertDataForTest() {
        peopleRepository.save(
                People(
                        0,
                        "",
                        "TestPlain",
                        "testplain",
                        "profile"
                )
        )
    }

}