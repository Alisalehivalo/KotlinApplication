package ir.airport.kotlinapplication.DIandDagger2

import io.reactivex.Observable
import javax.inject.Inject

//class model ke daraye inke dar VMFactoryProvider be onvan voroodi be an niyaz darim pas ba  Dagger Inject mikonim
class DaggerModel @Inject constructor() {
// baraye sakhtan observable dar Model
    fun getObservable() : Observable<String> {
        return Observable.just("Ali Akbar Salehi")
    }
}