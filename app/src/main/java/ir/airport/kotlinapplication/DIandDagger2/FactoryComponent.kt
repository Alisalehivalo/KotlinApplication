package ir.airport.kotlinapplication.DIandDagger2

import dagger.Component
//componenti baraye estefade az class VMFactoryProvider harja lazem shod
@Component
interface FactoryComponent {
    fun provideVMFactory():VMFactoryProvider
}