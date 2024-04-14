package dev.nekro.countryapp.domain.models

data class CountryDetails(
    val countryName: String,
    val capital: List<String>,
    val region: String,
    val imageUrl: String,
    val continent: List<String>,
    val country: Country
)
