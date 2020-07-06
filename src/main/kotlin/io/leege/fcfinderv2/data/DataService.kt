package io.leege.fcfinderv2.data

import io.leege.fcfinderv2.schemas.models.Club
import io.leege.fcfinderv2.schemas.models.Country
import io.leege.fcfinderv2.schemas.models.League

interface DataService {
    fun getAllClubs(): List<Club>
    fun getAllCountries(): List<Country>
    fun getAllLeagues(): List<League>
    fun getLeaguesByCountry(countryId: Int): List<League>
    fun getClubsByLeagueAndYear(leagueId: Int, year: Int): List<Club>
}