package ir.airport.kotlinapplication.AladhanwithKoin

import dagger.Component
import io.reactivex.Observable
import ir.airport.kotlinapplication.pojo.AladhanResponseModel
import retrofit2.http.GET
import retrofit2.http.Query


interface observableKoinInterface {
    @GET("timingsByCity")
    fun getTimings(@Query("city")city: String,
                   @Query("country")country: String,
                   @Query("method")method: Int)
                   : Observable<AladhanResponseModel>
}