package io.leege.fcfinderv2.schemas.tests

import io.leege.fcfinderv2.schemas.ClubsService
import junit.framework.TestCase.assertTrue
import org.junit.Test

class ClubsServiceTests {

    @Test
    fun testGetAllClubs() {
        val mock = DataServiceMock()
        val clubsService = ClubsService(dataService = mock)
        val clubs = clubsService.getAllClubs()
        assertTrue(clubs.isNotEmpty())
    }

}