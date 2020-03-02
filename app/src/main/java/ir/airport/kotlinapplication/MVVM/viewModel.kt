package ir.airport.kotlinapplication.MVVM

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ir.airport.kotlinapplication.pojo.Timings
import kotlinx.android.synthetic.main.activity_mvvm_view.*


class viewModel : ViewModel() {
    val model=MvvmModel()
    val disposable=CompositeDisposable()
    private val responce= MutableLiveData<Timings>()
    private val error= MutableLiveData<String?>()

    fun setOnClick(city:String,country:String){
        disposable.add(model.setAdhanObservable(city,country)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responce.value=it.data.timings
                Log.d("RESULT",responce.toString())
            },{
                error.value=it.message
                Log.d("Error",it.message)

            }))
    }

    fun getLiveData() : LiveData<Timings> = responce


    fun clearDisposable(){
        disposable.dispose()
    }




    }
