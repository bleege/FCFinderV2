package io.leege.fcfinderv2.data.dao

import io.leege.fcfinderv2.data.tables.Leagues
import io.leege.fcfinderv2.schemas.models.League
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class LeagueDAO(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<LeagueDAO>(Leagues)
    var name by Leagues.name
    var division by Leagues.division
    var confederation by Leagues.confederation
    var country by CountryDAO referencedOn Leagues.countryId

    fun adaptTo(): League {
        return League(id = id.value, name = name , division = division, confederation = confederation, country = country.adaptTo())
    }
}
