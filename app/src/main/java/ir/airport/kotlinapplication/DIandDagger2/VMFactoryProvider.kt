package ir.airport.kotlinapplication.DIandDagger2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
//classi ke baraye sakhtan dependency haye ViewModel ijad mishavad
//bayad harchizi ke mikhay to VM be onvan constructor pass bedi bayad inja tarifesh bokoni mesl DaggerModel
//chon VM daraye voroodi hast bayad ViewModelProvider.Factory ra implement konid
class VMFactoryProvider @Inject constructor(val model: DaggerModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(DaggerViewModel::class.java) ->
                return DaggerViewModel(model) as T

            else -> throw IllegalArgumentException("ViewModel Is not provided")
        }
    }
}