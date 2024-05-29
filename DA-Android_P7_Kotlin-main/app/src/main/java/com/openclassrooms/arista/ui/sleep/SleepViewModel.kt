package com.openclassrooms.arista.ui.sleep

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openclassrooms.arista.domain.model.Sleep
import com.openclassrooms.arista.domain.usecase.GetAllSleepsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SleepViewModel @Inject constructor(
    private val getAllSleepsUseCase: GetAllSleepsUseCase
) : ViewModel() {

    private val _sleepFkey = MutableStateFlow<Long?>(null)
    val sleepFk: StateFlow<Long?> = _sleepFkey.asStateFlow()

    private val _sleeps = MutableStateFlow<List<Sleep>>(emptyList())
    val sleeps: StateFlow<List<Sleep>> = _sleeps.asStateFlow()

    fun fetchSleeps(userId: Long) {
        viewModelScope.launch {
            try {
                _sleepFkey.value = userId
                val sleepList = getAllSleepsUseCase.execute(userId)
                _sleeps.value = sleepList
            } catch (e: Exception) {
                // Handle exceptions if necessary
                e.printStackTrace()
            }
        }
    }
}
