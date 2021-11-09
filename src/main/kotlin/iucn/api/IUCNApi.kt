package iucn.api

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.net.URI
import java.net.URLConnection

object IUCNApi {
    private val authToken = System.getenv("API_TOKEN")
    val defaultJsonObjectMapper: ObjectMapper = jacksonObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    const val url = "https://apiv3.iucnredlist.org/api/v3/"

    fun getConnection(url: String): URLConnection {
        val uri = URI
            .create("${url.replace(" ", "%20")}?token=$authToken")
            .normalize().toURL()
        return uri.openConnection()
    }
}
