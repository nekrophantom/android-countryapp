package dev.nekro.countryapp.presentation.navigation

sealed class Screen (val route: String) {
    object CountryScreen: Screen("country_screen")
    object CountryDetailScreen: Screen("country_detail_screen")
}