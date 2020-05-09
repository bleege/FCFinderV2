package io.leege.fcfinderv2.data

import io.leege.fcfinderv2.data.tables.Countries
import io.leege.fcfinderv2.schemas.models.Country
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class DataService {

    fun getAllCountries(): List<Country> {

        Database.connect("jdbc:postgresql://ec2-34-233-186-251.compute-1.amazonaws.com/dec9608v5lihk3", driver = "org.postgresql.Driver",
            user = "snetofsxfiajkf", password = "31d115e6cbd4a952c010c1b93becfc83b12443199e92935fba00c9ced622613e")

        val result = transaction {
            Countries.selectAll().map { it.toCountry() }
        }

        return result
    }

    fun ResultRow.toCountry() = Country (
        id = this[Countries.id],
        name = this[Countries.name]
    )

}