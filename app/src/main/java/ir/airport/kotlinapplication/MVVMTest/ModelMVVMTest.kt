package ir.airport.kotlinapplication.MVVMTest

import io.reactivex.Observable
import java.util.*
import java.util.concurrent.TimeUnit

class ModelMVVMTest {
    // tarif observable from local or database or retrofit
    fun getUser(id:Int)= Observable
            //add items with just
        .just("Akbar","saman","peyman")
            //delay on emit with delay
        .delay(1,TimeUnit.SECONDS)
}