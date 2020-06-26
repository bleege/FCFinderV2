package io.leege.fcfinderv2.data.tables

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Clubs: IntIdTable() {

    val countryID = integer("country_id").uniqueIndex().references(Countries.id)
    val name: Column<String> = varchar("name", 255)
    val stadium: Column<String> = varchar("stadium", 255)
    val latitude: Column<Double> = double("latitude")
    val longitude: Column<Double> =double("longitude")
    override val primaryKey = PrimaryKey(id)

}

class Club(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<Club>(Clubs)
    var country by Country referencedOn Clubs.countryID
    var name by Clubs.name
    var stadium by Clubs.stadium
    var latitude by Clubs.latitude
    var longitude by Clubs.longitude
}