package io.leege.fcfinderv2.data.dao

import io.leege.fcfinderv2.data.tables.ClubsToLeagues
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ClubsToLeaguesDAO(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<ClubsToLeaguesDAO>(ClubsToLeagues)

    var club by ClubDAO referencedOn ClubsToLeagues.clubId
    var league by LeagueDAO referencedOn ClubsToLeagues.leagueId
    var year by ClubsToLeagues.year

}