package com.ktor

import com.fasterxml.jackson.databind.SerializationFeature
import com.ktor.contact.adapter.`in`.http.contact
import com.ktor.contact.application.query.ContactQueryService
import com.ktor.infrastucture.configuration.DBConfig
import com.ktor.prospect.adapter.`in`.http.prospect
import com.ktor.prospect.application.command.ProspectService
import io.ktor.application.*
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.jackson.jackson
import io.ktor.routing.Routing
import io.ktor.server.engine.commandLineEnvironment
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>) {
    embeddedServer(Netty, commandLineEnvironment(args)).start(wait = true)
}


@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(DefaultHeaders)
    install(CallLogging)
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    DBConfig.init()

    val prospectCommandService = ProspectService()
    val contactQueryService = ContactQueryService()

    install(Routing) {
        prospect(prospectCommandService)
        contact(contactQueryService)
    }
}
