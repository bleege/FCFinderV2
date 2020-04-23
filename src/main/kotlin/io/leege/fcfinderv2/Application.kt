package io.leege.fcfinderv2

import org.apache.log4j.PropertyConfigurator
import spark.Spark.get
import java.util.*

class Application {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            initLogger()
            setupPort()
            setupRoutes()
        }

        private fun initLogger() {
            val logProperties = Properties()
            logProperties.setProperty("log4j.rootLogger", "DEBUG,CONSOLE")
            logProperties.setProperty("log4j.appender.CONSOLE", "org.apache.log4j.ConsoleAppender")
            logProperties.setProperty("log4j.appender.CONSOLE.layout", "org.apache.log4j.PatternLayout")
            logProperties.setProperty("log4j.appender.CONSOLE.layout.conversionPattern", "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%m%n")
            PropertyConfigurator.configure(logProperties)
        }

        private fun setupPort(): Int {
            val processBuilder = ProcessBuilder()
            if (processBuilder.environment().get("PORT") != null) {
                return Integer.parseInt(processBuilder.environment().get("PORT"))
            }
            return 4567
        }

        private fun setupRoutes() {

            get("/") { request, response ->
                Date().toString()
            }

        }

    }

}