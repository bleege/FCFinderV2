package io.leege.fcfinderv2

import io.leege.fcfinderv2.schemas.ClubsService
import io.leege.fcfinderv2.schemas.CountryService
import io.leege.fcfinderv2.schemas.LeagueService
import org.apache.log4j.PropertyConfigurator
import org.slf4j.LoggerFactory
import spark.Spark.*
import java.util.*

class Application {

    companion object {
        val logger = LoggerFactory.getLogger(Application::class.java)

        @JvmStatic
        fun main(args: Array<String>) {
            initLogger()
            setupPort()
            setupRoutes()
        }

        private fun initLogger() {
            val logProperties = Properties()
            logProperties.setProperty("log4j.rootLogger", "INFO,CONSOLE")
            logProperties.setProperty("log4j.appender.CONSOLE", "org.apache.log4j.ConsoleAppender")
            logProperties.setProperty("log4j.appender.CONSOLE.layout", "org.apache.log4j.PatternLayout")
            logProperties.setProperty("log4j.appender.CONSOLE.layout.conversionPattern", "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%m%n")
            PropertyConfigurator.configure(logProperties)
        }

        private fun setupPort() {
            val processBuilder = ProcessBuilder()
            val portEnvironment = processBuilder.environment()["PORT"]
            val portInt = Integer.parseInt(portEnvironment ?: "4567")
            logger.info("PORT set to $portInt")
            port(portInt)
        }

        private fun setupRoutes() {

            val countryService = CountryService()
            val clubsService = ClubsService()
            val leagueService = LeagueService()
            val graphQLHandler = GraphQLHandler()

            get("/") { _, _ ->
                Date().toString()
            }

            /* REST Data Handlers */

            get("/clubs") { _,_ ->
                clubsService.getAllClubs()
            }

            get("/countries") { _, _ ->
                countryService.getAllCountries()
            }

            get("/leagues") { _,_ ->
                leagueService.getAllLeagues()
            }

            get("leaguesbycountry") { _,_ ->
                leagueService.getLeaguesByCountryId(1)
            }

            get("clubsbyleagueandyear") { _,_ ->
                clubsService.getClubsByLeagueAndYear(leagueId = 2, year = 2020)
            }

            /* GraphQL Handler */

            post("/graphql") { request, response ->
                graphQLHandler.handle(request, response)
            }

            internalServerError() { _, response ->
                response.status(500)
                response.type("application/text")
                "Unable to process request"
            }

            options("/graphql") { _, _ -> "ok" }

            before("/graphql") { request, response ->
                response.header("Access-Control-Allow-Origin", "*")
                response.header("Access-Control-Allow-Methods", "GET,POST,OPTIONS")
                response.header("Access-Control-Allow-Headers", "*")
            }

        }

    }

}