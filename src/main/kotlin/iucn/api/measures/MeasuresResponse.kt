package iucn.api.measures

data class MeasuresResponse(
    val name: String?,
    val region_identifier: String?,
    val result: List<Measure>?
)