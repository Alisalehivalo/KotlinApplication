package ir.airport.kotlinapplication.AladhanwithDagger2

import io.reactivex.Observable
import ir.airport.kotlinapplication.MVVM.observableInterface
import ir.airport.kotlinapplication.pojo.AladhanResponseModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class AladhanDaggerModel @Inject constructor() {

    fun setAdhanDagger(): observableDaggerInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.aladhan.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(observableDaggerInterface::class.java)
    }

    fun setAdhanDaggerObservable(country: String, city: String):Observable<AladhanResponseModel>
    {
        return setAdhanDagger().getTimings(city,country,8)
    }

}