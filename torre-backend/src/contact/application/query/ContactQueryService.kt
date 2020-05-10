package com.ktor.contact.application.query

import com.ktor.contact.domain.Contact
import com.ktor.prospect.domain.persistence.ContactRepository

class ContactQueryService: IContactQueryService {

    val contactRepository = ContactRepository()

    override suspend fun find(id: String): Contact {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun findAll(): List<Contact> {
        return contactRepository.findAll()
    }
}