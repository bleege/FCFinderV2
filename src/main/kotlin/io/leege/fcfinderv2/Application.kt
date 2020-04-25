package io.leege.fcfinderv2

import org.apache.log4j.PropertyConfigurator
import org.slf4j.LoggerFactory
import spark.Spark.get
import spark.Spark.port
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
            val portEnvironment = processBuilder.environment().get("PORT")
            val portInt = Integer.parseInt(portEnvironment ?: "4567")
            logger.info("PORT set to $portInt")
            port(portInt)
        }

        private fun setupRoutes() {

            get("/") { request, response ->
                Date().toString()
            }

        }

    }

}