package dev.nekro.countryapp.data.repository

import dev.nekro.countryapp.data.dto.CountryList
import dev.nekro.countryapp.data.remote.CountryApiService
import dev.nekro.countryapp.domain.repository.CountryRepository

class CountryRepositoryImpl(private val apiService: CountryApiService) : CountryRepository {
    override suspend fun getAllCountry(): CountryList {
        return apiService.getAllCountries()
    }

    override suspend fun getCountryByName(name: String): CountryList {
        return apiService.getCountryByName(name = name)
    }

    override suspend fun getAllCountriesByName(name: String): CountryList {
        return apiService.getCountriesByName(name)
    }
}