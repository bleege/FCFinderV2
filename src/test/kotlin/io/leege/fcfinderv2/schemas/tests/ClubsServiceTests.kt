package io.leege.fcfinderv2.schemas.tests

import io.leege.fcfinderv2.schemas.ClubsService
import junit.framework.TestCase.*
import org.junit.Test

class ClubsServiceTests {

    @Test
    fun testGetAllClubs() {
        val mock = DataServiceMock()
        val clubsService = ClubsService(dataService = mock)
        val clubs = clubsService.getAllClubs()
        assertEquals(false, clubs.isEmpty())
        assertEquals(2, clubs.count())
        val club = clubs[0]
        assertEquals(1, club.id)
        assertNotNull(club.country)
        assertEquals(1, club.country.id)
        assertEquals("Ireland", club.country.name)
        assertEquals("Cork City", club.name)
        assertEquals("Turners Cross", club.stadiumName)
        assertEquals(51.885528, club.latitude)
        assertEquals(-8.46775, club.longitude)
    }

    @Test
    fun testGetClubsByLeagueAndYear() {
        val mock = DataServiceMock()
        val clubsService = ClubsService(dataService = mock)
        val clubs = clubsService.getClubsByLeagueAndYear(1, 2020)
        assertEquals(false, clubs.isEmpty())
        assertEquals(1, clubs.count())
        val club = clubs[0]
        assertEquals(1, club.id)
        assertNotNull(club.country)
        assertEquals(1, club.country.id)
        assertEquals("Ireland", club.country.name)
        assertEquals("Cork City", club.name)
        assertEquals("Turners Cross", club.stadiumName)
        assertEquals(51.885528, club.latitude)
        assertEquals(-8.46775, club.longitude)
    }

}