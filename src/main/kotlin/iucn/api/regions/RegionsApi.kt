package iucn.api.regions

import iucn.api.IUCNApi.defaultJsonObjectMapper
import com.fasterxml.jackson.module.kotlin.treeToValue
import iucn.api.IUCNApi

object RegionsApi {
    private const val url = "${IUCNApi.url}region/"

    fun list(): List<Region>? {
        val url = "${RegionsApi.url}list/"

        return IUCNApi.getConnection(url).getInputStream().bufferedReader().use {
            defaultJsonObjectMapper.readTree(it)?.let { response ->
                defaultJsonObjectMapper.treeToValue<ListResponse?>(response)?.results ?: emptyList()
            }
        }
    }
}