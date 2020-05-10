package com.ktor.prospect.adapter.`in`.http

import com.ktor.prospect.application.command.ProspectService
import com.ktor.prospect.domain.Prospect
import io.ktor.application.call
import io.ktor.features.BadRequestException
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.prospect(prostpectService: ProspectService) {

    route("/prospect") {
        get("/") {
            call.respond(prostpectService.findAll())
        }

        get("/{id}") {
            val id = call.parameters["id"]?.toString() ?: throw BadRequestException("id was not provide")
            val prospect = prostpectService.find(id)
            if (prospect == null) call.respond(HttpStatusCode.NotFound)
            else call.respond(prospect)
        }

        post("/validate") {
            val prospect = call.receive<Prospect>()
            call.respond(prostpectService.validateProspect(prospect))
        }
    }
}