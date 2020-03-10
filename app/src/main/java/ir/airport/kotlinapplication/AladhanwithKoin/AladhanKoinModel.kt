package ir.airport.kotlinapplication.AladhanwithKoin

import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import ir.airport.kotlinapplication.MVVM.observableInterface
import ir.airport.kotlinapplication.pojo.AladhanResponseModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class AladhanKoinModel {


    fun setAdhanKoin(): observableKoinInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.aladhan.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(observableKoinInterface::class.java)
    }

    fun setAdhanKoinObservable(city: String, country: String):Observable<AladhanResponseModel>
    {
        return setAdhanKoin().getTimings(city,country,8)
    }

}