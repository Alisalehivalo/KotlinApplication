package ir.airport.kotlinapplication.MVVM

import io.reactivex.Observable
import ir.airport.kotlinapplication.pojo.AladhanResponseModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class MvvmModel {

   fun setAdhan():observableInterface {
       val retrofit = Retrofit.Builder()
           .baseUrl("https://api.aladhan.com/v1/")
           .addConverterFactory(GsonConverterFactory.create())
           .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
           .build()
       return retrofit.create(observableInterface::class.java)
   }

    fun setAdhanObservable(country: String, city: String):Observable<AladhanResponseModel>
    {
    return setAdhan().getTimings(city,country,8)
    }

}