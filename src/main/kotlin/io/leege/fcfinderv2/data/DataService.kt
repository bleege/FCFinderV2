package io.leege.fcfinderv2.data

import io.leege.fcfinderv2.data.dao.ClubDAO
import io.leege.fcfinderv2.data.dao.CountryDAO
import io.leege.fcfinderv2.data.dao.LeagueDAO
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
            ClubDAO.all().map { it.adaptTo() }
        }
    }

    fun getAllCountries(): List<Country> {

        return transaction {
            addLogger(Slf4jSqlDebugLogger)
            CountryDAO.all().map { it.adaptTo() }
        }
    }

    fun getAllLeagues(): List<League> {
        return transaction {
            addLogger(Slf4jSqlDebugLogger)
            LeagueDAO.all().map { it.adaptTo() }
        }
    }

}