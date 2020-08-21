package io.leege.fcfinderv2.schemas.tests

import io.leege.fcfinderv2.schemas.LeagueService
import junit.framework.TestCase.assertEquals
import org.junit.Test

class LeagueServiceTests {

    @Test
    fun testGetAllLeagues() {
        val mock = DataServiceMock()
        val service = LeagueService(dataService = mock)
        val leagues = service.getAllLeagues()
        assertEquals(2, leagues.count())
        val league = leagues[0]
        assertEquals(1, league.id)
        assertEquals("Premier Division", league.name)
        assertEquals(1, league.division)
        assertEquals("UEFA", league.confederation)
        assertEquals(1, league.country.id)
        assertEquals("Ireland", league.country.name)
    }

    @Test
    fun testGetLeagueYears() {
        val mock = DataServiceMock()
        val service = LeagueService(dataService = mock)
        val years = service.getYearsForLeague(1)
        assertEquals(3, years.count())
        assertEquals(2020, years.get(0))
        assertEquals(2021, years.get(1))
        assertEquals(2022, years.get(2))
    }

    @Test
    fun testGetLeaguesByCountry() {
        val mock = DataServiceMock()
        val service = LeagueService(dataService = mock)
        val leagues = service.getLeaguesByCountryId(1)
        assertEquals(1, leagues.count())
        val league = leagues[0]
        assertEquals(1, league.id)
        assertEquals("Premier Division", league.name)
        assertEquals(1, league.division)
        assertEquals("UEFA", league.confederation)
        assertEquals(1, league.country.id)
        assertEquals("Ireland", league.country.name)
    }

}