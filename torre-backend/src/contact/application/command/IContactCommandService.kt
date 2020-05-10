package com.ktor.contact.application.command

import com.ktor.contact.domain.Contact

interface IContactCommandService {

    suspend fun save(contact: Contact): Contact

    suspend fun find(id: String): Contact?
}