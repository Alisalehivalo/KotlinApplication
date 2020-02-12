package ir.airport.kotlinapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import ir.airport.kotlinapplication.pojo.AladhanResponseModel
import kotlinx.android.synthetic.main.activity_calender.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
// View
class CalenderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender)
        //val city1:String=city.text.toString()
        //val country1:String=country.text.toString()


        btnSearch.setOnClickListener(View.OnClickListener {

            val city1=findViewById<EditText>(R.id.city)
            val country1=findViewById<EditText>(R.id.country)
            val retrofit=Retrofit.Builder()
                .baseUrl("https://api.aladhan.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val timingInterface=retrofit.create(RetrofitInterface::class.java)
            timingInterface.getTimings(city1.text.toString(),country1.text.toString(),8)
                .enqueue(object :Callback<AladhanResponseModel>{
                    override fun onFailure(call: Call<AladhanResponseModel>, t: Throwable) {
                        Log.d("TAG",t.message)

                    }

                    override fun onResponse(
                        call: Call<AladhanResponseModel>,
                        response: Response<AladhanResponseModel>)
                    {
                        var sunrise:String=response.body()?.data?.timings?.Sunrise.toString()
                        var sunset:String=response.body()?.data?.timings?.Sunset.toString()
                        var fajr1:String=response.body()?.data?.timings?.Fajr.toString()
                        var imsak1:String=response.body()?.data?.timings?.Imsak.toString()
                        var dhuhr1:String=response.body()?.data?.timings?.Dhuhr.toString()
                        var asr1:String=response.body()?.data?.timings?.Asr.toString()
                        var maghrib1:String=response.body()?.data?.timings?.Maghrib.toString()
                        var isha1:String=response.body()?.data?.timings?.Isha.toString()
                        var mid1:String=response.body()?.data?.timings?.Midnight.toString()

                        sunRise.text=sunrise
                        sunSet.text=sunset
                        fajr.text=fajr1
                        imsak.text=imsak1
                        dhuhr.text=dhuhr1
                        asr.text=asr1
                        maghrib.text=maghrib1
                        isha.text=isha1
                        midNight.text=mid1


                    }

                })
            Log.d("TAG",city1.text.toString())
            Log.d("TAG",country1.text.toString())
        })


    }
}
