package ir.airport.kotlinapplication.MVP

import kotlinx.android.synthetic.main.activity_main.*

class Presenter (private val view: Contract.View) : Contract.Presenter {

    private val model = Model(this)
    val hour1 = model.ShowCurrentHour()
    override fun Set(hour1: String) {


    }


}
