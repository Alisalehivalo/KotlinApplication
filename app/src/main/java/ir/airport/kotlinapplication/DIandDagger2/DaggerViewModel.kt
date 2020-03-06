package ir.airport.kotlinapplication.DIandDagger2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DaggerViewModel(private val model: DaggerModel) :ViewModel() {
    private val Data = MutableLiveData<String>()
    private val disposable = CompositeDisposable()

    fun getLiveData(): LiveData<String> = Data

    fun getName() {
        disposable.add(
            model.getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Data.value = it
                    Log.d("TAG",it.toString())
                }, {
                    Log.d("TAG", it.message)
                })
        )
    }

    fun clearDisposable(){
        disposable.dispose()
    }


}