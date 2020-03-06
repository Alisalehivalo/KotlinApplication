package ir.airport.kotlinapplication.AladhanwithDagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.reactivex.disposables.CompositeDisposable
import ir.airport.kotlinapplication.DIandDagger2.DaggerFactoryComponent
import ir.airport.kotlinapplication.DIandDagger2.DaggerViewModel
import ir.airport.kotlinapplication.R
import kotlinx.android.synthetic.main.activity_mvvm_view.*
import kotlinx.android.synthetic.main.activity_mvvm_view.progressBar
import kotlinx.android.synthetic.main.activity_mvvmdagger.*

class MVVMDaggerActivity : AppCompatActivity() {
    lateinit var viewModel: DaggerViewModelAladhan
    private val disposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvmdagger)
        val factory = DaggerFactoryComponentMVVM.create().provideVMFactory()
        viewModel = ViewModelProvider(this, factory).get(DaggerViewModelAladhan::class.java)
        progressBar.setVisibility(View.GONE);

        btnSD.setOnClickListener {
            progressBar.setVisibility(View.VISIBLE);
            viewModel.setOnClick(getCityCountry().first,getCityCountry().second)
            viewModel.getLiveData().observe(this, Observer {
                sunRiseD.text=it.Sunrise.toString()
                sunSetD.text=it.Sunset.toString()
                fajrD.text=it.Fajr.toString()
                imsakD.text=it.Imsak.toString()
                dhuhrD.text=it.Dhuhr.toString()
                maghribD.text=it.Maghrib.toString()
                asrD.text=it.Asr.toString()
                ishaD.text=it.Isha.toString()
                midNightD.text=it.Midnight.toString()
                progressBar.setVisibility(View.GONE);
            })


        }

    }

    fun getCityCountry():Pair<String,String>{
        val city=cityD.text.toString()
        val country=countryD.text.toString()
        return city to country
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}
