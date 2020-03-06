package ir.airport.kotlinapplication.DIandDagger2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class VMFactoryProvider @Inject constructor(val model: DaggerModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(DaggerViewModel::class.java) ->
                return DaggerViewModel(model) as T

            else -> throw IllegalArgumentException("ViewModel Is not provided")
        }
    }
}