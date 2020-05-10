package com.ktor.prospect.adapter.out.persistence

import com.ktor.prospect.domain.*
import java.util.*

class ProspectRepository: IProspectRepository {

    val prospects = Collections.synchronizedList(
        mutableListOf(
            Prospect(
                ProspectId(UUID.randomUUID().toString()),
                ProspectName("Ubaldo Manuel Mercado"),
                ProspectDocument("1092828898"),
                ProspectDocumentType("C.C"),
                ProspectIssuingDate("19-03-1954 00:00:00")
            )
        )
    );

    override fun save(prospect: Prospect): Prospect {
        prospects += Prospect(
            prospect.id,
            prospect.name,
            prospect.document,
            prospect.documentType,
            prospect.issuingDate
        )
        return prospect;
    }

    override fun find(id: String) = prospects.find { it.id.value == id }

    override fun findAll() = prospects;
}