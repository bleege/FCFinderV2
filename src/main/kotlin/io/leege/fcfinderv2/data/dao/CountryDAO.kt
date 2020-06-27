package io.leege.fcfinderv2.data.dao

import io.leege.fcfinderv2.data.tables.Countries
import io.leege.fcfinderv2.schemas.models.Country
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class CountryDAO(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<CountryDAO>(Countries)
    var name by Countries.name

    fun adaptTo(): Country {
        return Country(id = id.value, name = name)
    }
}
