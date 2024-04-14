package dev.nekro.countryapp.presentation.country

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.nekro.countryapp.domain.models.Country
import dev.nekro.countryapp.domain.use_case.CountryUseCase
import dev.nekro.countryapp.domain.util.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    private val countryUseCase: CountryUseCase,
) : ViewModel() {

    private val _countryState = mutableStateOf<Resource<List<Country>>>(Resource.Loading)
    val countryState: State<Resource<List<Country>>> = _countryState


    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch {
            _countryState.value = countryUseCase.getCountries()
        }
    }

    fun searchCountryByName(name: String) {
        viewModelScope.launch {
            if (name.isNotEmpty()){
                _countryState.value = countryUseCase.getCountriesByName(name)
            } else {
                fetchCountries()
            }
        }
    }

}