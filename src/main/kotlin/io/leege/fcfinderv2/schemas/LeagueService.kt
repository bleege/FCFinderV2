package io.leege.fcfinderv2.schemas

import io.leege.fcfinderv2.data.DataService

class LeagueService(val dataService: DataService = DataService()) {

    fun getAllLeagues() = dataService.getAllLeagues()

}