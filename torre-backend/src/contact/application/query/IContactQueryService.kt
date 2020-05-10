package com.ktor.contact.application.query

import com.ktor.contact.domain.Contact


interface IContactQueryService {
    suspend fun find(id: String) : Contact
    suspend fun findAll(): List<Contact>;
}