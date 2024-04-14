package dev.nekro.countryapp.data.dto

import dev.nekro.countryapp.domain.models.Country
import dev.nekro.countryapp.domain.models.CountryDetails
import dev.nekro.countryapp.domain.models.Currency
import dev.nekro.countryapp.domain.models.Language

data class CountryListItem(
    val altSpellings: List<String>,
    val area: Double,
    val borders: List<String>,
    val capital: List<String>,
    val capitalInfo: CapitalInfo,
    val car: Car,
    val cca2: String,
    val cca3: String,
    val ccn3: String,
    val cioc: String,
    val coatOfArms: CoatOfArms,
    val continents: List<String>,
    val currencies: Currencies,
    val demonyms: Demonyms,
    val fifa: String,
    val flag: String,
    val flags: Flags,
    val gini: Gini,
    val idd: Idd,
    val independent: Boolean,
    val landlocked: Boolean,
    val languages: Languages,
    val latlng: List<Double>,
    val maps: Maps,
    val name: Name,
    val population: Int,
    val postalCode: PostalCode,
    val region: String,
    val startOfWeek: String,
    val status: String,
    val subregion: String,
    val timezones: List<String>,
    val tld: List<String>,
    val translations: Translations,
    val unMember: Boolean
)

fun CountryListItem.toCountry() : Country {
    return Country(
        countryName = name.common,
        imageUrl = flags.png,
    )
}

fun CountryListItem.toCountryDetails(country: Country) : CountryDetails {
    return CountryDetails(
        countryName = name.common,
        imageUrl = flags.png,
        capital = capital,
        continent = continents,
//        currency = extractCurrency(),
//        languages = extractLanguage(),
        region = region,
        country = country
    )
}
