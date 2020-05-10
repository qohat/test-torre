package com.ktor.prospect.domain.client

import com.ktor.prospect.domain.Prospect
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.reactivex.Flowable
import kotlin.random.Random

class ProspectClient {

    val httpClient = HttpClient(Apache) {
        install(JsonFeature) {
            serializer = GsonSerializer {
                // .GsonBuilder
                serializeNulls()
                disableHtmlEscaping()
            }
        }
    }

    val URL = "http://localhost:8585";
    val COUNTRY_IDENTIFICATION = "/country-identification"
    val POLICE_RECORD = "/police-records"

    suspend fun policeRecord(prospect: Prospect): Boolean {
        return httpClient.post<ProspectResponse>(URL + POLICE_RECORD) {
            contentType(ContentType.Application.Json)
            body = prospect
        }.exist
    }

    suspend fun countryIdentification(prospect: Prospect): Boolean {
        return httpClient.post<ProspectResponse>(URL + COUNTRY_IDENTIFICATION) {
            contentType(ContentType.Application.Json)
            body = prospect
        }.exist
    }

    fun prospectScore(): Boolean {
        return Random.nextInt() > 60
    }

}

data class ProspectResponse(val exist: Boolean)
