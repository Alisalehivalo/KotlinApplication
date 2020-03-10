package ir.airport.kotlinapplication.Koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ir.airport.kotlinapplication.R
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class KoinActivity : AppCompatActivity() {
private val classA:ClassA by inject()
    val vm:KoinVM by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_koin)
        Log.d("TAG",classA.getNmae())
    }
}
