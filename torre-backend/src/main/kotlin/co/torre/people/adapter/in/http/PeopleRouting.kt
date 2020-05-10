package co.torre.people.adapter.`in`.http

import co.torre.people.application.command.PeopleCommandService
import co.torre.people.application.query.PeopleQueryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/people")
class PeopleRouting(
        val peopleCommandService: PeopleCommandService,
        val peopleQueryService: PeopleQueryService
) {

    @GetMapping("/{profileName}")
    fun findExternalBioAndSave(@PathVariable("profileName") profileName: String) =
            peopleCommandService.findAndSaveExternalPerson(profileName)

    @GetMapping("/opportunities/{oppId}/{profileName}")
    fun findOpportunities(@PathVariable("oppId") oppId: String,
                          @PathVariable("profileName") profileName: String) =
            peopleQueryService.getOpp(oppId, profileName)
}