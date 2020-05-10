package io.leege.fcfinderv2.data

import io.leege.fcfinderv2.data.tables.Clubs
import io.leege.fcfinderv2.data.tables.Countries
import io.leege.fcfinderv2.schemas.models.Club
import io.leege.fcfinderv2.schemas.models.Country
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class DataService {

    init {
        Database.connect("jdbc:postgresql://ec2-34-233-186-251.compute-1.amazonaws.com/dec9608v5lihk3", driver = "org.postgresql.Driver",
            user = "snetofsxfiajkf", password = "31d115e6cbd4a952c010c1b93becfc83b12443199e92935fba00c9ced622613e")
    }

    fun getAllCountries(): List<Country> {

        return transaction {
            Countries.selectAll().map { it.toCountry() }
        }
    }

    fun getAllClubs(): List<Club> {
        return transaction {
            Clubs.selectAll().map { it.toClub() }
        }
    }

    fun ResultRow.toClub() = Club (
        id = this[Clubs.id],
        countryId = this[Clubs.countryID],
        name = this[Clubs.name],
        stadiumName = this[Clubs.stadium],
        latitude = this[Clubs.latitude],
        longitude = this[Clubs.longitude]
    )

    fun ResultRow.toCountry() = Country (
        id = this[Countries.id],
        name = this[Countries.name]
    )

}