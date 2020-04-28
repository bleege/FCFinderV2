package io.leege.fcfinderv2.schemas.models

data class Club(val id: Int, val countryId: Int, val name: String, val stadiumName: String, val latitude: Double, val longitude: Double) {

    companion object {
        suspend fun search(countryId: Int): List<Club> {
            return listOf<Club>(Club(id =1, countryId = 1, name = "Test Club", stadiumName = "Stadium Name", latitude = 44.567, longitude = -87.654))
        }
    }

}