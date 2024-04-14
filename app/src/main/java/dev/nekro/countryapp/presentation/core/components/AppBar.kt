package dev.nekro.countryapp.presentation.core.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
    onNavigateBack: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp
                )
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primary),
        navigationIcon = {
            if (!title.contains("Country")){
                IconButton(
                    onClick = {
                        onNavigateBack()
                    }
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
        }
    )

}