package com.ktor.contact.adapter.`in`.http

import com.ktor.contact.application.query.ContactQueryService
import io.ktor.application.call
import io.ktor.features.BadRequestException
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route

fun Route.contact(contactQueryService: ContactQueryService) {

    route("/contact") {
        get("/") {
            call.respond(contactQueryService.findAll())
        }

        get("/{id}") {
            val id = call.parameters["id"]?.toString() ?: throw BadRequestException("id was not provide")
            val contact = contactQueryService.find(id)
            if (contact == null) call.respond(HttpStatusCode.NotFound)
            else call.respond(contact)
        }
    }
}