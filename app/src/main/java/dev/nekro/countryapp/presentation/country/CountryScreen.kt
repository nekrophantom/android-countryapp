package dev.nekro.countryapp.presentation.country

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dev.nekro.countryapp.domain.util.Resource
import dev.nekro.countryapp.presentation.country.components.CountryItem
import dev.nekro.countryapp.presentation.country.components.SearchBar
import androidx.compose.material3.Scaffold
import dev.nekro.countryapp.domain.models.Country
import dev.nekro.countryapp.domain.models.CountryDetails
import dev.nekro.countryapp.presentation.core.components.AppBar
import dev.nekro.countryapp.presentation.navigation.Screen


@Composable
fun CountryScreen(
    navController: NavController,
    viewModel: CountryViewModel = hiltViewModel(),
) {

    Scaffold (
        topBar = {
            AppBar(title = "Country App")
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ) {
            Surface (
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.fillMaxSize()
            ) {

                val viewState = viewModel.countryState.value

                Column {
                    Spacer(modifier = Modifier.height(20.dp))

                    SearchBar(
                        hint = "Search...",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        onSearch = { name ->
                            viewModel.searchCountryByName(name)
                        }
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    when(viewState){
                        is Resource.Loading -> {
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                        }
                        is Resource.Error -> {
                            Text(
                                text = viewState.message,
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }
                        is Resource.Success -> {
                            val countries = viewState.data
                            LazyVerticalGrid(
                                modifier = Modifier.fillMaxSize(),
                                columns = GridCells.Fixed(2)
                            ) {
                                items(countries) { country ->
                                    CountryItem(
                                        country = country,
                                        navigateToDetail = {
                                            navController.navigate(Screen.CountryDetailScreen.route+"/$it")
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}