package com.example.dessertclicker

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.model.Dessert
import com.example.dessertclicker.model.DessertUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel : ViewModel() {
    // Внутреннее изменяемое состояние
    private val _uiState = MutableStateFlow(DessertUiState())
    // Публичное неизменяемое состояние для UI
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

    // Здесь будут методы для обработки действий пользователя
    fun onDessertClicked() {
        _uiState.update { currentState ->
            val newDessertsSold = currentState.dessertsSold + 1
            val newRevenue = currentState.revenue + getCurrentDessertPrice(currentState.currentDessertIndex)

            // Логика обновления текущего десерта (например, каждые N продаж)
            val newDessertIndex = if (newDessertsSold % 5 == 0) {
                (currentState.currentDessertIndex + 1) % getDessertsList().size
            } else {
                currentState.currentDessertIndex
            }

            currentState.copy(
                revenue = newRevenue,
                dessertsSold = newDessertsSold,
                currentDessertIndex = newDessertIndex
            )
        }
    }

    private fun getCurrentDessertPrice(index: Int): Int {
        // ... возвращает цену десерта по индексу
    }

    private fun getDessertsList(): List<Dessert> {
        // ... возвращает список десертов
    }
}