package io.leege.fcfinderv2

import spark.Spark.get
import java.util.*

class Application {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            setupPort()
            setupRoutes()
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