package dev.nekro.countryapp.data.remote

import dev.nekro.countryapp.data.dto.CountryList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CountryApiService {

    @GET("all")
    suspend fun getAllCountries(): CountryList

    @GET("name/{name}")
    suspend fun getCountriesByName(
        @Path("name") name: String,
    ) : CountryList

    @GET("name/{name}")
    suspend fun getCountryByName(
        @Path("name") name: String,
        @Query("fullText") fullText: String = "true",
    ) : CountryList
}