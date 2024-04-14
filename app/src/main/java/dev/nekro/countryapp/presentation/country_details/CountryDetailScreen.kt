package dev.nekro.countryapp.presentation.country_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dev.nekro.countryapp.presentation.core.components.AppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import dev.nekro.countryapp.domain.util.Resource
import dev.nekro.countryapp.presentation.country_details.components.CountryDetailItem
import dev.nekro.countryapp.presentation.navigation.Screen

@Composable
fun CountryDetailScreen(
    navController: NavController,
    viewModel: CountryDetailViewModel = hiltViewModel(),
    countryName: String
) {


    val country = viewModel.detailState.value

    Scaffold (
        topBar = {
            AppBar(
                title = countryName
            ) {
                navController.navigateUp()
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Surface (
                color = Color.LightGray,
                modifier = Modifier.fillMaxSize()
            ) {

                Column {
                    Spacer(modifier = Modifier.height(20.dp))

                    when(country){
                        is Resource.Loading -> {
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                        }
                        is Resource.Error -> {
                            Text(
                                text = country.message,
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }
                        is Resource.Success -> {
                            val countryDetails = country.data
                            LazyColumn {
                                items(countryDetails) { item ->
                                    CountryDetailItem(
                                        countryDetails = item
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