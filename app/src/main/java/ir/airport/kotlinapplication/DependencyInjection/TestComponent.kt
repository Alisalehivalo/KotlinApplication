package ir.airport.kotlinapplication.DependencyInjection

import dagger.Component
import dagger.Module

// ijad ye Component az jens Dagger baraye sakht Instance Class hayi ke beheshoon niyaz darim
//baraye oon componenti ke mikhahid Retrofit estefade shavad modul ezafe mishavad
@Component(modules = [TestModule::class])
interface TestComponent {
    //ijad darkhast be Dagger baraye sakhtan ye instance az Class A
    fun provideA() :ClassA
}