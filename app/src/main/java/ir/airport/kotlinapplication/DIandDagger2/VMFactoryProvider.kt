package ir.airport.kotlinapplication.DIandDagger2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

// chon VM daraye voroodi ast ma niyaz be factory darim ta in voroodi haro tamin kone
//va chon voroodi be in class mikhahim bedahim ke ham dar in class va class VM be an niyaz darim baraye ijad instance az Dagger Inject estefade mikonim
//pass niyaz be ye component baraye ijad DI bekomak Dagger darim bename FactoryComponent
class VMFactoryProvider @Inject constructor(val model: DaggerModel) : ViewModelProvider.Factory {
    //ye VM ba voroodi modelClass tamin mikonad
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //agar voroodi morednazar ghabel estesas be DaggerVM bood angah DaggerVM(model) rabargardan
        //vagarna peygham error bede
        when {
            modelClass.isAssignableFrom(DaggerViewModel::class.java) ->
                return DaggerViewModel(model) as T

            else -> throw IllegalArgumentException("ViewModel Is not provided")
        }
    }
}