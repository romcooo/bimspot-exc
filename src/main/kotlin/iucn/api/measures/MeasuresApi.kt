package iucn.api.measures

import iucn.api.IUCNApi.defaultJsonObjectMapper
import com.fasterxml.jackson.module.kotlin.treeToValue
import iucn.api.IUCNApi

object MeasuresApi {
    private const val url = "${IUCNApi.url}measures/"

    class PerSpecies(speciesName: String) {
        private val url = "${MeasuresApi.url}species/name/$speciesName"

        inner class PerRegion(regionIdentifier: String) {
            private val url = "${this@PerSpecies.url}/region/$regionIdentifier"

            fun list(): List<Measure>? {
                return IUCNApi.getConnection(url).getInputStream().use {
                    defaultJsonObjectMapper.readTree(it)?.let { response ->
                        defaultJsonObjectMapper.treeToValue<MeasuresResponse>(response)?.result ?: emptyList()
                    }
                }
            }
        }
    }
}