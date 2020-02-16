package ir.airport.kotlinapplication.MVP

interface Contract {
    interface View {
        fun getCityCountry():Pair<String,String>
        fun setTiming(sunRise:String,sunSet:String)
        fun showError(t:String)

    }

    interface Presenter {
        fun showAdhan()
        fun receiveError(t:String)
        fun getAdhan(sunRise:String,sunSet:String)


    }

}