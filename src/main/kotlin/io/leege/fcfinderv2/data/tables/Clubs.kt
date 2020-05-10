package io.leege.fcfinderv2.data.tables

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Clubs: Table() {

    val id: Column<Int> = integer("id").autoIncrement()
    val countryID = integer("country_id").uniqueIndex().references(Countries.id)
    val name: Column<String> = varchar("name", 255)
    val stadium: Column<String> = varchar("stadium", 255)
    val latitude: Column<Double> = double("latitude")
    val longitude: Column<Double> =double("longitude")
    override val primaryKey = PrimaryKey(id)

}