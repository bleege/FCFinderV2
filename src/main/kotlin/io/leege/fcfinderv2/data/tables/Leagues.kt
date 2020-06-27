package io.leege.fcfinderv2.data.tables

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Leagues: IntIdTable() {

    val name: Column<String> = Leagues.varchar("name", 255)
    val division: Column<Int> = Leagues.integer("division")
    val confederation: Column<String> = Leagues.varchar("confederation", 255)
    val countryId: Column<Int> = Leagues.integer("country_id").references(Countries.id)
    override val primaryKey = PrimaryKey(Leagues.id)

}

class League(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<League>(Leagues)
    var name by Leagues.name
    var division by Leagues.division
    var confederation by Leagues.confederation
    var country by Country referencedOn Leagues.countryId
}