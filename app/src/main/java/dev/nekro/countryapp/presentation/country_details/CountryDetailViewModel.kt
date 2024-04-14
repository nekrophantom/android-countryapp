package dev.nekro.countryapp.presentation.country_details

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.nekro.countryapp.domain.models.CountryDetails
import javax.inject.Inject
import dev.nekro.countryapp.domain.use_case.CountryUseCase
import dev.nekro.countryapp.domain.util.Resource
import kotlinx.coroutines.launch

@HiltViewModel
class CountryDetailViewModel @Inject constructor(
    private val countryUseCase: CountryUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _detailState = mutableStateOf<Resource<List<CountryDetails>>>(Resource.Loading)
    val detailState: State<Resource<List<CountryDetails>>> = _detailState

    init {
        savedStateHandle.get<String>("name")?.let {  name ->
            getCountryDetails(name)
        }
    }

    private fun getCountryDetails(name: String) {
        viewModelScope.launch {
            _detailState.value = countryUseCase.getCountryDetails(name)
        }
    }

}