package com.ktor.prospect.application.command

import com.ktor.contact.application.command.IContactCommandService
import com.ktor.contact.domain.Contact
import com.ktor.prospect.domain.persistence.ContactRepository

class ContactCommandService: IContactCommandService {

    val contactRepository = ContactRepository()

    override suspend fun save(contact: Contact): Contact {
        return contactRepository.save(contact)
    }

    override suspend fun find(id: String): Contact? = contactRepository.find(id);

}