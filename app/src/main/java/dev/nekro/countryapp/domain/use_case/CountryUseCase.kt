package dev.nekro.countryapp.domain.use_case

data class CountryUseCase(
    val getCountries: GetCountries,
    val getCountriesByName: GetCountriesByName,
    val getCountryDetails: GetCountryDetails
)