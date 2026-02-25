package org.example.project.presentation
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.project.domain.models.SnowJob

data class DashboardState(
    val jobs: List<SnowJob> = emptyList(),
    val isLoading: Boolean = false
)

class DashboardViewModel : ViewModel() {
    private val _state = MutableStateFlow(DashboardState())
    val state = _state.asStateFlow()

    fun loadJobs() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            // Aglay phase mein yahan Repository se data layenge
            _state.value = _state.value.copy(isLoading = false)
        }
    }
}