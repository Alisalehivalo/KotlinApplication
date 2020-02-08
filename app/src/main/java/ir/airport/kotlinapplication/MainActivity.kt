package ir.airport.kotlinapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("TAG", "dfdg@jhj".AviationFormat())
        Log.d("TAG1", "0492644".isValidIranianNationalCode().toString())
        //if(!this.isInternetAvailable()){
           // this.showToast("No Internet access", Toast.LENGTH_LONG)
        //}

        btnMenu.setOnClickListener{
            try {
                drawer.openDrawer(GravityCompat.START)

            }
            catch (e:Exception){
                Log.d("myMain", e.message)
            }

            var clickListener: (String)->Unit={
               this.showToast("Show "+ it+ " Activity")

            }

            val lstMenuItems = arrayListOf<String>("Contacts", "Calls", "Messages","Setting")
            val  myAdapter = RecyclerAdapter(lstMenuItems,clickListener)
            recyclermenu.adapter=myAdapter


        }

    }
}
