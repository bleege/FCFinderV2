package io.leege.fcfinderv2.data.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object ClubsToLeagues: IntIdTable("clubs_to_leagues") {

    val clubId = ClubsToLeagues.integer("club_id").uniqueIndex().references(Clubs.id)
    val leagueId = ClubsToLeagues.integer("league_id").uniqueIndex().references(Leagues.id)
    val year = ClubsToLeagues.integer("year")

}