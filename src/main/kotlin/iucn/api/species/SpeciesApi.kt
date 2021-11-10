package iucn.api.species

import iucn.api.IUCNApi.defaultJsonObjectMapper
import com.fasterxml.jackson.module.kotlin.treeToValue
import iucn.api.IUCNApi

object SpeciesApi {
    private const val url = "${IUCNApi.url}species/"

    class PerRegionApi(regionIdentifier: String) {
        private val url = "${SpeciesApi.url}region/$regionIdentifier/page/0"

        fun list(): List<Species>? {
            return IUCNApi.getConnection(url).getInputStream().bufferedReader().use {
                defaultJsonObjectMapper.readTree(it)?.let { response ->
                    defaultJsonObjectMapper.treeToValue<SpeciesResponse>(response)?.result ?: emptyList()
                }
            }
        }
    }
}