package dev.nekro.countryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import dev.nekro.countryapp.presentation.country.CountryScreen
import dev.nekro.countryapp.presentation.country_details.CountryDetailScreen
import dev.nekro.countryapp.presentation.navigation.Screen
import dev.nekro.countryapp.ui.theme.CountryAppTheme
import dev.nekro.countryapp.presentation.country_details.CountryDetailViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Screen.CountryScreen.route) {
                        composable(Screen.CountryScreen.route) {
                            CountryScreen(
                                navController = navController,
                            )
                        }

                        composable(Screen.CountryDetailScreen.route+"/{name}"){ navBackStackEntry -> 
                            val name = navBackStackEntry.arguments?.getString("name")
                            name?.let { countryName ->
                                CountryDetailScreen(navController = navController, countryName = countryName)
                            }
                        }

                    }

                }
            }
        }
    }
}
