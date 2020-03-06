package ir.airport.kotlinapplication.AladhanwithDagger2

import dagger.Component

@Component
interface FactoryComponentMVVM {
    fun provideVMFactory():VMFactoryProviderMVVM
}