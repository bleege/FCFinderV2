package io.leege.fcfinderv2

import com.expediagroup.graphql.SchemaGeneratorConfig
import com.expediagroup.graphql.TopLevelObject
import com.expediagroup.graphql.toSchema
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import graphql.ExceptionWhileDataFetching
import graphql.ExecutionInput
import graphql.ExecutionResult
import graphql.GraphQL
import io.leege.fcfinderv2.schemas.ClubsService
import io.leege.fcfinderv2.schemas.CountryService
import io.leege.fcfinderv2.schemas.LeagueService
import org.dataloader.DataLoaderRegistry
import org.slf4j.LoggerFactory
import spark.Request
import spark.Response
import java.io.IOException

// Based on https://github.com/ExpediaGroup/graphql-kotlin/blob/master/examples/spark/src/main/kotlin/com/expediagroup/graphql/examples/spark/GraphQLHandler.kt

class GraphQLHandler {

    val logger = LoggerFactory.getLogger(GraphQLHandler::class.java)

    companion object {
        private val configuration = SchemaGeneratorConfig(supportedPackages = listOf("io.leege.fcfinderv2"))
        private val queries = listOf(
            TopLevelObject(ClubsService()),
            TopLevelObject(CountryService()),
            TopLevelObject(LeagueService())
        )

        private val graphQLSchema = toSchema(configuration, queries)
        val graphQL = GraphQL.newGraphQL(graphQLSchema).build()
    }

    private val mapper = jacksonObjectMapper()
    private val dataLoaderRegistry = DataLoaderRegistry()

    /**
     * Get payload from the request.
     */
    private fun getPayload(request: Request): Map<String, Any>? {
        return try {
            logger.info("getPayload: request body = " + request.body())
            mapper.readValue<Map<String, Any>>(request.body())
        } catch (e: IOException) {
            throw IOException("Unable to parse GraphQL payload.")
        }
    }

    /**
     * Get the variables passed in the request.
     */
    private fun getVariables(payload: Map<String, *>) =
        payload.getOrElse("variables") { emptyMap<String, Any>() } as Map<String, Any>

    /**
     * Get any errors and data from [executionResult].
     */
    private fun getResult(executionResult: ExecutionResult): MutableMap<String, Any> {
        val result = mutableMapOf<String, Any>()

        if (executionResult.errors.isNotEmpty()) {
            // if we encounter duplicate errors while data fetching, only include one copy
            result["errors"] = executionResult.errors.distinctBy {
                if (it is ExceptionWhileDataFetching) {
                    it.exception
                } else {
                    it
                }
            }
        }

        try {
            // if data is null, get data will fail exceptionally
            result["data"] = executionResult.getData<Any>()
        } catch (e: Exception) {}

        return result
    }

    /**
     * Execute a query against schema
     */
    fun handle(request: Request, response: Response): String? {
        val payload = getPayload(request)

        return payload?.let {
            // Execute the query against the schema

            val executionResult = graphQL.executeAsync(
                ExecutionInput.Builder()
                    .query(payload["query"].toString())
                    .variables(getVariables(payload))
                    .dataLoaderRegistry(dataLoaderRegistry)
            ).get()
            val result = getResult(executionResult)

            // write response as json
            response.type("application/json")
            return@let mapper.writeValueAsString(result)
        }
    }
}