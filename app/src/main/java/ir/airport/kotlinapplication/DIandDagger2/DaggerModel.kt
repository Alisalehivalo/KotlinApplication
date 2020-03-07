package ir.airport.kotlinapplication.DIandDagger2

import io.reactivex.Observable
import javax.inject.Inject

//class model ke daraye methodi hast ke badan be an kar darim pass an ra ba dagger  va di inject mikonim
class DaggerModel @Inject constructor() {

    fun getObservable() : Observable<String> {
        return Observable.just("Ali Akbar Salehi")
    }
}