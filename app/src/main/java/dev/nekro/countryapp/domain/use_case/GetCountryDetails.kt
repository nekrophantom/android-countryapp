package dev.nekro.countryapp.domain.use_case

import dev.nekro.countryapp.data.dto.toCountry
import dev.nekro.countryapp.data.dto.toCountryDetails
import dev.nekro.countryapp.domain.models.CountryDetails
import dev.nekro.countryapp.domain.repository.CountryRepository
import dev.nekro.countryapp.domain.util.Resource

class GetCountryDetails(private val repository: CountryRepository) {
    suspend operator fun invoke(name: String) : Resource<List<CountryDetails>> {
        return try {
            val response = repository.getCountryByName(name).map {
                it.toCountry().let { country ->
                    it.toCountryDetails(country)
                }
            }
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }
}