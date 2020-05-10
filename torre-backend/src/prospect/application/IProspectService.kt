package com.ktor.prospect.application.command

import com.ktor.prospect.domain.Prospect
import io.reactivex.Flowable
import io.reactivex.Observable

interface IProspectService {

    suspend fun find(id: String): Prospect?

    suspend fun findAll(): List<Prospect>

    fun save(prospect: Prospect): Prospect

    suspend fun validateProspect(prospect: Prospect): Pair<Any, String>
}