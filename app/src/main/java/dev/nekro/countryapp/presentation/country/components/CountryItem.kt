package dev.nekro.countryapp.presentation.country.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.nekro.countryapp.domain.models.Country
import dev.nekro.countryapp.domain.models.CountryDetails
import coil.compose.AsyncImage

@Composable
fun CountryItem(
    country: Country,
    modifier: Modifier = Modifier,
    navigateToDetail: (String) -> Unit
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable {
                navigateToDetail(country.countryName)
            }
    ) {

        Column (
            modifier = Modifier.fillMaxSize().padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            AsyncImage(
                model = country.imageUrl,
                contentDescription = null
            )

            Text(
                text = country.countryName,
                style = TextStyle(
                    textAlign = TextAlign.Center
                )
            )

        }

    }

}