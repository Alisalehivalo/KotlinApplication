package ir.airport.kotlinapplication.DIandDagger2

import dagger.Component

@Component
interface FactoryComponent {
    fun provideVMFactory():VMFactoryProvider
}