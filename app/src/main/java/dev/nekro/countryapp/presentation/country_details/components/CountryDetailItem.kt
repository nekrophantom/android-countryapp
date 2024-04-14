package dev.nekro.countryapp.presentation.country_details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.nekro.countryapp.domain.models.CountryDetails

@Composable
fun CountryDetailItem(
    countryDetails: CountryDetails
) {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            model = countryDetails.imageUrl,
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = countryDetails.countryName,
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Continent: ${countryDetails.continent[0]}",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Region : ${countryDetails.region}",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Capital : ${countryDetails.capital[0]}",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}