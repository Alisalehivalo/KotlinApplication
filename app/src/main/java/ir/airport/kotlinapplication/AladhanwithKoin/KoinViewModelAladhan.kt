package ir.airport.kotlinapplication.AladhanwithKoin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ir.airport.kotlinapplication.pojo.Timings

class KoinViewModelAladhan(val model: AladhanKoinModel) :ViewModel() {
    private val DataKoin = MutableLiveData<Timings>()
    private val disposable = CompositeDisposable()

    fun getLiveData(): LiveData<Timings> = DataKoin

    fun setOnClickKoin(city:String,country:String){
        disposable.add(model.setAdhanKoinObservable(city,country)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                DataKoin.value=it.data.timings


            },{

                Log.d("Error",it.message)

            }))
    }

    fun clearDisposable(){
        disposable.dispose()
    }


}