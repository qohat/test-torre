package com.ktor.prospect.application.command

import com.ktor.contact.domain.*
import com.ktor.prospect.domain.Prospect
import com.ktor.prospect.domain.client.ProspectClient
import com.ktor.prospect.adapter.out.persistence.ProspectRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class ProspectService: IProspectService {

    val client = ProspectClient();
    val prospectRepository = ProspectRepository()
    val contactCommandService = ContactCommandService()

    override suspend fun find(id: String): Prospect? = prospectRepository.find(id)

    override suspend fun findAll(): List<Prospect> = prospectRepository.findAll()

    override fun save(prospect: Prospect) = prospectRepository.save(prospect)

    override suspend fun validateProspect(prospect: Prospect): Pair<Any, String> {
        return when (prepareParallelCoroutines(prospect)
                        .toList()
                        .awaitAll() //Parallel call
                        .reduce { pr, ci -> pr && ci} && client.prospectScore()) {
                    true -> contactCommandService.save(
                                Contact(
                                    ContactId(prospect.id.value),
                                    ContactName(prospect.name.value),
                                    ContactDocument(prospect.name.value),
                                    ContactDocumentType(prospect.documentType.value),
                                    ContactIssuingDate(prospect.issuingDate.value)
                                )
                            ) to "Prospect saved in contacts directory"
                    false -> save(prospect) to "Prospect saved in memory"
                }
    }

    suspend fun prepareParallelCoroutines(prospect: Prospect): Pair<Deferred<Boolean>, Deferred<Boolean>> = coroutineScope {
        // Start two requests asynchronously.
        val policeRecord = async { client.policeRecord(prospect) }
        val countryIdentification = async { client.countryIdentification(prospect) }
        policeRecord to countryIdentification // Paraller call
    }

}