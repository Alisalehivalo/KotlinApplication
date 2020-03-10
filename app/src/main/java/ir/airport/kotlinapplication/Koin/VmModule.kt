package ir.airport.kotlinapplication.Koin

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule= module {
    viewModel {KoinVM(get())}
}