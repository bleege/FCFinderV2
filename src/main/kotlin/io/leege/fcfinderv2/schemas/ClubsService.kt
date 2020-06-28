package io.leege.fcfinderv2.schemas

import io.leege.fcfinderv2.data.DataService

class ClubsService(val dataService: DataService = DataService()) {

    fun getAllClubs() = dataService.getAllClubs()
    fun getClubsByLeagueAndYear(leagueId: Int, year: Int) = dataService.getClubsByLeagueAndYear(leagueId = leagueId, year = year)

}