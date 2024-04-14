package dev.nekro.countryapp.domain.use_case

import dev.nekro.countryapp.data.dto.toCountry
import dev.nekro.countryapp.domain.models.Country
import dev.nekro.countryapp.domain.repository.CountryRepository
import dev.nekro.countryapp.domain.util.Resource

class GetCountriesByName(private val repository: CountryRepository) {
    suspend operator fun invoke(name: String) : Resource<List<Country>> {
        return try {
            val response = repository.getAllCountriesByName(name).map {
                it.toCountry()
            }
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error( "Please insert valid country name")
        }
    }
}