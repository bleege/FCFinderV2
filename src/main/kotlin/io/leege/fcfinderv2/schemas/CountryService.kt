package io.leege.fcfinderv2.schemas

import io.leege.fcfinderv2.data.DataService

class CountryService(val dataService: DataService = DataService()) {

    fun getAllCountries() = dataService.getAllCountries()

}