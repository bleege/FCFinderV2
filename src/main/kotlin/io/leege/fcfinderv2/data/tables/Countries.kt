package io.leege.fcfinderv2.data.tables

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Countries: IntIdTable() {
    val name: Column<String> = varchar("name", 255).uniqueIndex()
}

class Country(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<Country>(Countries)
    var name by Countries.name
}