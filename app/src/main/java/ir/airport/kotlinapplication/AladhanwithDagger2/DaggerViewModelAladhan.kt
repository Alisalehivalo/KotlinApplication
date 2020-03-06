package ir.airport.kotlinapplication.AladhanwithDagger2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ir.airport.kotlinapplication.pojo.Timings

class DaggerViewModelAladhan(private val model: AladhanDaggerModel) :ViewModel() {
    private val Data = MutableLiveData<Timings>()
    private val disposable = CompositeDisposable()

    fun getLiveData(): LiveData<Timings> = Data

    fun setOnClick(city:String,country:String){
        disposable.add(model.setAdhanDaggerObservable(city,country)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Data.value=it.data.timings


            },{

                Log.d("Error",it.message)

            }))
    }

    fun clearDisposable(){
        disposable.dispose()
    }


}