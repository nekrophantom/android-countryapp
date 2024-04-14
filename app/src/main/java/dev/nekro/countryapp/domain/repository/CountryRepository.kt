package dev.nekro.countryapp.domain.repository

import dev.nekro.countryapp.data.dto.CountryList

interface CountryRepository {

    suspend fun getAllCountry(): CountryList

    suspend fun getAllCountriesByName(name: String): CountryList

    suspend fun getCountryByName(name: String): CountryList

}