import iucn.api.measures.MeasuresApi
import iucn.api.regions.RegionsApi
import iucn.api.species.SpeciesApi

fun main() {
    val randomRegion = RegionsApi.list()?.random()?.identifier ?: return println("Failed to get random region (null)")
    val allSpecies = SpeciesApi.PerRegionApi(randomRegion).list()
    allSpecies
        ?.filter { species ->
            species.category.equals("CR", true)
        }
        ?.forEach { endangered ->
            endangered.scientific_name?.let {
                val measures = MeasuresApi.PerSpecies(it).PerRegion(randomRegion).list()
                endangered.conservationMeasures =
                    measures?.joinToString(separator = ", ") { measure -> measure.title ?: "" }
                println(endangered)
            }
        }

    println("Mammals:\n${allSpecies?.filter { it.class_name.equals("MAMMALIA", true) }}")
}
