package co.torre.service.people

import co.torre.people.application.command.PeopleCommandService
import co.torre.people.domain.People
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("mock")
class PeopleCommandServiceTest(@Autowired val peopleCommandService: PeopleCommandService) {

    @Test
    fun `Given a valid profileName When findAndSaveExternalPerson then saveExternalPerson`() {
        peopleCommandService.findAndSaveExternalPerson("qohatpretelpolo")
                .collectList()
                .subscribe {
                    assertTrue(it.size > 0)
                }
    }

    @Test
    fun `Given a invalid profileName When findAndSaveExternalPerson then saveExternalPerson`() {
        peopleCommandService.findAndSaveExternalPerson("qohatpretelpolo123")
                .collectList()
                .subscribe {
                    assertTrue(it.size == 0)
                }
    }

    @Test
    fun `Given a valid people object When Save then save`() {
        peopleCommandService.save(
                    People(
                        0,
                        "picture",
                        "Name",
                        "TestName",
                        "profilename"
                    )
                )
                .subscribe {
                    assertTrue(it.id > 0)
                }
    }
}