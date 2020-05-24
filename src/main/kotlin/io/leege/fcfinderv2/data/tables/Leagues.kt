package io.leege.fcfinderv2.data.tables

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Leagues: Table() {

    val id: Column<Int> = Leagues.integer("id").autoIncrement()
    val name: Column<String> = Leagues.varchar("name", 255)
    val division: Column<Int> = Leagues.integer("division")
    val confederation: Column<String> = Leagues.varchar("confederation", 255)
    val country_id: Column<Int> = Leagues.integer("country_id").references(Countries.id)
    override val primaryKey = PrimaryKey(Leagues.id)

}