package ir.airport.kotlinapplication.AladhanwithKoin

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val KoinModule= module {
    single {AladhanKoinModel()  }
    viewModel {KoinViewModelAladhan(get())}
}