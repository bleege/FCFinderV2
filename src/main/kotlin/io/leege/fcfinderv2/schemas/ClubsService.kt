package io.leege.fcfinderv2.schemas

import io.leege.fcfinderv2.data.DataService
import io.leege.fcfinderv2.schemas.models.Club

data class ClubSearchParameters(val id: Int)

class ClubsService(val dataService: DataService = DataService()) {

    fun getAllClubs() = dataService.getAllClubs()
    suspend fun searchClubs(params: ClubSearchParameters) = Club.search(params.id)

}