package dev.nekro.countryapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.nekro.countryapp.data.remote.CountryApiService
import dev.nekro.countryapp.data.repository.CountryRepositoryImpl
import dev.nekro.countryapp.domain.repository.CountryRepository
import dev.nekro.countryapp.domain.use_case.CountryUseCase
import dev.nekro.countryapp.domain.use_case.GetCountries
import dev.nekro.countryapp.domain.use_case.GetCountriesByName
import dev.nekro.countryapp.domain.use_case.GetCountryDetails
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun provideCountryApiService() : CountryApiService {
        return Retrofit.Builder()
            .baseUrl("https://restcountries.com/v3.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountryApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCountryRepository(apiService: CountryApiService) : CountryRepository {
        return CountryRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideCountryUseCase(repository: CountryRepository) : CountryUseCase {
        return CountryUseCase(
            getCountries = GetCountries(repository),
            getCountriesByName = GetCountriesByName(repository),
            getCountryDetails = GetCountryDetails(repository),
        )
    }

}