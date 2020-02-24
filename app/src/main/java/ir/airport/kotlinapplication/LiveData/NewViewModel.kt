package ir.airport.kotlinapplication.LiveData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewViewModel : ViewModel() {
    //tarif livedata
   private val data=MutableLiveData<String?>()
    fun setData(s:String){
        data.value=s
    }
    //chon farzand az parent MutableLiveData ast mitavanad LiveData beshavad
    fun getLiveData() : LiveData<String?> = data
}