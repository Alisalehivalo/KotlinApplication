package ir.airport.kotlinapplication.MVVM

import io.reactivex.Observable
import ir.airport.kotlinapplication.pojo.AladhanResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface observableInterface {
    @GET("timingsByCity")
    fun getTimings(@Query("city")city: String,
                   @Query("country")country: String,
                   @Query("method")method: Int): Observable<AladhanResponseModel>
}