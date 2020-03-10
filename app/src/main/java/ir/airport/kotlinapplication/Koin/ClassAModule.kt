package ir.airport.kotlinapplication.Koin

import org.koin.dsl.module
import retrofit2.Retrofit

val ClassAModule= module {
    single {ClassB()  }
    single { Retrofit.Builder().baseUrl("https://pouyaheydari.com").build() }
    single { ClassA(get(),get()) }
}