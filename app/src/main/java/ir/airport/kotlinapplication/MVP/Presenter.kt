package ir.airport.kotlinapplication.MVP

import kotlinx.android.synthetic.main.activity_main.*

class Presenter (private val view: Contract.View) : Contract.Presenter{

    private val model =Model(this)
//2. Data az fun getCityCountry view daryaft mishe va be fun setAdhan dar model pass dade mishavad
    override fun showAdhan(){
        val (city,country)=view.getCityCountry()
        return model.setAdhan(city,country)

    }
    //4.1error Error az fun setAdhan model daryaft va be fun showError dar view pass dade mishavad
    override fun receiveError(t:String){
        return view.showError(t)
    }

    //5.1show Data daryafti az fun setAdhan az model daryaft va be marhale 5.2show fun setTiming dar view pass dade mishe
    override fun getAdhan(sunRise:String, sunSet:String,fajr:String,imsak:String,
                          maghrib:String,isha:String,zuhr:String,midNight:String,asr:String){
        view.setTiming(sunRise,sunSet,fajr,imsak,maghrib,isha,zuhr,midNight, asr)
    }



}
