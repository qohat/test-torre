package com.ktor.contact.domain

import org.jetbrains.exposed.sql.Table

object Contacts: Table() {
    val id = varchar("id", 255)
    val name = varchar("name", 255)
    val document = varchar("document", 255)
    val documentType = varchar("documentType", 255)
    val issuingDate = varchar("issuingDate", 255)
    override val primaryKey = PrimaryKey(id)
}

data class Contact (
    val id: ContactId,
    val name: ContactName,
    val document: ContactDocument,
    val documentType: ContactDocumentType,
    val issuingDate: ContactIssuingDate
)