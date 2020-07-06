package io.leege.fcfinderv2.schemas.tests

import io.leege.fcfinderv2.data.DataService
import io.leege.fcfinderv2.schemas.models.Club
import io.leege.fcfinderv2.schemas.models.Country
import io.leege.fcfinderv2.schemas.models.League

class DataServiceMock: DataService {

    override fun getAllClubs(): List<Club> {
        return listOf(
            Club(id = 1, country = Country(id = 1, name = "Ireland"), name = "Cork City", stadiumName = "Turners Cross", latitude = 51.885528, longitude = -8.46775),
            Club(id = 2, country = Country(id = 1, name = "Ireland"), name = "Galway United", stadiumName = "Eamonn Deacy Park", latitude = 53.284658, longitude = -9.056258)
        )
    }

    override fun getAllCountries(): List<Country> {
        return listOf(
            Country(id = 1, name = "Ireland")
        )
    }

    override fun getAllLeagues(): List<League> {
        return listOf(
            League(id = 1, name = "Premier Division", division = 1, confederation = "UEFA", country = Country(id = 1, name = "Ireland")),
            League(id = 2, name = "First Division", division = 2, confederation = "UEFA", country = Country(id = 1, name = "Ireland"))
        )
    }

    override fun getLeaguesByCountry(countryId: Int): List<League> {
        return listOf(
            League(id = 1, name = "Premier Division", division = 1, confederation = "UEFA", country = Country(id = 1, name = "Ireland"))
        )
    }

    override fun getClubsByLeagueAndYear(leagueId: Int, year: Int): List<Club> {
        return listOf(
            Club(id = 1, country = Country(id = 1, name = "Ireland"), name = "Cork City", stadiumName = "Turners Cross", latitude = 51.885528, longitude = -8.46775),
            Club(id = 2, country = Country(id = 1, name = "Ireland"), name = "Galway United", stadiumName = "Eamonn Deacy Park", latitude = 53.284658, longitude = -9.056258)
        )
    }

}