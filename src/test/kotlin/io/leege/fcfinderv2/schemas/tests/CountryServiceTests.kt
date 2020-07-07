package io.leege.fcfinderv2.schemas.tests

import io.leege.fcfinderv2.schemas.CountryService
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CountryServiceTests {

    @Test
    fun testGetAllCountries() {
        val mock = DataServiceMock()
        val countryService = CountryService(dataService = mock)
        val countries = countryService.getAllCountries()
        assertEquals(false, countries.isEmpty())
        assertEquals(1, countries.count())
        val country = countries[0]
        assertEquals(1, country.id)
        assertEquals("Ireland", country.name)
    }

}