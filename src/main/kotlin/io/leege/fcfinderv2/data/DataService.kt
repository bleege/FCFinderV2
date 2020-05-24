package io.leege.fcfinderv2.data

import io.leege.fcfinderv2.data.tables.Clubs
import io.leege.fcfinderv2.data.tables.Countries
import io.leege.fcfinderv2.data.tables.Leagues
import io.leege.fcfinderv2.schemas.models.Club
import io.leege.fcfinderv2.schemas.models.Country
import io.leege.fcfinderv2.schemas.models.League
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class DataService {

    init {
        Database.connect("jdbc:postgresql://ec2-34-233-186-251.compute-1.amazonaws.com/dec9608v5lihk3", driver = "org.postgresql.Driver",
            user = "snetofsxfiajkf", password = "31d115e6cbd4a952c010c1b93becfc83b12443199e92935fba00c9ced622613e")
    }

    fun getAllClubs(): List<Club> {
        return transaction {
            addLogger(Slf4jSqlDebugLogger)
            Clubs.selectAll().map { it.toClub() }
        }
    }

    fun getAllCountries(): List<Country> {

        return transaction {
            addLogger(Slf4jSqlDebugLogger)
            Countries.selectAll().map { it.toCountry() }
        }
    }

    fun getAllLeagues(): List<League> {
        return transaction {
            addLogger(Slf4jSqlDebugLogger)
            Leagues.selectAll().map { it.toLeague() }
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

    fun ResultRow.toLeague() = League (
        id = this[Leagues.id],
        name = this[Leagues.name],
        division = this[Leagues.division],
        confederation = this[Leagues.confederation],
        country_id = this[Leagues.country_id]
    )

}