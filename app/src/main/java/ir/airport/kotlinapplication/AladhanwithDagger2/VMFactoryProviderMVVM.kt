package ir.airport.kotlinapplication.AladhanwithDagger2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class VMFactoryProviderMVVM @Inject constructor(val model: AladhanDaggerModel) : ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(DaggerViewModelAladhan::class.java) ->
                return DaggerViewModelAladhan(model) as T

            else -> throw IllegalArgumentException("ViewModel Is not provided")
        }
    }
}