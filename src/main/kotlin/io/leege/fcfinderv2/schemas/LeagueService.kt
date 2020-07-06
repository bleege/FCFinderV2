package io.leege.fcfinderv2.schemas

import io.leege.fcfinderv2.data.DataService
import io.leege.fcfinderv2.data.DataServiceImpl

class LeagueService(val dataService: DataService = DataServiceImpl()) {

    fun getAllLeagues() = dataService.getAllLeagues()
    fun getLeaguesByCountryId(countryId: Int) = dataService.getLeaguesByCountry(countryId = countryId)

}