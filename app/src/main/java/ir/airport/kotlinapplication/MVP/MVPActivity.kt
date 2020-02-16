package ir.airport.kotlinapplication.MVP

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import ir.airport.kotlinapplication.R
import kotlinx.android.synthetic.main.activity_mvp.*

class MVPActivity: AppCompatActivity(), Contract.View {
    private val presenter : Contract.Presenter = Presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)
        btnSearch.setOnClickListener( ){
            presenter.showAdhan()
        }

    }
    //1. Data City va Country Daryaft mishe va be fun showAdhan dar presenter pass dade mishavad
    override fun getCityCountry():Pair<String,String>{
        val city=cityMvp.text.toString()
        val country=countryMvp.text.toString()
        return city to country
    }

    //5.2show Data daryafti az marhale 5.1show fun getAdhan dar presenter daryaft va be user neshoon dade mishe
    override fun setTiming(sunRise:String, sunSet:String,fajr:String,imsak:String,
                           maghrib:String,isha:String,zuhr:String,midNight:String,asr:String){
        sunRiseMvp.text=sunRise
        sunSetMvp.text=sunSet
        fajrMvp.text=fajr
        imsakMvp.text=imsak
        maghribMvp.text=maghrib
        ishaMvp.text=isha
        dhuhrMvp.text=zuhr
        midNightMvp.text=midNight
        asrMvp.text=asr
    }
    //4.2error Error daryafti az marhale 4.1error fun receiveError az presenter daryaft va be shekl Toast neshoon dade mishe
    override fun showError(t:String){
        Toast.makeText(this,t.toString(),Toast.LENGTH_LONG).show()
    }

}
