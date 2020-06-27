package io.leege.fcfinderv2.data.tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Leagues: IntIdTable() {

    val name: Column<String> = Leagues.varchar("name", 255)
    val division: Column<Int> = Leagues.integer("division")
    val confederation: Column<String> = Leagues.varchar("confederation", 255)
    val countryId: Column<Int> = Leagues.integer("country_id").references(Countries.id)
    override val primaryKey = PrimaryKey(Leagues.id)

}