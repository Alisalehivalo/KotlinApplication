package ir.airport.kotlinapplication.DIandDagger2

import io.reactivex.Observable
import javax.inject.Inject

class DaggerModel @Inject constructor() {

    fun getObservable() : Observable<String> {
        return Observable.just("Ali Akbar Salehi")
    }
}