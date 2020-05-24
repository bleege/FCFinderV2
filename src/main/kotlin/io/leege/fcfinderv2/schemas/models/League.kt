package io.leege.fcfinderv2.schemas.models

data class League(val id: Int, val name: String, val division: Int, val confederation: String, val country_id: Int) {

    companion object {
        fun search(countryId: Int): List<League> {
            return listOf(League(id = 1, name = "Test", division = 1, confederation = "UEFA", country_id = 1))
        }
    }

}