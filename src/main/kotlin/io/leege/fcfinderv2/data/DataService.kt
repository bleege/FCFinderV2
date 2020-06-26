package io.leege.fcfinderv2.data

import io.leege.fcfinderv2.data.tables.Club
import io.leege.fcfinderv2.data.tables.Country
import io.leege.fcfinderv2.data.tables.Leagues
import io.leege.fcfinderv2.schemas.models.League
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class DataService {

    init {
        Database.connect("jdbc:postgresql://ec2-34-233-186-251.compute-1.amazonaws.com/dec9608v5lihk3", driver = "org.postgresql.Driver",
            user = "snetofsxfiajkf", password = "31d115e6cbd4a952c010c1b93becfc83b12443199e92935fba00c9ced622613e")
    }

    fun getAllClubs(): List<io.leege.fcfinderv2.schemas.models.Club> {
        return transaction {
            addLogger(Slf4jSqlDebugLogger)
            Club.all().map { io.leege.fcfinderv2.schemas.models.Club(id = it.id.value, countryId = it.country.id.value, name = it.name, latitude = it.latitude, longitude = it.longitude ) }
//            Clubs.selectAll().map { it.toClub() }
        }
    }

    fun getAllCountries(): List<io.leege.fcfinderv2.schemas.models.Country> {

        return transaction {
            addLogger(Slf4jSqlDebugLogger)
            Country.all().map { io.leege.fcfinderv2.schemas.models.Country(id = it.id.value, name = it.name) }
//            Countries.selectAll().map { it.toCountry() }
        }
    }

    fun getAllLeagues(): List<League> {
        return transaction {
            addLogger(Slf4jSqlDebugLogger)
            Leagues.selectAll().map { it.toLeague() }
        }
    }

//    fun ResultRow.toClub() = Club (
//        id = this[Clubs.id],
//        countryId = this[Clubs.countryID],
//        name = this[Clubs.name],
//        stadiumName = this[Clubs.stadium],
//        latitude = this[Clubs.latitude],
//        longitude = this[Clubs.longitude]
//    )
//
//    fun ResultRow.toCountry() = Country (
//        id = this[Countries.id],
//        name = this[Countries.name]
//    )

    fun ResultRow.toLeague() = League (
        id = this[Leagues.id],
        name = this[Leagues.name],
        division = this[Leagues.division],
        confederation = this[Leagues.confederation],
        country_id = this[Leagues.country_id]
    )

}