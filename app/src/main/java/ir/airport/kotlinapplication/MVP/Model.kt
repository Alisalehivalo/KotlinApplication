package ir.airport.kotlinapplication.MVP

import android.util.Log
import ir.airport.kotlinapplication.RetrofitInterface
import ir.airport.kotlinapplication.pojo.AladhanResponseModel
import kotlinx.android.synthetic.main.activity_calender.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*

class Model(val presenter: Contract.Presenter) {

    //3. Data daryafti city va country az fun showAdhan az presenter daryaft va dar Retrofit rikhte va baraye
    // neshoon dadan error be user be marhale 4.1error fun receiveError dar presenter pass dade mishe
    // va baraye show Adhan be user be marhale 5.1show fun getAdhan dar presenter pass dade mishe
    fun setAdhan(city:String,country:String){
        val retrofit= Retrofit.Builder()
            .baseUrl("https://api.aladhan.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val timingInterface=retrofit.create(RetrofitInterface::class.java)

        timingInterface.getTimings(city,country,8)
            .enqueue(object : Callback<AladhanResponseModel> {
                override fun onFailure(call: Call<AladhanResponseModel>, t: Throwable) {
                    presenter.receiveError(t.toString())

                }

                override fun onResponse(
                    call: Call<AladhanResponseModel>,
                    response: Response<AladhanResponseModel>
                )
                {
                    var sunrise:String=response.body()?.data?.timings?.Sunrise.toString()
                    var sunset:String=response.body()?.data?.timings?.Sunset.toString()
                    presenter.getAdhan(sunrise,sunset)

                }


            })
    }

}

