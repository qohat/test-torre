package com.ktor.prospect.application

import com.ktor.prospect.application.command.ProspectService
import com.ktor.prospect.domain.*
import com.ktor.prospect.domain.client.ProspectClient
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

class ProspectServiceTest {

    val prospectService = ProspectService()

    @Test
    suspend fun `Given a valid prospect When validate and all validations were ok Then save in contact data`() = runBlocking {
        // given
        val prospect = getProspect()

        //when
        val client = mockk<ProspectClient>()
        every { client.policeRecord(prospect) } returns true
        every { client.countryIdentification(prospect) } returns true
        every { client.prospectScore() } returns true
        val pairResponse = prospectService.validateProspect(prospect)

        //then
        assertEquals("Prospect saved in contacts directory", pairResponse.second)

    }

    @Test
    suspend fun `Given a Prospect When validate and all validations were not ok Then save in prospect memory data`() = runBlocking {
        // given
        val prospect = getProspect()

        //when
        val client = mockk<ProspectClient>()
        every { client.policeRecord(prospect) } returns true
        every { client.countryIdentification(prospect) } returns false
        every { client.prospectScore() } returns true
        val pairResponse = prospectService.validateProspect(prospect)

        //then
        assertEquals("Prospect saved in memory", pairResponse.second)
    }

    fun getProspect(): Prospect {
        return Prospect(
            ProspectId(UUID.randomUUID().toString()),
            ProspectName("Test Name"),
            ProspectDocument("109292929"),
            ProspectDocumentType("C.C"),
            ProspectIssuingDate("2019-01-12 00:00:00")
        )
    }
}