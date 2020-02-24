package ir.airport.kotlinapplication.MVVMTest

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class ViewModelTest : ViewModel() {
    var userName=""
    //sakht instance az model va meghdar dehi
    private val model=ModelMVVMTest()
    //ijad insnance az compositeDisposable baraye ijad rabete beyn emit va thread main
    val disposal=CompositeDisposable()
    //sakht livedata
    val userResponce=MutableLiveData<String>()
    val userError=MutableLiveData<String>()
    //tarif subscribe observable ke dar model sakhtim
    fun getUserData(id:Int){
       //add ye rabete amn beyn emit ha
        disposal.add(
            //tayin observable
        model.getUser(id)
                //for manage emit on schedulling on thread
                // 2 ta dastoor darim subscribeon (baraye schule operator balaye on) / observeon(baraye schedule operator payin an)
            //az method haye shedule yeki schedule.io (baraye data interaction) va androidschedulers.mainthread (baraye user interaction in main therad)
            .observeOn(AndroidSchedulers.mainThread())
                //emit observable
            .subscribe({
                //entekhal data ba live data az vm
                userResponce.value=it
            },{
                userError.value="Error"
                Log.d("TAG",it.message)
            })
        )
    }
// paksazi thread main az emission
    override fun onCleared() {
        super.onCleared()
        disposal.clear()
    }

}