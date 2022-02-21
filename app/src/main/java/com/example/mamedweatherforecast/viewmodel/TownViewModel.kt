package com.example.mamedweatherforecast.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mamedweatherforecast.app.di.viewModelModule
import com.example.mamedweatherforecast.model.repository.WeatherTownRepository
import com.example.mamedweatherforecast.utils.LoadingState
import kotlinx.coroutines.launch

class TownViewModel(private val weatherTownRepository : WeatherTownRepository) : ViewModel() {

    private val _loadingState = MutableLiveData<LoadingState>()

    val loadingState : LiveData<LoadingState>
        get() = _loadingState

    val data = weatherTownRepository.data

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                _loadingState.value = LoadingState.LOADING
                weatherTownRepository.refresh()

                _loadingState.value = LoadingState.LOADED
            }
            catch (ex: Exception) {
                _loadingState.value = LoadingState.error(ex.message)
            }
        }
    }
}