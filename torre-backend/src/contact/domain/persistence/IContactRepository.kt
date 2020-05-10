package com.ktor.contact.domain.persistence

import com.ktor.contact.domain.Contact

interface IContactRepository {

    suspend fun save(contact: Contact): Contact

    suspend fun find(id: String): Contact?
}