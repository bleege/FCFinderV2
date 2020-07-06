package io.leege.fcfinderv2.schemas

import io.leege.fcfinderv2.data.DataService
import io.leege.fcfinderv2.data.DataServiceImpl

class ClubsService(val dataService: DataService = DataServiceImpl()) {

    fun getAllClubs() = dataService.getAllClubs()
    fun getClubsByLeagueAndYear(leagueId: Int, year: Int) = dataService.getClubsByLeagueAndYear(leagueId = leagueId, year = year)

}