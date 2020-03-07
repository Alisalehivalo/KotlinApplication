package ir.airport.kotlinapplication.DependencyInjection

import javax.inject.Inject

class ClassB @Inject constructor(c:ClassC, d:ClassD) {
}