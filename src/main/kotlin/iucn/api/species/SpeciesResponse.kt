package iucn.api.species

data class SpeciesResponse(
    val count: Int?,
    val region_identifier: String?,
    val page: String?,
    val result: List<Species>?
)