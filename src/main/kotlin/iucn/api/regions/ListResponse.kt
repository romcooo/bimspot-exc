package iucn.api.regions

data class ListResponse(
    val count: Int?,
    val results: List<Region>?
)