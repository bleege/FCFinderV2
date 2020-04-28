package io.leege.fcfinderv2.schemas

import io.leege.fcfinderv2.schemas.models.Club

data class ClubSearchParameters(val id: Int)

class ClubsService {
    suspend fun searchClubs(params: ClubSearchParameters) = Club.search(params.id)
}