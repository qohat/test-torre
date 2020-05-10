package com.ktor.prospect.adapter.out.persistence

import com.ktor.prospect.domain.Prospect

interface IProspectRepository {

    fun save(prospect: Prospect): Prospect

    fun find(id: String): Prospect?

    fun findAll(): List<Prospect>
}