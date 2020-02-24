package ir.airport.kotlinapplication.RxJava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jakewharton.rxbinding3.widget.textChanges
import ir.airport.kotlinapplication.R
import kotlinx.android.synthetic.main.activity_rx_binding.*
import java.util.concurrent.TimeUnit

class RxBindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_binding)
        edtLocation
                //for view text changes in editview
            .textChanges()
                // be sharti ke len reshte bish az 2 char bashe
            .filter({
                it.length >2
            })
                // vaghti bad type 1 second vaghfe oftad
            .debounce(1,TimeUnit.SECONDS)
            .subscribe({
                Log.d("Rxbinding",it.toString())
            },{
                Log.d("Rxbinding",it.message)
            })
    }
}
