package com.ktor.prospect.domain.persistence

import com.ktor.contact.domain.*
import com.ktor.contact.domain.persistence.IContactRepository
import com.ktor.infrastucture.configuration.DBConfig.dbQuery
import org.jetbrains.exposed.sql.*
import java.util.*

class ContactRepository: IContactRepository {

    override suspend fun save(contact: Contact): Contact {
        var key = ""
        dbQuery {
            key = (Contacts.insert {
                it[id] = UUID.randomUUID().toString()
                it[name] = contact.name.value
                it[document] = contact.document.value
                it[documentType] = contact.documentType.value
                it[issuingDate] = contact.issuingDate.value
            } get Contacts.id)
        }
        return find(key)!!
    }

    override suspend fun find(id: String): Contact? = dbQuery {
        Contacts.select {
                (Contacts.id eq id)
            }.mapNotNull { toContact(it) }
            .singleOrNull()
    }

    suspend fun findAll(): List<Contact> = dbQuery {
        Contacts.selectAll().map { toContact(it) }
    }

    private fun toContact(row: ResultRow): Contact =
        Contact(
            ContactId(row[Contacts.id]),
            ContactName(row[Contacts.name]),
            ContactDocument(row[Contacts.document]),
            ContactDocumentType(row[Contacts.documentType]),
            ContactIssuingDate(row[Contacts.issuingDate])
        )
}