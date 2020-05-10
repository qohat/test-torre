package co.torre.service.listitem

import co.torre.listitem.application.query.IListItemService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("mock")
class ListItemQueryTest(
        @Autowired val listItemService: IListItemService
) {

    @Test
    fun `Given key_id When query ListItem then return a list of ListItem`() {
        listItemService.findByKeyId("LEVELS")
                .collectList()
                .subscribe {
                    assertTrue(it.size > 0)
                }
    }
}