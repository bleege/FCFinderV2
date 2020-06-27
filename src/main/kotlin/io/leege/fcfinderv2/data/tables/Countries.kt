package io.leege.fcfinderv2.data.tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Countries: IntIdTable() {
    val name: Column<String> = varchar("name", 255).uniqueIndex()
}
