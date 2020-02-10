package ir.airport.kotlinapplication

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("TAG", "dfdg@jhj".AviationFormat())
        Log.d("TAG1", "0492644".isValidIranianNationalCode().toString())
        //if(!this.isInternetAvailable()){
           // this.showToast("No Internet access", Toast.LENGTH_LONG)
        //}
        val img:Image
        val currentTime1: String =
            SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
            //val currectTime1:Date=Calendar.getInstance().getTime();
        currentTime.text=currentTime1
        val hour: String =
            SimpleDateFormat("HH", Locale.getDefault()).format(Date())
        //val currectTime1:Date=Calendar.getInstance().getTime();
        currentTime.text=currentTime1
        Log.d("TAG",hour)
        if (hour=="00"||hour=="01"||hour=="02"||hour=="03"||hour=="04"||hour=="05"||hour=="06"){
           imgDay.setImageResource(getResources().getIdentifier("mid", "drawable", getPackageName()))
        }else if (hour=="07"||hour=="08"||hour=="09"||hour=="10"||hour=="11"){
            imgDay.setImageResource(getResources().getIdentifier("day", "drawable", getPackageName()))
        }else if (hour=="12"||hour=="13"||hour=="14"||hour=="15"){
            imgDay.setImageResource(getResources().getIdentifier("zohr", "drawable", getPackageName()))
        }else if (hour=="16"||hour=="17"||hour=="18"||hour=="19"){
            imgDay.setImageResource(getResources().getIdentifier("ghoroob", "drawable", getPackageName()))
        }else if (hour=="20"||hour=="21"||hour=="22"||hour=="23"){
            imgDay.setImageResource(getResources().getIdentifier("shab", "drawable", getPackageName()))
        }


        btnMenu.setOnClickListener{
            try {

                drawer.openDrawer(GravityCompat.END)

            }
            catch (e:Exception){
                Log.d("myMain", e.message)
            }

            var clickListener: (String)->Unit={
               this.showToast("Show "+ it+ " Activity")
                if (it=="اوقات شرعی"){
                    val i = Intent(this, CalenderActivity::class.java)
                    startActivity(i)
                }

            }

            val lstMenuItems = arrayListOf<String>("اوقات شرعی", "پروفایل", "درباره ما","تنظیمات")
            val  myAdapter = RecyclerAdapter(lstMenuItems,clickListener)
            recyclermenu.adapter=myAdapter


        }

    }
}
