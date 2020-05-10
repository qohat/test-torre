package com.ktor.prospect.domain

data class Prospect (
    val id: ProspectId,
    val name: ProspectName,
    val document: ProspectDocument,
    val documentType: ProspectDocumentType,
    val issuingDate: ProspectIssuingDate
)