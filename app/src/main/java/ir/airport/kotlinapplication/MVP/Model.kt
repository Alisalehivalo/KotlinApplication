package ir.airport.kotlinapplication.MVP

import java.text.SimpleDateFormat
import java.util.*

class Model(private val presenter: Contract.Presenter) {

    fun ShowCurrentTime()=
        SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())

    fun ShowCurrentHour() =
    SimpleDateFormat("HH", Locale.getDefault()).format(Date())

}

