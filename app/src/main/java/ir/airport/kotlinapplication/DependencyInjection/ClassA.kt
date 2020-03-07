package ir.airport.kotlinapplication.DependencyInjection

import retrofit2.Retrofit
import javax.inject.Inject

// baraye estefade az Dagger dar sakht Constructor ha va instance ha az @Inject constructor estefade mikonim
class ClassA @Inject constructor(b:ClassB,retrofit: Retrofit) {
}