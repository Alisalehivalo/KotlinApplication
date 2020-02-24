package ir.airport.kotlinapplication.RxJava

import io.reactivex.Observable

class TestRxClass {

    fun getObservable() : Observable<Int> {
        return Observable.just(5,4,10,1,9)
    }
}