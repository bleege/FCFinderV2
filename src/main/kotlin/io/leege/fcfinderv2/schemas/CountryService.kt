package io.leege.fcfinderv2.schemas

import io.leege.fcfinderv2.data.DataService
import io.leege.fcfinderv2.data.DataServiceImpl

class CountryService(val dataService: DataService = DataServiceImpl()) {

    fun getAllCountries() = dataService.getAllCountries()

}