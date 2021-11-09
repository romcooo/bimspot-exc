package iucn.api.species

import com.fasterxml.jackson.annotation.JsonIgnore

data class Species(
    val taxonid: String?,
    val kingdom_name: String?,
    val phylum_name: String?,
    val class_name: String?,
    val order_name: String?,
    val family_name: String?,
    val genus_name: String?,
    val scientific_name: String?,
    val taxonomic_authority: String?,
    val infra_rank: String?,
    val infra_name: String?,
    val population: String?,
    val category: String?,
    val main_common_name: String?,
    @JsonIgnore
    var conservationMeasures: String?
)
