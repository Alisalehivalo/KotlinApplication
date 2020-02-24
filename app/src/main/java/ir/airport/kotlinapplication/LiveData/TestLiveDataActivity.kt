package ir.airport.kotlinapplication.LiveData

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import ir.airport.kotlinapplication.R
import kotlinx.android.synthetic.main.activity_test_live_data.*

class TestLiveDataActivity : AppCompatActivity() {
lateinit var viewModel: NewViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_live_data)
        viewModel=ViewModelProvider(this).get(NewViewModel::class.java)
        //ijad ertebat live data
        viewModel.getLiveData().observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_LONG).show()
        })
        btnSave1.setOnClickListener(){
            viewModel.setData("Some Data!")
        }

    }
}
