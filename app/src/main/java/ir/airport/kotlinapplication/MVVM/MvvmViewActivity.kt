package ir.airport.kotlinapplication.MVVM

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.reactivex.disposables.CompositeDisposable
import ir.airport.kotlinapplication.R
import kotlinx.android.synthetic.main.activity_mvvm_view.*


class MvvmViewActivity : AppCompatActivity() {
    lateinit var viewmodel:viewModel
    private val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_view)
        viewmodel=ViewModelProvider(this).get(viewModel::class.java)
        progressBar.setVisibility(View.GONE);

        btnS.setOnClickListener {
            progressBar.setVisibility(View.VISIBLE);
            viewmodel.setOnClick(getCityCountry().first,getCityCountry().second)
            viewmodel.getLiveData().observe(this, Observer {
                sunRiseMvvm.text=it.Sunrise.toString()
                sunSetMvvm.text=it.Sunset.toString()
                fajrMvvm.text=it.Fajr.toString()
                imsakMvvm.text=it.Imsak.toString()
                dhuhrMvvm.text=it.Dhuhr.toString()
                maghribMvvm.text=it.Maghrib.toString()
                asrMvvm.text=it.Asr.toString()
                ishaMvvm.text=it.Isha.toString()
                midNightMvvm.text=it.Midnight.toString()
                progressBar.setVisibility(View.GONE);
            })


        }

    }

    fun getCityCountry():Pair<String,String>{
        val city=cityMvvm.text.toString()
        val country=countryMvvm.text.toString()
        return city to country
    }

     fun showdata()
     {
         sunSetMvvm.text=viewmodel.setOnClick(getCityCountry().first,getCityCountry().second).toString()


     }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}
