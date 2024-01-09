/* package com.example.ecologic.ui.home.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ecologic.R
import com.example.ecologic.model.OrderLine
import com.example.ecologic.model.ChallengeRepo
import com.example.ecologic.model.ChallengebarManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Holds the contents of the cart and allows changes to it.
 *
 * TODO: Move data to Repository so it can be displayed and changed consistently throughout the app.
 */
class CartViewModel(
    private val ChallengebarManager: ChallengebarManager,
    ChallengeRepository: ChallengeRepo
) : ViewModel() {

    private val _orderLines: MutableStateFlow<List<OrderLine>> =
        MutableStateFlow(ChallengeRepository.getCart())
    val orderLines: StateFlow<List<OrderLine>> get() = _orderLines

    // Logic to show errors every few requests
    private var requestCount = 0
    private fun shouldRandomlyFail(): Boolean = ++requestCount % 5 == 0

    fun increaseChallengeCount(ChallengeId: Long) {
        if (!shouldRandomlyFail()) {
            val currentCount = _orderLines.value.first { it.Challenge.id == ChallengeId }.count
            updateChallengeCount(ChallengeId, currentCount + 1)
        } else {
            ChallengebarManager.showMessage(R.string.cart_increase_error)
        }
    }

    fun decreaseChallengeCount(ChallengeId: Long) {
        if (!shouldRandomlyFail()) {
            val currentCount = _orderLines.value.first { it.Challenge.id == ChallengeId }.count
            if (currentCount == 1) {
                // remove Challenge from cart
                removeChallenge(ChallengeId)
            } else {
                // update quantity in cart
                updateChallengeCount(ChallengeId, currentCount - 1)
            }
        } else {
            ChallengebarManager.showMessage(R.string.cart_decrease_error)
        }
    }

    fun removeChallenge(ChallengeId: Long) {
        _orderLines.value = _orderLines.value.filter { it.Challenge.id != ChallengeId }
    }

    private fun updateChallengeCount(ChallengeId: Long, count: Int) {
        _orderLines.value = _orderLines.value.map {
            if (it.Challenge.id == ChallengeId) {
                it.copy(count = count)
            } else {
                it
            }
        }
    }

    /**
     * Factory for CartViewModel that takes ChallengebarManager as a dependency
     */
    companion object {
        fun provideFactory(
            ChallengebarManager: ChallengebarManager = ChallengebarManager,
            ChallengeRepository: ChallengeRepo = ChallengeRepo
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CartViewModel(ChallengebarManager, ChallengeRepository) as T
            }
        }
    }
}

 */
