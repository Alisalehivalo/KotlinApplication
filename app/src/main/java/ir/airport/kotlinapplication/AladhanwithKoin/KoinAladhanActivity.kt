package ir.airport.kotlinapplication.AladhanwithKoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import io.reactivex.disposables.CompositeDisposable
import ir.airport.kotlinapplication.R
import kotlinx.android.synthetic.main.activity_koin_aladhan.*
import kotlinx.android.synthetic.main.activity_mvvm_view.*
import kotlinx.android.synthetic.main.activity_mvvm_view.progressBar
import org.koin.android.viewmodel.ext.android.viewModel

class KoinAladhanActivity : AppCompatActivity() {

    val vm:KoinViewModelAladhan by viewModel()
    private val disposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_koin_aladhan)
        progressBar.setVisibility(View.GONE);
        btnSK.setOnClickListener {
            progressBar.setVisibility(View.VISIBLE);
            vm.setOnClickKoin(getCityCountry().first,getCityCountry().second)
            vm.getLiveData().observe(this, Observer {
                sunRiseKoin.text=it.Sunrise.toString()
                sunSetKoin.text=it.Sunset.toString()
                fajrKoin.text=it.Fajr.toString()
                imsakKoin.text=it.Imsak.toString()
                dhuhrKoin.text=it.Dhuhr.toString()
                maghribKoin.text=it.Maghrib.toString()
                asrKoin.text=it.Asr.toString()
                ishaKoin.text=it.Isha.toString()
                midNightKoin.text=it.Midnight.toString()
                progressBar.setVisibility(View.GONE);
            })


        }

    }

    fun getCityCountry():Pair<String,String>{
        val city=cityK.text.toString()
        val country=countryK.text.toString()
        return city to country
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}
