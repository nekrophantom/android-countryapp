package dev.nekro.countryapp.domain.use_case

import android.util.Log
import dev.nekro.countryapp.data.dto.toCountry
import dev.nekro.countryapp.domain.models.Country
import dev.nekro.countryapp.domain.repository.CountryRepository
import dev.nekro.countryapp.domain.util.Resource

class GetCountries(private val repository: CountryRepository) {
    suspend operator fun invoke() : Resource<List<Country>> {
        return try {
            val response = repository.getAllCountry().map {
                it.toCountry()
            }
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }
}