package io.leege.fcfinderv2.data.dao

import io.leege.fcfinderv2.data.tables.Clubs
import io.leege.fcfinderv2.schemas.models.Club
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ClubDAO(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<ClubDAO>(Clubs)
    var country by CountryDAO referencedOn Clubs.countryID
    var name by Clubs.name
    var stadium by Clubs.stadium
    var latitude by Clubs.latitude
    var longitude by Clubs.longitude

    fun adaptTo(): Club {
        return Club(id = id.value, country = country.adaptTo(), name = name, stadiumName = stadium, latitude = latitude, longitude = longitude )
    }
}